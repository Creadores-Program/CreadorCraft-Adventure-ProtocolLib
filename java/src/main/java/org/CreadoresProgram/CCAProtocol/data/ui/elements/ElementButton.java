package org.CreadoresProgram.CCAProtocol.data.ui.elements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElementButton extends Element {
    private int assetImageId;
    private String content;

    @Override
    public int getElementId() {
        return 0x01;
    }
}