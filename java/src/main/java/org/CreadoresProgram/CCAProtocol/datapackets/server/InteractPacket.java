package org.CreadoresProgram.CCAProtocol.datapackets.server;

import io.netty.buffer.ByteBuf;
import org.CreadoresProgram.CCAProtocol.datapackets.DataPacket;
import org.CreadoresProgram.CCAProtocol.data.ClickType;
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
public class InteractPacket implements DataPacket {
    private ClickType type;
    private Vector2 position;
    private int entityWorldId;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeByte(type.getType());
        buffer.writeShort((int) position.x);
        buffer.writeShort((int) position.y);
        buffer.writeShort(entityWorldId);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        this.type = ClickType.fromType(buffer.readUnsignedByte());
        this.position = new Vector2((float) buffer.readUnsignedShort(), (float) buffer.readUnsignedShort());
        this.entityWorldId = buffer.readUnsignedShort();
    }
}