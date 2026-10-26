import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class BlockUpdatePacket implements DataPacket {
    public index: number;
    public block: number;

    constructor(index: number = 0, block: number = 0) {
        this.index = index;
        this.block = block;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.index);
        buffer.writeUnsignedShort(this.block);
    }

    public read(buffer: ByteBuf): void {
        this.index = buffer.readUnsignedShort();
        this.block = buffer.readUnsignedShort();
    }
}