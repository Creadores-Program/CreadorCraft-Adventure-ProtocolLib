import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";
import { ClickType } from "../../data/ClickType";
import { Vector2 } from "../../data/Vector2";

export class InteractPacket implements DataPacket {
    public type: ClickType;
    public position: Vector2;
    public entityWorldId: number;

    constructor(type: ClickType = ClickType.LEFT, position: Vector2 = new Vector2(), entityWorldId: number = 0) {
        this.type = type;
        this.position = position;
        this.entityWorldId = entityWorldId;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedByte(ClickType.getId(this.type));
        buffer.writeUnsignedShort(this.position.x);
        buffer.writeUnsignedShort(this.position.y);
        buffer.writeUnsignedShort(this.entityWorldId);
    }

    public read(buffer: ByteBuf): void {
        this.type = ClickType.fromId(buffer.readUnsignedShort());
        this.position = new Vector2(buffer.readUnsignedShort(), buffer.readUnsignedShort());
        this.entityWorldId = buffer.readUnsignedShort();
    }
}