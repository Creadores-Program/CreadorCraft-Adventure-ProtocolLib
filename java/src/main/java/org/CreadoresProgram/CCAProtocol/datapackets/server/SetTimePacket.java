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
public class SetTimePacket implements DataPacket {
    private int time;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeShort(time);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        this.time = buffer.readUnsignedShort();
    }
}