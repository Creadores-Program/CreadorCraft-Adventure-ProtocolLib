package org.CreadoresProgram.CCAProtocol.data.ui;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModalUI extends UI {
    private String content;
    private String negativeButton;
    private String positiveButton;

    @Override
    public int getUiId() {
        return 0x01;
    }
}