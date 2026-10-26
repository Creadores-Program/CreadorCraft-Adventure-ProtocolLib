import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class SetSpeedPacket implements DataPacket {
    public speed: number;

    constructor(speed: number = 0) {
        this.speed = speed;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.speed * 100);
    }

    public read(buffer: ByteBuf): void {
        this.speed = buffer.readUnsignedShort() / 100;
    }
}