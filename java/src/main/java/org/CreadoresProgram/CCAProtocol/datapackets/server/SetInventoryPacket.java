package org.CreadoresProgram.CCAProtocol.datapackets.server;

import io.netty.buffer.ByteBuf;
import org.CreadoresProgram.CCAProtocol.datapackets.DataPacket;
import org.CreadoresProgram.CCAProtocol.datapackets.BufferUtils;
import java.io.IOException;
import lombok.Getter;

public class SetInventoryPacket implements DataPacket {

    @Getter
    private final int[] items;

    public SetInventoryPacket(){
        this.items = new int[25];
    }

    public SetInventoryPacket(int[] items){
        if(items.length != 25){
            throw new IllegalArgumentException("The inventory must have exactly 25 items. Received: "+items.length);
        }
        this.items = items;
    }

    @Override
    public void write(ByteBuf buffer) throws IOException {
        BufferUtils.writeShorts(buffer, items);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        this.items = BufferUtils.readUnsignedShorts(buffer, 25);
    }
}