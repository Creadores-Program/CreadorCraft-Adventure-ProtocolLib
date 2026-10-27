import { ByteBuf } from "../ByteBuf";
import { DataPacket } from "../DataPacket";

export class StopSoundPacket implements DataPacket {
    public soundId: number;

    constructor(soundId: number = 0){
        this.soundId = soundId;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.soundId);
    }
    public read(buffer: ByteBuf): void {
        this.soundId = buffer.readUnsignedShort();
    }
}