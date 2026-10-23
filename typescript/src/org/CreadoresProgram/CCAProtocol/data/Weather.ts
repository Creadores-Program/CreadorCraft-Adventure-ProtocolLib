export enum Weather {
    CLEAR = 0x01,
    RAIN = 0x02,
    SNOWY = 0x03
}

export namespace Weather {
    export function getId(weather: Weather): number{
        return weather;
    }
    export function fromId(weatherId: number): Weather{
        const values = Object.values(Weather).filter((v): v is number => typeof v === 'number');
        if (values.includes(weatherId)) {
            return weatherId as Weather;
        }
        throw new Error(`Unknown Weather Id: 0x${weatherId.toString(16)}`);
    }
}