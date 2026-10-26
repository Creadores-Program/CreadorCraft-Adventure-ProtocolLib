package org.CreadoresProgram.CCAProtocol.datapackets.server;

import io.netty.buffer.ByteBuf;
import org.CreadoresProgram.CCAProtocol.datapackets.DataPacket;
import org.CreadoresProgram.CCAProtocol.datapackets.BufferUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BulkBlockUpdatePacket implements DataPacket {
    private int[] indexs;
    private int[] blocks;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeShort(this.indexs.length);
        BufferUtils.writeShorts(buffer, this.indexs);
        BufferUtils.writeShorts(buffer, this.blocks);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        int len = buffer.readUnsignedShort();
        this.indexs = BufferUtils.readUnsignedShorts(buffer, len);
        this.blocks = BufferUtils.readUnsignedShorts(buffer, len);
    }
}