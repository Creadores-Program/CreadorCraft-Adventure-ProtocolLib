package org.CreadoresProgram.CCAProtocol.datapackets.client;

import org.CreadoresProgram.CCAProtocol.datapackets.DataPacket;
import org.CreadoresProgram.CCAProtocol.data.Platform;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.net.ProtocolException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginPacket implements DataPacket{
    private Platform platform;
    private short lang;
    private static final byte protocol = 0x01;
    @Setter(lombok.AccessLevel.NONE)
    private final byte[] ticket;

    public LoginPacket(Platform platform, short lang, byte[] ticket){
        if(ticket.length != 6){
            throw new IllegalArgumentException("The ticket must have exactly 6 bytes. Received: "+ticket.length);
        }
        this.platform = platform;
        this.lang = lang;
        this.ticket = ticket;
    }
    public LoginPacket(){
        this.ticket = new byte[6];
    }

    @Override
    public void write(ByteBuf buffer) throws IOException{
        buffer.writeByte(this.platform.getCode());
        buffer.writeShort((int) this.lang);
        buffer.writeByte(protocol);
        buffer.writeBytes(this.ticket);
    }
    @Override
    public void read(ByteBuf buffer) throws IOException{
        this.platform = Platform.fromCode((int) buffer.readByte());
        this.lang = (short) buffer.readShort();
        byte protocolP = buffer.readByte();
        buffer.readBytes(this.ticket);
        if(protocolP != protocol){
            throw new ProtocolException("Incompatible Protocol");
        }
    }
}