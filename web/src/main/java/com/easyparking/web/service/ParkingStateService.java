package com.easyparking.web.service;

import com.easyparking.web.domain.DeviceInfo;

import java.util.Collection;

public interface ParkingStateService {

    Collection<DeviceInfo> get();

    void updateState(DeviceInfo deviceInfo);
}
