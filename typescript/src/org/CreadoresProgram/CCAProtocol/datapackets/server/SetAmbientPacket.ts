import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class SetAmbientPacket implements DataPacket {
    public ambient: boolean;

    constructor(ambient: boolean = true) {
        this.ambient = ambient;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeBoolean(this.ambient);
    }

    public read(buffer: ByteBuf): void {
        this.ambient = buffer.readBoolean();
    }
}