package com.easyparking.web.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

public class ParkingStateService {

    private final SimpMessagingTemplate template;

    public ParkingStateService(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Scheduled(fixedRate = 2000)
    public void trigger() {
        this.template.convertAndSend("/topic/parking-state", "Vacant");
    }
}
