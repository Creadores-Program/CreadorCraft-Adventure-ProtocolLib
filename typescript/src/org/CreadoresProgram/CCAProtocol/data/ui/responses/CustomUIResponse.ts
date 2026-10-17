import { UIResponse } from "./UIResponse";
import { CheckResponse } from "./elements/CheckResponse";
import { InputResponse } from "./elements/InputResponse";

export class CustomUIResponse extends UIResponse{
    public readonly checkResponses: CheckResponse[] = [];
    public readonly inputResponses: InputResponse[] = [];

    public getResponseId(): number {
        return 0x03;
    }
}