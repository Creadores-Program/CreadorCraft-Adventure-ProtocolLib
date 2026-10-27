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
public class SetHealthPacket implements DataPacket {
    private byte health;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeByte(this.health);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        this.health = buffer.readByte();
    }
}