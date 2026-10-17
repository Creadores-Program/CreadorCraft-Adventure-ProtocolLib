import { UI } from './UI';
import { ElementButton } from './elements/ElementButton';

export class SimpleUI extends UI {
    public content: string;
    public readonly buttons: ElementButton[] = [];

    constructor(title: string = "", content: string = "") {
        super(title);
        this.content = content;
    }

    public addButton(button: ElementButton): this {
        this.buttons.push(button);
        return this;
    }

    public getUiId(): number {
        return 0x02;
    }

    public clone(): SimpleUI {
        const cloned = new SimpleUI(this.title, this.content);
        cloned.buttons.push(...this.buttons);
        return cloned;
    }
}