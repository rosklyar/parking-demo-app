package com.easyparking.web.service.actility;

import com.easyparking.web.domain.DeviceInfo;
import com.easyparking.web.domain.ParkingPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.easyparking.web.service.decode.BitEncoder.getBit;
import static com.easyparking.web.service.decode.HexEncoder.getBytes;

@Slf4j
@RequiredArgsConstructor
public class ParkingPayloadProcessor {

    public static final int PARKING_BIT = 6;
    public static final int BATTER_BIT = 7;

    public DeviceInfo parsePayload(ParkingPayload payload) {

        log.info("Started parsing payload {}", payload);

        byte[] bytes = getBytes(payload.getPayloadHex());
        DeviceInfo deviceInfo = DeviceInfo.builder()
                .deviceId(payload.getDevEui())
                .time(payload.getTime())
                .version(getVersion(payload.getPayloadHex()))
                .parking(getBit(bytes[0], PARKING_BIT))
                .battery(getBit(bytes[0], BATTER_BIT))
                .frameType(getFrameType(bytes[0]))
                .build();
        log.info("DeviceInfo : {}", deviceInfo);

        return deviceInfo;

    }

    private int getFrameType(byte value) {
        return value & (byte) 15; // & 00001111 (last 4 bits describes frame type )
    }

    private int getVersion(String payloadHex) {
        if(payloadHex.length() == 22) {
            return 2;
        }
        if(payloadHex.length() == 24) {
            return 1;
        }
        log.error("Unknown payload {}", payloadHex);
        throw new RuntimeException("Unknown payload");
    }



}
