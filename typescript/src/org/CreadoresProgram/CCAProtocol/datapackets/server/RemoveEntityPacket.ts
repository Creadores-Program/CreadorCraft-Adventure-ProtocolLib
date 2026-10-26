import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class RemoveEntityPacket implements DataPacket {
    public entityWorldId: number;

    constructor(entityWorldId: number = 0) {
        this.entityWorldId = entityWorldId;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.entityWorldId);
    }

    public read(buffer: ByteBuf): void {
        this.entityWorldId = buffer.readUnsignedShort();
    }
}