package org.CreadoresProgram.CCAProtocol.datapackets.client;

import org.CreadoresProgram.CCAProtocol.datapackets.DataPacket;
import io.netty.buffer.ByteBuf;
import java.io.IOException;

public class DonePacket implements DataPacket{
    @Override
    public void write(ByteBuf buffer) throws IOException{}
    @Override
    public void read(ByteBuf buffer) throws IOException{}
}