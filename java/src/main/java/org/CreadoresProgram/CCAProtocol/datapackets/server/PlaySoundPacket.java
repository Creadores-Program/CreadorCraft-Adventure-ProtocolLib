package org.CreadoresProgram.CCAProtocol.datapackets.server;

import io.netty.buffer.ByteBuf;
import org.CreadoresProgram.CCAProtocol.datapackets.DataPacket;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaySoundPacket implements DataPacket {
    private int soundId;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeShort(soundId);
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        this.soundId = buffer.readUnsignedShort();
    }
}