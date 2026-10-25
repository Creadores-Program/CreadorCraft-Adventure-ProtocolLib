package org.CreadoresProgram.CCAProtocol.datapackets.server;

import io.netty.buffer.ByteBuf;
import org.CreadoresProgram.CCAProtocol.datapackets.DataPacket;
import org.CreadoresProgram.CCAProtocol.datapackets.BufferUtils;
import org.CreadoresProgram.CCAProtocol.data.Vector2;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpawnEntityPacket implements DataPacket {
    private int entityId;
    private int entityWorldId;
    private Vector2 position;
    private String name;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeShort(entityId);
        buffer.writeShort(entityWorldId);
        buffer.writeShort((int) (position.x * 100));
        buffer.writeShort((int) (position.y * 100));
        BufferUtils.writeString(buffer, name);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        this.entityId = buffer.readUnsignedShort();
        this.entityWorldId = buffer.readUnsignedShort();
        this.position = new Vector2();
        this.position.x = (float) buffer.readUnsignedShort() / 100.0f;
        this.position.y = (float) buffer.readUnsignedShort() / 100.0f;
        this.name = BufferUtils.readString(buffer);
    }
}