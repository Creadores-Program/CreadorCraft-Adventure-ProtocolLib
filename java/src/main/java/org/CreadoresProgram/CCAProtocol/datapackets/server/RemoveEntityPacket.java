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
public class RemoveEntityPacket implements DataPacket {
    private int entityWorldId;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeShort(entityWorldId);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        this.entityWorldId = buffer.readUnsignedShort();
    }
}