package org.example.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class District{
    private @Getter @Setter int district_id;
    private @Getter @Setter String district_name;
}
