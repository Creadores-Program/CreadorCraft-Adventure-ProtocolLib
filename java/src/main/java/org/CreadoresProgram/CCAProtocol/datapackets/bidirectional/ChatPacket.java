package org.CreadoresProgram.CCAProtocol.datapackets.bidirectional;

import org.CreadoresProgram.CCAProtocol.datapackets.DataPacket;
import org.CreadoresProgram.CCAProtocol.datapackets.BufferUtils;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatPacket implements DataPacket{
    private String msg;
    @Override
    public void write(ByteBuf buffer) throws IOException{
        BufferUtils.writeString(buffer, msg);
    }
    @Override
    public void read(ByteBuf buffer) throws IOException{
        this.msg = BufferUtils.readString(buffer);
    }
}