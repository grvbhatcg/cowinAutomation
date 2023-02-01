package org.example.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Slot {
    private @Getter
    @Setter String time;
    private @Getter
    @Setter int seats;
}
