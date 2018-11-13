package com.easyparking.web.service;

import com.easyparking.web.domain.DeviceInfo;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultParkingStateService implements ParkingStateService {

    private final Map<String, DeviceInfo> deviceInfoMap = new ConcurrentHashMap();

    @Override
    public Collection<DeviceInfo> get() {
        return deviceInfoMap.values();
    }

    @Override
    public void updateState(DeviceInfo deviceInfo) {
        deviceInfoMap.put(deviceInfo.getDeviceId(), deviceInfo);
    }


}
