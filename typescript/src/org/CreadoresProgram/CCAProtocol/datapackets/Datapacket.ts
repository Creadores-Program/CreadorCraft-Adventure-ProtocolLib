import { ByteBuf } from "./ByteBuf";

export interface DataPacket{
    write(buffer: ByteBuf): void;
    read(buffer: ByteBuf): void;
}