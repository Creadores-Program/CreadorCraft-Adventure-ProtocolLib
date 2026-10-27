import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class SetPausePacket implements DataPacket {
    public pause: boolean;

    constructor(pause: boolean = false) {
        this.pause = pause;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeBoolean(this.pause);
    }

    public read(buffer: ByteBuf): void {
        this.pause = buffer.readBoolean();
    }
}