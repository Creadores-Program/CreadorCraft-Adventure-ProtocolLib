package org.CreadoresProgram.CCAProtocol.data.ui;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.CreadoresProgram.CCAProtocol.data.ui.elements.Element;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomUI extends UI {
    @Setter(lombok.AccessLevel.NONE)
    private final List<Element> elements = new ArrayList<>();

    @Override
    public int getUiId() {
        return 0x03;
    }
}