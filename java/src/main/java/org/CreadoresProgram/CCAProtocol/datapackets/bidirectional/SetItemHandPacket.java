package org.CreadoresProgram.CCAProtocol.datapackets.bidirectional;

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
public class SetItemHandPacket implements DataPacket {
    private int index;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeShort(this.index);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        this.index = buffer.readUnsignedShort();
    }
}