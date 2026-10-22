package org.CreadoresProgram.CCAProtocol.datapackets;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class BufferUtils{
    public static void writeString(ByteBuf buffer, String str) throws IOException{
        byte[] strb = str.getBytes(StandardCharsets.UTF_8);
        buffer.writeShort(strb.length);
        buffer.writeBytes(strb);
    }
    public static String readString(ByteBuf buffer) throws IOException{
        int len = buffer.readUnsignedShort();
        byte[] strb = new byte[len];
        buffer.readBytes(strb);
        return new String(strb, StandardCharsets.UTF_8);
    }
    public static int[] readUnsignedShorts(ByteBuf buffer, int length) throws IOException {
        if(length < 0) {
            throw new IllegalArgumentException("Array cannot have length less than 0.");
        }

        int s[] = new int[length];
        for(int index = 0; index < length; index++) {
            s[index] = buffer.readUnsignedShort();
        }
        return s;
    }
    public static void writeShorts(ByteBuf buffer, int[] s) throws IOException {
        for(int index = 0; index < s.length; index++) {
            buffer.writeShort(s[index]);
        }
    }
}
