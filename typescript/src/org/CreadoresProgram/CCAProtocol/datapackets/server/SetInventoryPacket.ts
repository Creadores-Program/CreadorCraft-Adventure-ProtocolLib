import { ByteBuf } from "../ByteBuf";
import { DataPacket } from "../DataPacket";

export class SetInventoryPacket implements DataPacket {
    public readonly items: Uint16Array;
    constructor(items: Uint16Array = new Uint16Array(25)){
        if(items.length !== 25){
            throw new Error(`The inventory must have exactly 25 items. Received: ${items.length}`);
        }
        this.items = items;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShorts(this.items);
    }

    public read(buffer: ByteBuf): void {
        this.items.set(buffer.readUnsignedShorts(25));
    }
}