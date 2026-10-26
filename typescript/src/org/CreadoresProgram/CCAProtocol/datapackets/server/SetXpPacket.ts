import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class SetXpPacket implements DataPacket {
    public level: number;
    public percent: number;

    constructor(level: number = 0, percent: number = 0) {
        this.level = level;
        this.percent = percent;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.level);
        buffer.writeUnsignedByte(this.percent);
    }

    public read(buffer: ByteBuf): void {
        this.level = buffer.readUnsignedShort();
        this.percent = buffer.readUnsignedByte();
    }
}