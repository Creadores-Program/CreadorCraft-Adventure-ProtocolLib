import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class SetBackgroundColorPacket implements DataPacket {
    public red: number;
    public green: number;
    public blue: number;

    constructor(red: number = 100, green: number = 100, blue: number = 100) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedByte(this.red);
        buffer.writeUnsignedByte(this.green);
        buffer.writeUnsignedByte(this.blue);
    }

    public read(buffer: ByteBuf): void {
        this.red = buffer.readUnsignedByte();
        this.green = buffer.readUnsignedByte();
        this.blue = buffer.readUnsignedByte();
    }
}