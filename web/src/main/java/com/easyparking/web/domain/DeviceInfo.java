package com.easyparking.web.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DeviceInfo {

    private final String deviceId;
    private final int parking;
    private final int battery;
    private final int version;

    /*
    $this->info['device_id'] = $this->device_id;
    $this->info['battery'] = substr($this->bits[0], 1, 1);
    $this->info['parking'] = substr($this->bits[0], 0, 1);
    */
}
