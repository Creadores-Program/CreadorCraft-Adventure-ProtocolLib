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
public class DisconnectPacket implements DataPacket{
    private String reason;
    @Override
    public void write(ByteBuf buffer) throws IOException{
        BufferUtils.writeString(buffer, reason);
    }
    @Override
    public void read(ByteBuf buffer) throws IOException{
        this.reason = BufferUtils.readString(buffer);
    }
}