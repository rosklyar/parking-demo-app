package com.easyparking.web.service;

import com.easyparking.web.domain.DeviceInfo;

import java.util.Collection;
import java.util.Queue;

public interface ParkingStateService {

    Collection<Queue<DeviceInfo>> get();

    void updateState(DeviceInfo deviceInfo);
}
