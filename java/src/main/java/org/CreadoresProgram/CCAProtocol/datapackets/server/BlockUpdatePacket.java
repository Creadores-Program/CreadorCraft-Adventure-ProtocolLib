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
public class BlockUpdatePacket implements DataPacket {
    private int index;
    private int block;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeShort(this.index);
        buffer.writeShort(this.block);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        this.index = buffer.readUnsignedShort();
        this.block = buffer.readUnsignedShort();
    }
}