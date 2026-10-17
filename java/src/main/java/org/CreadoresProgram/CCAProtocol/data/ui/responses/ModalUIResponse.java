package org.CreadoresProgram.CCAProtocol.data.ui.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModalUIResponse extends UIResponse {
    private boolean response;

    @Override
    public int getResponseId() {
        return 0x01;
    }
}