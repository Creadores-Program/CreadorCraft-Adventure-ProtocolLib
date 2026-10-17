package org.CreadoresProgram.CCAProtocol.datapackets;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

public interface Datapacket{
    public void write(ByteBuf buffer) throws IOException;
    public void read(ByteBuf buffer) throws IOException;
}