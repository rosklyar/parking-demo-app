package com.easyparking.web.service.actility;

import com.easyparking.web.domain.DeviceInfo;
import com.easyparking.web.domain.ParkingPayload;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ParkingPayloadProcessorTest {

    private ParkingPayloadProcessor parkingPayloadProcessor = new ParkingPayloadProcessor();

    private static final String DEV_EUI = "DevEui";
    private static final String PAYLOAD_VERSION_1 = "1543965fbdba41ab6fbf15FF";
    private static final String PAYLOAD_VERSION_2 = "1543965fbdba41ab6fbf15";
    private static final String INVALID_PAYLOAD = "";

    @Test
    public void parseVersion2Payload() {
        ParkingPayload parkingPayloadV2 = parkingPayload(DEV_EUI, PAYLOAD_VERSION_2);
        DeviceInfo deviceInfo = parkingPayloadProcessor.parsePayload(parkingPayloadV2);

        assertThat(deviceInfo.getBattery()).isEqualTo(0);
        assertThat(deviceInfo.getParking()).isEqualTo(0);
    }

    @Test
    public void parsePayloadVersion() {

        ParkingPayload parkingPayloadV1 = parkingPayload(DEV_EUI, PAYLOAD_VERSION_1);
        ParkingPayload parkingPayloadV2 = parkingPayload(DEV_EUI, PAYLOAD_VERSION_2);

        assertThat(parkingPayloadProcessor.parsePayload(parkingPayloadV1).getVersion()).isEqualTo(1);
        assertThat(parkingPayloadProcessor.parsePayload(parkingPayloadV2).getVersion()).isEqualTo(2);
    }

    @Test(expected = RuntimeException.class)
    public void throwExceptionOnInvalidVersion() {
        ParkingPayload invalidParkingPayload = parkingPayload(DEV_EUI, INVALID_PAYLOAD);

        assertThat(parkingPayloadProcessor.parsePayload(invalidParkingPayload).getVersion()).isEqualTo(0);
    }

    private ParkingPayload parkingPayload(String id, String payload) {
        return new ParkingPayload(id, payload);
    }

}