package org.CreadoresProgram.CCAProtocol.datapackets.server;

import io.netty.buffer.ByteBuf;
import org.CreadoresProgram.CCAProtocol.datapackets.DataPacket;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetBackgroundAssetPacket implements DataPacket {
    private int assetId;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeShort(assetId);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        this.assetId = buffer.readUnsignedShort();
    }
}