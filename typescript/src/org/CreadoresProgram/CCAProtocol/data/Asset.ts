export enum AssetType {
    BLOCK = 0x01,
    ENTITY = 0x02,
    AUDIO = 0x03,
    ITEM = 0x04,
    SUN = 0x05,
    MOON = 0x06,
    CLICK_SOUND = 0x07,
    DAY_CLOUD = 0x08,
    NIGHT_CLOUD = 0x09,
    RAIN_CLOUD = 0x10,
    BACKGROUND = 0x11,
    RUBY = 0x12
}

export namespace AssetType {
    export function getCode(type: AssetType): number {
        return type;
    }

    export function fromCode(code: number): AssetType {
        const values = Object.values(AssetType).filter((v): v is number => typeof v === 'number');
        if (values.includes(code)) {
            return code as AssetType;
        }
        throw new Error(`Unknown AssetType: 0x${code.toString(16)}`);
    }
}

export class Asset {
    public id: number;
    public version: number;
    public type: AssetType;

    constructor(id: number = 0, version: number = 0, type: AssetType = AssetType.BLOCK) {
        this.id = id;
        this.version = version;
        this.type = type;
    }

    public set(id: number, version: number, type: AssetType): this {
        this.id = id;
        this.version = version;
        this.type = type;
        return this;
    }

    public clone(): Asset {
        return new Asset(this.id, this.version, this.type);
    }

    public toString(): string {
        const hexCode = AssetType.getCode(this.type).toString(16);
        const enumName = AssetType[this.type];
        return `Asset{id='${this.id}', version=${this.version}, type=${enumName} (0x${hexCode})}`;
    }
}