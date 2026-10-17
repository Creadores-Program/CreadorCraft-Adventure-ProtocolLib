import { Element } from "./Element";

export class ElementImage extends Element {
    public assetImageId: number;
    constructor(assetImageId: number = 0){
        super();
        this.assetImageId = assetImageId;
    }

    public getElementId(): number {
        return 0x03;
    }
}