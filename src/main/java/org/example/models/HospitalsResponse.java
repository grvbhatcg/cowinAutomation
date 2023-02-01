package org.example.models;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HospitalsResponse {
    private @Getter
    @Setter ArrayList<Session> sessions;

}
