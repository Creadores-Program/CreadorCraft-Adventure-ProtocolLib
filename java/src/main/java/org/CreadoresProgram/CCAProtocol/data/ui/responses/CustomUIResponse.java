package org.CreadoresProgram.CCAProtocol.data.ui.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.CreadoresProgram.CCAProtocol.data.ui.response.elements.CheckResponse;
import org.CreadoresProgram.CCAProtocol.data.ui.response.elements.InputResponse;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomUIResponse extends UIResponse {

    @Setter(lombok.AccessLevel.NONE)
    private final List<CheckResponse> checkResponses = new ArrayList<>();
    @Setter(lombok.AccessLevel.NONE)
    private final List<InputResponse> inputResponses = new ArrayList<>();
    private String pressedButton;

    @Override
    public int getResponseId() {
        return 0x03;
    }
}