import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class SetHealthPacket implements DataPacket {
    public health: number;

    constructor(health: number = -1) {
        this.health = health;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeByte(this.health);
    }

    public read(buffer: ByteBuf): void {
        this.health = buffer.readByte();
    }
}