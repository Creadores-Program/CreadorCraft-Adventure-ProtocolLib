export enum Platform{
    UNKNOWN = 0x00,
    Android = 0x01,
    Linux = 0x02,
    J2ME = 0x03,
    MAC = 0x04,
    BSD = 0x05,
    SOLARIS = 0x06,
    RASPBERRY_PI = 0x07,
    IOS = 0x08,
    NINTENDO = 0x09,
    PSP = 0x0A,
    PSVITA = 0x0B,
    SYMBIAN_OS = 0x0C,
    BLACKBERRY = 0x0D,
    PALM_OS = 0x0E,
    FIREFOX_OS = 0x0F,
    XBOX = 0x10,
    PLAYSTATION = 0x11,
    WEB = 0x12,
    WINDOWS_PHONE = 0x13,
    WINDOWS = 0x14,
    JAVA = 0x15,
    KAI_OS = 0x16,
    WEB_OS = 0x17,
    TIZEN_OS = 0x18,
    CHROME_OS = 0x19,
    FIRE_OS = 0x1A
}

export namespace Platform{
    export function getCode(platform: Platform): number {
        return platform;
    }

    export function fromCode(code: number): Platform {
        const values = Object.values(Platform).filter((v): v is number => typeof v === 'number');
        if (values.includes(code)) {
            return code as Platform;
        }
        return Platform.UNKNOWN;
    }
}