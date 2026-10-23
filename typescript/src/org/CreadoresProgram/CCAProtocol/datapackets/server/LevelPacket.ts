import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";
import { World } from "../../data/World";

export class LevelPacket implements DataPacket {
    public world: World;

    constructor(world?: World) {
        this.world = world!;
    }

    public write(buffer: ByteBuf): void {
        if (!this.world) {
            throw new Error("World cannot be null when writing LevelPacket");
        }

        buffer.writeUnsignedShort(this.world.getMaxX());

        buffer.writeUnsignedShorts(this.world.getData());
    }

    public read(buffer: ByteBuf): void {
        const maxX = buffer.readUnsignedShort();
        
        const expectedLength = maxX * World.maxY;
        const worldData = buffer.readUnsignedShorts(expectedLength);


        this.world = new World(maxX, worldData);
    }
}