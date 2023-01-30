package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Session{
    private @Getter @Setter int center_id;
    private @Getter @Setter String name;
    private @Getter @Setter String address;
    private @Getter @Setter String state_name;
    private @Getter @Setter String district_name;
    private @Getter @Setter String block_name;
    private @Getter @Setter int pincode;
    private @Getter @Setter String from;
    @JsonProperty("to")
    private @Getter @Setter String myto;
    private @Getter @Setter int lat;
    @JsonProperty("long")
    private @Getter @Setter int mylong;
    private @Getter @Setter String fee_type;
    private @Getter @Setter String session_id;
    private @Getter @Setter String date;
    private @Getter @Setter int available_capacity;
    private @Getter @Setter int available_capacity_dose1;
    private @Getter @Setter int available_capacity_dose2;
    private @Getter @Setter String fee;
    private @Getter @Setter boolean allow_all_age;
    private @Getter @Setter int min_age_limit;
    private @Getter @Setter int max_age_limit;
    private @Getter @Setter String vaccine;
    private @Getter @Setter ArrayList<Slot> slots;
}
