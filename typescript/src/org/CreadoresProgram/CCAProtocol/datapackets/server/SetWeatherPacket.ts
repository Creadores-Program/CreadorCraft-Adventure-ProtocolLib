import { DataPacket } from "../DataPacket";
import { ByteBuf } from "../ByteBuf";
import { Weather } from "../../data/Weather";

export class SetWeatherPacket implements DataPacket {
    public weather: Weather;

    constructor(weather: Weather = Weather.CLEAR) {
        this.weather = weather;
    }

    public write(buffer: ByteBuf): void {
        buffer.writeUnsignedByte(Weather.getId(this.weather));
    }

    public read(buffer: ByteBuf): void {
        this.weather = Weather.fromId(buffer.readUnsignedByte());
    }
}