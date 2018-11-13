package com.easyparking.web;

import com.easyparking.web.service.DefaultParkingStateService;
import com.easyparking.web.service.ParkingStateScheduler;
import com.easyparking.web.service.ParkingStateService;
import com.easyparking.web.service.actility.ParkingPayloadProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ApplicationConfiguration {

    @Bean
    public ParkingPayloadProcessor parkingPayloadProcessor() {
        return new ParkingPayloadProcessor();
    }

    @Bean
    public ParkingStateService parkingStateService() {
        return new DefaultParkingStateService();
    }

    @Bean
    public ParkingStateScheduler parkingStateScheduler(ParkingStateService parkingStateService,
                                                       SimpMessagingTemplate template) {
        return new ParkingStateScheduler(template, parkingStateService);
    }
}
