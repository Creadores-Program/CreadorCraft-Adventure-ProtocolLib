package org.CreadoresProgram.CCAProtocol.data.ui.elements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElementImage extends Element {
    private int assetImageId;

    @Override
    public int getElementId() {
        return 0x03;
    }
}