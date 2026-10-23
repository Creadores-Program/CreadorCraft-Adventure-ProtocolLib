import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class SetTimePacket implements DataPacket {
    public time: number;

    constructor(time: number = 0) {
        this.time = time;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.time);
    }

    public read(buffer: ByteBuf): void {
        this.time = buffer.readUnsignedShort();
    }
}