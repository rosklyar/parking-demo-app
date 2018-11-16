package com.easyparking.web.service;

import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class DeviceAliasesService {

    private final Map<String, String> deviceIdAliasMap = Maps.newHashMap();

    @PostConstruct
    public void init() {
        deviceIdAliasMap.put("3B8B66C486CEA8A2", "Parking spot #3");
    }

    public void updateAliases(Map<String, String> newAliases) {
        deviceIdAliasMap.putAll(newAliases);
        log.info("Current aliases {}", deviceIdAliasMap);
    }

    public String getAlias(String id) {
        return deviceIdAliasMap.get(id);
    }
}
