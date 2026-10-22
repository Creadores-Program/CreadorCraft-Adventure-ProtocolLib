package org.CreadoresProgram.CCAProtocol.datapackets.bidirectional;

import org.CreadoresProgram.CCAProtocol.datapackets.Datapacket;
import io.netty.buffer.ByteBuf;
import java.io.IOException;

public class PingPacket implements Datapacket{
    @Override
    public void write(ByteBuf buffer) throws IOException{}
    @Override
    public void read(ByteBuf buffer) throws IOException{}
}