package com.easyparking.web.web;

import com.easyparking.web.service.DeviceAliasesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping(value = "/devices", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DeviceInfoController {

    private final DeviceAliasesService deviceAliasesService;

    @PostMapping
    public ResponseEntity<String> updateAliases(@RequestBody Map<String, String> aliases) {

        log.info("Received updateAliases request : {}", aliases);
        deviceAliasesService.updateAliases(aliases);
        return ResponseEntity.noContent().build();

    }
}
