import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class SetGravityPacket implements DataPacket {
    public gravity: boolean;

    constructor(gravity: boolean = true) {
        this.gravity = gravity;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeBoolean(this.gravity);
    }

    public read(buffer: ByteBuf): void {
        this.gravity = buffer.readBoolean();
    }
}