import { UIResponse } from "./UIResponse";

export class SimpleUIResponse extends UIResponse{
    public buttonText: string;

    constructor(buttonText: string = "Close"){
        super();
        this.buttonText = buttonText;
    }

    public getResponseId(): number {
        return 0x02;
    }
}