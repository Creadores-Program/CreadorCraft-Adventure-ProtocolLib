export class ByteBuf {
    private buffer: Uint8Array;
    private view: DataView;
    private offset: number = 0;

    constructor(dataOrCapacity: number | Uint8Array | ArrayBuffer = 256) {
        if (typeof dataOrCapacity === 'number') {
            this.buffer = new Uint8Array(dataOrCapacity);
            this.view = new DataView(this.buffer.buffer, this.buffer.byteOffset, this.buffer.byteLength);
        } else if (dataOrCapacity instanceof Uint8Array) {
            this.buffer = dataOrCapacity;
            this.view = new DataView(dataOrCapacity.buffer, dataOrCapacity.byteOffset, dataOrCapacity.byteLength);
        } else {
            this.buffer = new Uint8Array(dataOrCapacity);
            this.view = new DataView(dataOrCapacity);
        }
    }

    private ensureWritable(additionalBytes: number): void {
        const required = this.offset + additionalBytes;
        if (required > this.buffer.length) {
            let newCapacity = this.buffer.length * 2;
            if (newCapacity < required) {
                newCapacity = required;
            }
            const newBuffer = new Uint8Array(newCapacity);
            newBuffer.set(this.buffer);
            this.buffer = newBuffer;
            this.view = new DataView(newBuffer.buffer, newBuffer.byteOffset, newBuffer.byteLength);
        }
    }

    public readableBytes(): number {
        return this.buffer.length - this.offset;
    }

    public getOffset(): number {
        return this.offset;
    }

    public setOffset(offset: number): void {
        this.offset = offset;
    }

    public toUint8Array(): Uint8Array {
        return this.buffer.subarray(0, this.offset);
    }

    public writeByte(value: number): this {
        this.ensureWritable(1);
        this.view.setInt8(this.offset, value);
        this.offset += 1;
        return this;
    }

    public writeUnsignedByte(value: number): this {
        this.ensureWritable(1);
        this.view.setUint8(this.offset, value);
        this.offset += 1;
        return this;
    }

    public writeShort(value: number): this {
        this.ensureWritable(2);
        this.view.setInt16(this.offset, value, false);
        this.offset += 2;
        return this;
    }

    public writeUnsignedShort(value: number): this {
        this.ensureWritable(2);
        this.view.setUint16(this.offset, value, false);
        this.offset += 2;
        return this;
    }

    public writeInt(value: number): this {
        this.ensureWritable(4);
        this.view.setInt32(this.offset, value, false);
        this.offset += 4;
        return this;
    }

    public writeUnsignedInt(value: number): this {
        this.ensureWritable(4);
        this.view.setUint32(this.offset, value, false);
        this.offset += 4;
        return this;
    }

    public writeLong(value: bigint): this {
        this.ensureWritable(8);
        this.view.setBigInt64(this.offset, value, false);
        this.offset += 8;
        return this;
    }

    public writeFloat(value: number): this {
        this.ensureWritable(4);
        this.view.setFloat32(this.offset, value, false);
        this.offset += 4;
        return this;
    }

    public writeDouble(value: number): this {
        this.ensureWritable(8);
        this.view.setFloat64(this.offset, value, false);
        this.offset += 8;
        return this;
    }

    public writeString(str: string): this {
        const encoder = new TextEncoder();
        const encoded = encoder.encode(str);
        this.writeUnsignedShort(encoded.length);
        this.ensureWritable(encoded.length);
        this.buffer.set(encoded, this.offset);
        this.offset += encoded.length;
        return this;
    }

    public writeBytes(src: Uint8Array | number[]): this {
        const length = src.length;
        this.ensureWritable(length);
        this.buffer.set(src, this.offset);
        this.offset += length;
        return this;
    }

    public readBytes(length: number): Uint8Array {
        if (this.offset + length > this.buffer.length) {
            throw new Error("Not enough readable bytes in buffer.");
        }
        const bytes = this.buffer.slice(this.offset, this.offset + length);
        this.offset += length;
        return bytes;
    }

    public readByte(): number {
        const val = this.view.getInt8(this.offset);
        this.offset += 1;
        return val;
    }

    public readUnsignedByte(): number {
        const val = this.view.getUint8(this.offset);
        this.offset += 1;
        return val;
    }

    public readShort(): number {
        const val = this.view.getInt16(this.offset, false);
        this.offset += 2;
        return val;
    }

    public readUnsignedShort(): number {
        const val = this.view.getUint16(this.offset, false);
        this.offset += 2;
        return val;
    }

    public readInt(): number {
        const val = this.view.getInt32(this.offset, false);
        this.offset += 4;
        return val;
    }

    public readUnsignedInt(): number {
        const val = this.view.getUint32(this.offset, false);
        this.offset += 4;
        return val;
    }

    public readLong(): bigint {
        const val = this.view.getBigInt64(this.offset, false);
        this.offset += 8;
        return val;
    }

    public readFloat(): number {
        const val = this.view.getFloat32(this.offset, false);
        this.offset += 4;
        return val;
    }

    public readDouble(): number {
        const val = this.view.getFloat64(this.offset, false);
        this.offset += 8;
        return val;
    }

    public readString(): string {
        const length = this.readUnsignedShort();
        const bytes = this.buffer.subarray(this.offset, this.offset + length);
        this.offset += length;
        const decoder = new TextDecoder();
        return decoder.decode(bytes);
    }
}