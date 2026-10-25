import { ByteBuf } from "../ByteBuf";
import { DataPacket } from "../DataPacket";

export class SetPlayerEntityPacket implements DataPacket {
    public entityId: number;

    constructor(entityId: number = 0){
        this.entityId = entityId;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.entityId);
    }
    public read(buffer: ByteBuf): void {
        this.entityId = buffer.readUnsignedShort();
    }
}