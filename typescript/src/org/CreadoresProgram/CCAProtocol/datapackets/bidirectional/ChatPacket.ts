import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class ChatPacket implements DataPacket{
    public msg: string;
    constructor(msg: string = ""){
        this.msg = msg;
    }
    public write(buffer: ByteBuf): void {
        buffer.writeString(this.msg);
    }
    public read(buffer: ByteBuf): void {
        this.msg = buffer.readString();
    }
}