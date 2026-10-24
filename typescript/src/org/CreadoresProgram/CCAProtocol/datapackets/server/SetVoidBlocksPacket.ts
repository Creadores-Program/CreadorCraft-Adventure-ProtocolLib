import { ByteBuf } from "../ByteBuf";
import { DataPacket } from "../DataPacket";

export class SetVoidBlocksPacket implements DataPacket {
    public voidBlocks: Uint16Array | number[];
    constructor(voidBlocks: Uint16Array | number[] = []){
        this.voidBlocks = voidBlocks;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.voidBlocks.length);
        buffer.writeUnsignedShorts(this.voidBlocks);
    }

    public read(buffer: ByteBuf): void {
        const len: number = buffer.readUnsignedShort();
        this.voidBlocks = buffer.readUnsignedShorts(len);
    }
}