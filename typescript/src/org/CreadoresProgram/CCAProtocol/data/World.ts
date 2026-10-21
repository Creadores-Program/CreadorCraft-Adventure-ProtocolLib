import { Vector2 } from "./Vector2";

export class World {
    public static readonly maxY: number = 100;
    public readonly maxX: number;
    public readonly worldData: Uint16Array;

    constructor(maxX: number = 50, existingData?: number[] | Uint16Array){
        if (maxX < 50 || maxX > 500) {
            throw new Error(`maxX should be between 50 and 500. Current value: ${maxX}`);
        }
        this.maxX = maxX;
        const expectedLength = maxX * World.maxY;
        if (existingData) {
            if (existingData.length !== expectedLength) {
                throw new Error(`The size of the array does not match the protocol. Expected: ${expectedLength}, Received: ${existingData.length}`);
            }
            this.worldData = existingData instanceof Uint16Array ? new Uint16Array(existingData) : new Uint16Array(existingData);
        } else {
            this.worldData = new Uint16Array(expectedLength);
        }
    }
    private getIndex(pos: Vector2): number {
        if (pos.x < 0 || pos.x >= this.maxX || pos.y < 0 || pos.y >= World.maxY) {
            throw new Error(`Position outside the bounds of the world: (${pos.x}, ${pos.y})`);
        }
        return pos.y + (pos.x * World.maxY);
    }
    public setBlock(pos: Vector2, blockId: number): void {
        const index = this.getIndex(pos);
        this.worldData[index] = blockId;
    }
    public getBlock(pos: Vector2): number {
        const index = this.getIndex(pos);
        return this.worldData[index];
    }
    public getData(): Uint16Array {
        return this.worldData;
    }
    public getMaxX(): number {
        return this.maxX;
    }
}