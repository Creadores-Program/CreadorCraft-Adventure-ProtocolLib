import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class SetItemByIndexPacket implements DataPacket {
    public index: number;
    public item: number;

    constructor(index: number = 0, item: number = 0) {
        this.index = index;
        this.item = item;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.index);
        buffer.writeUnsignedShort(this.item);
    }

    public read(buffer: ByteBuf): void {
        this.index = buffer.readUnsignedShort();
        this.item = buffer.readUnsignedShort();
    }
}