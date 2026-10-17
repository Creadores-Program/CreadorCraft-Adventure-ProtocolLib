package org.CreadoresProgram.CCAProtocol.data.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class UI implements Cloneable {
    protected String title;

    public abstract int getUiId();

    @Override
    public UI clone() {
        try {
            return (UI) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}