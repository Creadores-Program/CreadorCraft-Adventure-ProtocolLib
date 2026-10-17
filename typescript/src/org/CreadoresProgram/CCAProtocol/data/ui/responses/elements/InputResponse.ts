export class InputResponse{
    public text: string;
    public inputStr: string;

    constructor(text: string = "Text", inputStr: string = ""){
        this.text = text;
        this.inputStr = inputStr;
    }
}