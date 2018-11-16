package com.easyparking.web.service;

import com.easyparking.web.domain.DeviceInfo;
import com.google.common.collect.EvictingQueue;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DefaultParkingStateService implements ParkingStateService {

    private final Map<String, Queue<DeviceInfo>> deviceInfoMap = new ConcurrentHashMap();
    private final Map<String, DeviceInfo> latestDeviceInfoMap = new ConcurrentHashMap();
    private final DeviceAliasesService deviceAliasesService;

    @Override
    public Collection<Queue<DeviceInfo>> get() {
        return deviceInfoMap.values();
    }

    @Override
    public void updateState(DeviceInfo deviceInfo) {
        deviceInfoMap.putIfAbsent(deviceInfo.getDeviceId(), EvictingQueue.create(5));
        deviceInfoMap.get(deviceInfo.getDeviceId()).add(deviceInfo);
        latestDeviceInfoMap.put(deviceInfo.getDeviceId(), deviceInfo);
    }

    @Override
    public Collection<DeviceInfo> getLatest() {
        return latestDeviceInfoMap.values().stream()
                .map(this::enrichWithAlias)
                .collect(Collectors.toList());
    }

    private DeviceInfo enrichWithAlias(DeviceInfo deviceInfo) {

        String alias = deviceAliasesService.getAlias(deviceInfo.getDeviceId()) == null ?
                deviceInfo.getDeviceId() :
                deviceAliasesService.getAlias(deviceInfo.getDeviceId());

        return deviceInfo.toBuilder().alias(alias).build();
    }
}
