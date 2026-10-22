import { DataPacket } from "../Datapacket";
import { ByteBuf } from "../ByteBuf";

export class PingPacket implements DataPacket{
    public write(buffer: ByteBuf): void {}
    public read(buffer: ByteBuf): void {}
}