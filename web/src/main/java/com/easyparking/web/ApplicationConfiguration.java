package com.easyparking.web;

import com.easyparking.web.service.ParkingStateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ApplicationConfiguration {

    @Bean
    public ParkingStateService parkingStateService(SimpMessagingTemplate template) {
        return new ParkingStateService(template);
    }
}
