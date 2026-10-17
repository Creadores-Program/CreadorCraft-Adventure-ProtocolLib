import { Element } from "./Element";

export class ElementText extends Element {
    public text: string;

    constructor(text: string = ""){
        super();
        this.text = text;
    }

    public getElementId(): number {
        return 0x02;
    }
}