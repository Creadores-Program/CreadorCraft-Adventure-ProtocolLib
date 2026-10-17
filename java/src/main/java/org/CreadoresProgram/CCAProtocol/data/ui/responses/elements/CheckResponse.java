package org.CreadoresProgram.CCAProtocol.data.ui.response.elements;

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
public class CheckResponse {
    @Setter(lombok.AccessLevel.NONE)
    private final List<String> options = new ArrayList<>();
}