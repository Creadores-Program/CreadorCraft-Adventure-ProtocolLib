package org.CreadoresProgram.CCAProtocol.data.ui.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleUIResponse extends UIResponse {
    private String buttonText;

    @Override
    public int getResponseId() {
        return 0x02;
    }
}