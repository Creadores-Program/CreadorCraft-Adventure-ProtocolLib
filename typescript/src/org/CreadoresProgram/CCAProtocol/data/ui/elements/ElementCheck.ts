import { Element } from "./Element";

export class ElementCheck extends Element {
    public singleOption: boolean;
    public readonly options: string[] = [];
    public defaultOption: number;

    constructor(singleOption: boolean = false, defaultOption: number = 0){
        super();
        this.singleOption = singleOption;
        this.defaultOption = defaultOption;
    }

    public getElementId(): number {
        return 0x04;
    }

    public addOption(option: string): this {
        this.options.push(option);
        return this;
    }
}