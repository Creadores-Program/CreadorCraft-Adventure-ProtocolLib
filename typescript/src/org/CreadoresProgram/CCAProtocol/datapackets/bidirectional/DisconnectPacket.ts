import { DataPacket } from "../Datapacket";
import { ByteBuf } from "../ByteBuf";

export class DisconnectPacket implements DataPacket{
    public reason: string;
    constructor(reason: string = ""){
        this.reason = reason;
    }
    public write(buffer: ByteBuf): void {
        buffer.writeString(this.reason);
    }
    public read(buffer: ByteBuf): void {
        this.reason = buffer.readString();
    }
}