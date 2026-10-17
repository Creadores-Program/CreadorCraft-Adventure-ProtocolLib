import { Element } from "./Element";

export class ElementInput extends Element{
    public text: string;
    public placeholder: string;
    public defaultText: string;

    constructor(text: string = "Text:", placeholder: string = "", defaultText: string = ""){
        super();
        this.text = text;
        this.placeholder = placeholder;
        this.defaultText = defaultText;
    }

    public getElementId(): number {
        return 0x05;
    }
}