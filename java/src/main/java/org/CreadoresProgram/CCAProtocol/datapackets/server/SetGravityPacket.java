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
public class SetGravityPacket implements DataPacket {
    private boolean gravity;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeBoolean(gravity);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        this.gravity = buffer.readBoolean();
    }
}