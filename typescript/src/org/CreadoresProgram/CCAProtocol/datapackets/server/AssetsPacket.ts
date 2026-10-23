import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";
import { Asset, AssetType } from "../../data/Asset";

export class AssetsPacket implements DataPacket{
    public urlBase: string;
    public readonly assets: Asset[] = [];
    constructor(urlBase: string = ""){
        this.urlBase = urlBase;
    }
    public write(buffer: ByteBuf): void {
        buffer.writeString(this.urlBase);
        buffer.writeUnsignedShort(this.assets.length);
        for (const asset of this.assets) {
            AssetsPacket.writeAsset(buffer, asset);
        }
    }
    public read(buffer: ByteBuf): void {
        this.urlBase = buffer.readString();
        const len: number = buffer.readUnsignedShort();
        for(let i: number = 0; i < len; i++){
            this.assets.push(AssetsPacket.readAsset(buffer));
        }
    }
    private static writeAsset(buffer: ByteBuf, asset: Asset): void {
        buffer.writeUnsignedShort(asset.id);
        buffer.writeUnsignedByte(asset.version);
        buffer.writeUnsignedByte(AssetType.getCode(asset.type));
    }
    private static readAsset(buffer: ByteBuf): Asset{
        const asset: Asset = new Asset();
        asset.id = buffer.readUnsignedShort();
        asset.version = buffer.readUnsignedByte();
        asset.type = AssetType.fromCode(buffer.readUnsignedByte());
        return asset;
    }
}