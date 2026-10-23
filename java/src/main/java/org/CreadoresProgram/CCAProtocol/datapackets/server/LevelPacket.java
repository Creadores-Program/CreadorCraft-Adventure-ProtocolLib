package org.CreadoresProgram.CCAProtocol.datapackets.server;

import io.netty.buffer.ByteBuf;
import org.CreadoresProgram.CCAProtocol.datapackets.DataPacket;
import org.CreadoresProgram.CCAProtocol.data.World;
import org.CreadoresProgram.CCAProtocol.datapackets.BufferUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelPacket implements DataPacket {
    private World world;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        if (world == null) {
            throw new IllegalStateException("World cannot be null when writing LevelPacket");
        }
        
        buffer.writeShort(world.getMaxX());
        BufferUtils.writeShorts(buffer, world.getData());
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        int maxX = buffer.readUnsignedShort();
        
        int length = maxX * 100;
        int[] worldData = BufferUtils.readUnsignedShorts(buffer, length);
        
        this.world = new World(maxX, worldData);
    }
}