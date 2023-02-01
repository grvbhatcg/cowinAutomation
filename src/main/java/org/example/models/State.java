package org.example.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class State {
    private @Getter
    @Setter int state_id;
    private @Getter
    @Setter String state_name;
}
