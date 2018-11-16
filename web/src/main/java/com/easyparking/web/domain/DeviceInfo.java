package com.easyparking.web.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class DeviceInfo {

    private final String deviceId;
    private final String alias;
    private final String time;
    private final int parking;
    private final int battery;
    private final int frameType;
    private final int version;
}
