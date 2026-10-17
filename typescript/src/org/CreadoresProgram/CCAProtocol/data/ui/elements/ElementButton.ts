import { Element } from "./Element";

export class ElementButton extends Element{
    public assetImageId: number;
    public content: string;
    constructor(assetImageId: number = 0, content: string = ""){
        super();
        this.assetImageId = assetImageId;
        this.content = content;
    }

    public getElementId(): number {
        return 0x01;
    }
}