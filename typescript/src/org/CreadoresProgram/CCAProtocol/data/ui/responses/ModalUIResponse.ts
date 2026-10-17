import { UIResponse } from "./UIResponse";

export class ModalUIResponse extends UIResponse {
    public response: boolean;

    constructor(response: boolean = false){
        super();
        this.response = response;
    }

    public getResponseId(): number {
        return 0x01;
    }
}