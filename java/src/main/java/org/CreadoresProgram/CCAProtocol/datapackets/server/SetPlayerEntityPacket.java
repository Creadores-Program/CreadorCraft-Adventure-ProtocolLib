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
public class SetPlayerEntityPacket implements DataPacket {
    private int entityId;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeShort(entityId);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        this.entityId = buffer.readUnsignedShort();
    }
}