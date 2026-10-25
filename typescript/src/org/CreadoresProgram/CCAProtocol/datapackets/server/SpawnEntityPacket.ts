import { Vector2 } from "../../data/Vector2";
import { ByteBuf } from "../ByteBuf";
import { DataPacket } from "../DataPacket";

export class SpawnEntityPacket implements DataPacket {
    public entityId: number;
    public entityWorldId: number;
    public position: Vector2;
    public name: string;
    constructor(entityId: number = 0, entityWorldId: number = 0, position: Vector2 = new Vector2(), name: string = ""){
        this.entityId = entityId;
        this.entityWorldId = entityWorldId;
        this.position = position;
        this.name = name;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.entityId);
        buffer.writeUnsignedShort(this.entityWorldId);
        buffer.writeUnsignedShort(this.position.x * 100);
        buffer.writeUnsignedShort(this.position.y * 100);
        buffer.writeString(this.name);
    }
    public read(buffer: ByteBuf): void {
        this.entityId = buffer.readUnsignedShort();
        this.entityWorldId = buffer.readUnsignedShort();
        this.position.x = buffer.readUnsignedShort() / 100;
        this.position.y = buffer.readUnsignedShort() / 100;
    }
}