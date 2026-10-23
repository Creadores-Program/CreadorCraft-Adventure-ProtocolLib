import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";

export class SetBackgroundAssetPacket implements DataPacket {
    public assetId: number;

    constructor(assetId: number = 0) {
        this.assetId = assetId;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedShort(this.assetId);
    }

    public read(buffer: ByteBuf): void {
        this.assetId = buffer.readUnsignedShort();
    }
}