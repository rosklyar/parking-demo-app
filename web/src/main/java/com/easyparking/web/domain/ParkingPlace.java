package com.easyparking.web.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Builder
@JsonDeserialize(builder = ParkingPlace.ParkingPlaceBuilder.class)
public class ParkingPlace {

    public final int row;
    public final int column;
    public final State state;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ParkingPlaceBuilder {

    }
}
