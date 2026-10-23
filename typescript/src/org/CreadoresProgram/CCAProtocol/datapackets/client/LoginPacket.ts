import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";
import { Platform } from "../../data/Platform";

export class LoginPacket implements DataPacket{
    public platform: Platform;
    public lang: number;
    public static readonly protocol: number = 0x01;
    public readonly ticket: Uint8Array;
    constructor(platform: Platform = Platform.UNKNOWN, lang: number = 25971/*es*/, ticket: Uint8Array = new Uint8Array(6)){
        if (ticket.length !== 6) {
            throw new Error(`The ticket must have exactly 6 bytes. Received: ${ticket.length}`);
        }
        this.platform = platform;
        this.lang = lang;
        this.ticket = ticket;
    }
    write(buffer: ByteBuf): void {
        buffer.writeByte(Platform.getCode(this.platform));
        buffer.writeShort(this.lang);
        buffer.writeByte(LoginPacket.protocol);
        buffer.writeBytes(this.ticket);
    }
    read(buffer: ByteBuf): void {
        this.platform = Platform.fromCode(buffer.readByte());
        this.lang = buffer.readShort();
        const protocol: number = buffer.readByte();
        this.ticket.set(buffer.readBytes(6));
        if(protocol !== LoginPacket.protocol){
            throw new Error("Incompatible Protocol");
        }
    }
}