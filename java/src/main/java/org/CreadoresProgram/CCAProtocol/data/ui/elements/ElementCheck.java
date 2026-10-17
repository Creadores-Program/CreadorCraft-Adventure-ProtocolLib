package org.CreadoresProgram.CCAProtocol.data.ui.elements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElementCheck extends Element {
    private boolean singleOption;

    @Setter(lombok.AccessLevel.NONE)
    private final List<String> options = new ArrayList<>();
    private int defaultOption;

    @Override
    public int getElementId() {
        return 0x04;
    }

    public ElementCheck addOption(String option){
        options.add(option);
        return this;
    }
}