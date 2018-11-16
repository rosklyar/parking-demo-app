package com.easyparking.web.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

public class ParkingStateScheduler {

    private final SimpMessagingTemplate template;
    private final ParkingStateService parkingStateService;


    public ParkingStateScheduler(SimpMessagingTemplate template, ParkingStateService parkingStateService) {
        this.template = template;
        this.parkingStateService = parkingStateService;
    }

    @Scheduled(fixedRate = 2000)
    public void trigger() {
        this.template.convertAndSend("/topic/parking-state", parkingStateService.get());
    }

    @Scheduled(fixedRate = 2000)
    public void triggerLive() {
        this.template.convertAndSend("/topic/parking-state/live", parkingStateService.getLatest());
    }
}
