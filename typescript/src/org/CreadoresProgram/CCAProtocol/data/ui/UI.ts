export abstract class UI {
    public title: string;

    constructor(title: string = "") {
        this.title = title;
    }

    public abstract getUiId(): number;

    public abstract clone(): UI;
}