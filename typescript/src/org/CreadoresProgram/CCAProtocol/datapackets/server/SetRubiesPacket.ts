import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class SetRubiesPacket implements DataPacket {
    public rubies: number;

    constructor(rubies: number = 0) {
        this.rubies = rubies;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.rubies);
    }

    public read(buffer: ByteBuf): void {
        this.rubies = buffer.readUnsignedShort();
    }
}