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
public class SetPausePacket implements DataPacket {
    private boolean pause;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeBoolean(pause);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        this.pause = buffer.readBoolean();
    }
}