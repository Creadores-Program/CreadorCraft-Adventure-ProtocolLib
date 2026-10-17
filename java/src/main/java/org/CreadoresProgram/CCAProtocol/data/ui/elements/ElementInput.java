package org.CreadoresProgram.CCAProtocol.data.ui.elements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElementInput extends Element {
    private String text;
    private String placeholder;
    private String defaultText;

    @Override
    public int getElementId() {
        return 0x05;
    }
}