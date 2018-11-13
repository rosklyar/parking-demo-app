package com.easyparking.web.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class DevEuiDto {

    private final ParkingPayload parkingPayload;

    @JsonCreator
    public DevEuiDto(@JsonProperty("DevEUI_uplink") ParkingPayload parkingPayload) {
        this.parkingPayload = parkingPayload;
    }
}
