package com.easyparking.web.web;

import com.easyparking.web.domain.DevEuiDto;
import com.easyparking.web.domain.DeviceInfo;
import com.easyparking.web.service.ParkingStateService;
import com.easyparking.web.service.actility.ParkingPayloadProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping(value = "/services/actility", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ActilityCallbackController {

    private final ParkingPayloadProcessor parkingPayloadProcessor;
    private final ParkingStateService parkingStateService;

    @PostMapping
    public ResponseEntity<String> parkingPayload(@RequestBody DevEuiDto devEuidto) {

        log.info("Received request : {}", devEuidto);
        DeviceInfo deviceInfo = parkingPayloadProcessor.parsePayload(devEuidto.getParkingPayload());
        parkingStateService.updateState(deviceInfo);

        return ResponseEntity.noContent().build();

    }
}
