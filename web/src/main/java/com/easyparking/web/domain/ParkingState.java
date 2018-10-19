package com.easyparking.web.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode
@ToString
public class ParkingState {

    public final List<ParkingPlace> places;

    @JsonCreator
    public ParkingState(@JsonProperty("places") List<ParkingPlace> places) {
        this.places = places;
    }
}
