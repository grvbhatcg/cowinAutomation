package org.example.models;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DistrictResponse {

    private @Getter
    @Setter ArrayList<District> districts;
    private @Getter
    @Setter int ttl;

}
