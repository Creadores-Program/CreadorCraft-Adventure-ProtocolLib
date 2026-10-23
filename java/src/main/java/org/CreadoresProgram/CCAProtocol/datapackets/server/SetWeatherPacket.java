package org.CreadoresProgram.CCAProtocol.datapackets.server;

import io.netty.buffer.ByteBuf;
import org.CreadoresProgram.CCAProtocol.datapackets.DataPacket;
import org.CreadoresProgram.CCAProtocol.data.Weather;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetWeatherPacket implements DataPacket {
    private Weather weather;

    @Override
    public void write(ByteBuf buffer) throws IOException {
        buffer.writeByte(weather.getId());
    }

    @Override
    public void read(ByteBuf buffer) throws IOException {
        this.weather = Weather.fromId(buffer.readUnsignedByte());
    }
}