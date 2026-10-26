import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class BulkBlockUpdatePacket implements DataPacket {
    public indexs: Uint16Array | number[];
    public blocks: Uint16Array | number[];

    constructor(indexs: Uint16Array | number[] = [], blocks: Uint16Array | number[] = []) {
        this.indexs = indexs;
        this.blocks = blocks;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.indexs.length);
        buffer.writeUnsignedShorts(this.indexs);
        buffer.writeUnsignedShorts(this.blocks);
    }

    public read(buffer: ByteBuf): void {
        const len: number = buffer.readUnsignedShort();
        this.indexs = buffer.readUnsignedShorts(len);
        this.blocks = buffer.readUnsignedShorts(len);
    }
}