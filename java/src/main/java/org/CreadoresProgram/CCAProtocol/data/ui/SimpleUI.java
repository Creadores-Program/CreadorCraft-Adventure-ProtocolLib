package org.CreadoresProgram.CCAProtocol.data.ui;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.CreadoresProgram.CCAProtocol.data.ui.elements.ElementButton;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleUI extends UI {
    private String content;
    
    @Setter(lombok.AccessLevel.NONE)
    private final List<ElementButton> buttons = new ArrayList<>();

    @Override
    public int getUiId() {
        return 0x02;
    }

    public SimpleUI addButton(ElementButton button) {
        this.buttons.add(button);
        return this;
    }
}