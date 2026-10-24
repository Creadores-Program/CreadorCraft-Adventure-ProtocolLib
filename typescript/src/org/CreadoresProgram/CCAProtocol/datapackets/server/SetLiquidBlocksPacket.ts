import { ByteBuf } from "../ByteBuf";
import { DataPacket } from "../DataPacket";

export class SetLiquidBlocksPacket implements DataPacket {
    public liquidBlocks: Uint16Array | number[];
    constructor(liquidBlocks: Uint16Array | number[] = []){
        this.liquidBlocks = liquidBlocks;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.liquidBlocks.length);
        buffer.writeUnsignedShorts(this.liquidBlocks);
    }

    public read(buffer: ByteBuf): void {
        const len: number = buffer.readUnsignedShort();
        this.liquidBlocks = buffer.readUnsignedShorts(len);
    }
}