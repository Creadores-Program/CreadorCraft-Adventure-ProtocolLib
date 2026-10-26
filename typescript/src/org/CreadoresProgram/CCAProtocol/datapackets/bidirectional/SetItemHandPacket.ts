import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class SetItemHandPacket implements DataPacket {
    public index: number;

    constructor(index: number = 0) {
        this.index = index;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.index);
    }

    public read(buffer: ByteBuf): void {
        this.index = buffer.readUnsignedShort();
    }
}