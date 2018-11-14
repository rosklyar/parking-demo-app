package com.easyparking.web.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DeviceInfo {

    private final String deviceId;
    private final String time;
    private final int parking;
    private final int battery;
    private final int version;
}
