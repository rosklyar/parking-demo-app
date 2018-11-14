package com.easyparking.web.service;

import com.easyparking.web.domain.DeviceInfo;
import com.google.common.collect.EvictingQueue;

import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultParkingStateService implements ParkingStateService {

    private final Map<String, Queue<DeviceInfo>> deviceInfoMap = new ConcurrentHashMap();

    @Override
    public Collection<Queue<DeviceInfo>> get() {
        return deviceInfoMap.values();
    }

    @Override
    public void updateState(DeviceInfo deviceInfo) {
        deviceInfoMap.putIfAbsent(deviceInfo.getDeviceId(), EvictingQueue.create(5));
        deviceInfoMap.get(deviceInfo.getDeviceId()).add(deviceInfo);
    }
}
