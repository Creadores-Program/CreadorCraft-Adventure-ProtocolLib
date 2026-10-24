package org.CreadoresProgram.CCAProtocol.datapackets.server;

import io.netty.buffer.ByteBuf;
import org.CreadoresProgram.CCAProtocol.datapackets.DataPacket;
import org.CreadoresProgram.CCAProtocol.datapackets.BufferUtils;
import java.io.IOException;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SetLiquidBlocksPacket implements DataPacket {
    private int[] liquidBlocks;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeShort(liquidBlocks.length);
        BufferUtils.writeShorts(buffer, liquidBlocks);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        int len = buffer.readUnsignedShort();
        this.liquidBlocks = BufferUtils.readUnsignedShorts(buffer, len);
    }
}