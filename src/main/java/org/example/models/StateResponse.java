package org.example.models;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StateResponse {
    private @Getter
    @Setter ArrayList<State> states;
    private @Getter
    @Setter int ttl;
}