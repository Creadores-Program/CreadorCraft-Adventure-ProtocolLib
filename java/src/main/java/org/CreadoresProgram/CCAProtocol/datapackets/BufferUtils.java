package org.CreadoresProgram.CCAProtocol.datapackets;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class BufferUtils{
    public static void writeString(ByteBuf buffer, String str){
        byte[] strb = str.getBytes(StandardCharsets.UTF_8);
        buffer.writeShort(strb.length);
        buffer.writeBytes(strb);
    }
    public static String readString(ByteBuf buffer){
        int len = buffer.readUnsignedShort();
        byte[] strb = new byte[len];
        buffer.readBytes(strb);
        return new String(strb, StandardCharsets.UTF_8);
    }
}