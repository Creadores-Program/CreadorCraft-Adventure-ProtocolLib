import { Vector2 } from "../../data/Vector2";
import { ByteBuf } from "../ByteBuf";
import { DataPacket } from "../DataPacket";

export class SetSpawnPacket implements DataPacket {
    public position: Vector2;
    constructor(position: Vector2 = new Vector2()){
        this.position = position;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.position.x * 100);
        buffer.writeUnsignedShort(this.position.y * 100);
    }
    public read(buffer: ByteBuf): void {
        this.position.x = buffer.readUnsignedShort() / 100;
        this.position.y = buffer.readUnsignedShort() / 100;
    }
}