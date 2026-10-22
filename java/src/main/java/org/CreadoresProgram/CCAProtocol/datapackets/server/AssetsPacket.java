package org.CreadoresProgram.CCAProtocol.datapackets.server;

import org.CreadoresProgram.CCAProtocol.datapackets.Datapacket;
import org.CreadoresProgram.CCAProtocol.datapackets.BufferUtils;
import org.CreadoresProgram.CCAProtocol.data.Asset;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssetsPacket implements Datapacket{
    private String urlBase;
    @Setter(lombok.AccessLevel.NONE)
    private final List<Asset> assets = new ArrayList<>();
    @Override
    public void write(ByteBuf buffer) throws IOException{
        BufferUtils.writeString(buffer, urlBase);
        buffer.writeShort(assets.size());
        for(Asset asset : this.assets){
            writeAsset(buffer, asset);
        }
    }
    @Override
    public void read(ByteBuf buffer) throws IOException{
        this.urlBase = BufferUtils.readString(buffer);
        int len = buffer.readUnsignedShort();
        for(int i = 0; i < len; i++){
            assets.add(readAsset(buffer));
        }
    }
    private static Asset readAsset(ByteBuf buffer) throws IOException{
        Asset asset = new Asset();
        asset.setId(buffer.readUnsignedShort());
        asset.setVersion((int) buffer.readUnsignedByte());
        asset.setType(Asset.AssetType.fromCode((int) buffer.readUnsignedByte()));
        return asset;
    }
    private static void writeAsset(ByteBuf buffer, Asset asset) throws IOException{
        buffer.writeShort(asset.getId());
        buffer.writeByte(asset.getVersion());
        buffer.writeByte(asset.getType().getCode());
    }
}