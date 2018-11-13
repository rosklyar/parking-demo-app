package com.easyparking.web.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class ParkingPayload {

    private final String devEui;
    private final String payloadHex;

    @JsonCreator
    public ParkingPayload(@JsonProperty("DevEUI") String devEui,
                          @JsonProperty("payload_hex") String payloadHex) {
        this.payloadHex = payloadHex;
        this.devEui = devEui;
    }
}
