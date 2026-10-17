import { UI } from './UI';

export class ModalUI extends UI {
    public content: string;
    public negativeButton: string;
    public positiveButton: string;

    constructor(title: string = "", content: string = "", negativeButton: string = "No", positiveButton: string = "yes"){
        super(title);
        this.content = content;
        this.negativeButton = negativeButton;
        this.positiveButton = positiveButton;
    }
    
    public set(title: string, content: string, negativeButton: string, positiveButton: string): this {
        this.title = title;
        this.negativeButton = negativeButton;
        this.positiveButton = positiveButton;
        return this;
    }

    public getUiId(): number {
        return 0x01;
    }

    public clone(): ModalUI {
        return new ModalUI(this.title, this.content, this.negativeButton, this.positiveButton);
    }
}