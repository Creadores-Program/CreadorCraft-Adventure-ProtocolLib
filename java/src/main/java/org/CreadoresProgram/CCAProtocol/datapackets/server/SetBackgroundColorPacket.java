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
public class SetBackgroundColorPacket implements DataPacket {
    private int red;
    private int green;
    private int blue;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeByte(red);
        buffer.writeByte(green);
        buffer.writeByte(blue);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        this.red = buffer.readUnsignedByte();
        this.green = buffer.readUnsignedByte();
        this.blue = buffer.readUnsignedByte();
    }
}