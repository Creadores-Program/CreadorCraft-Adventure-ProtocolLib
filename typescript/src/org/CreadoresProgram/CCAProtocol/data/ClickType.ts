export enum ClickType {
    LEFT = 0x01,
    RIGHT = 0x02
}

export namespace ClickType {
    export function getId(clickType: ClickType): number{
        return clickType;
    }
    export function fromId(type: number): ClickType{
        const values = Object.values(ClickType).filter((v): v is number => typeof v === 'number');
        if (values.includes(type)) {
            return type as ClickType;
        }
        throw new Error(`Unknown Click Type: 0x${type.toString(16)}`);
    }
}