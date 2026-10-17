import { UI } from "./UI";
import { Element } from "./elements/Element";

export class CustomUI extends UI {
    public readonly elements: Element[] = [];

    constructor(title: string = "") {
        super(title);
    }

    public addElement(element: Element): this {
        this.elements.push(element);
        return this;
    }

    public getUiId(): number {
        return 0x03;
    }

    public clone(): CustomUI {
        const cloned = new CustomUI(this.title);
        cloned.elements.push(...this.elements);
        return cloned;
    }
}