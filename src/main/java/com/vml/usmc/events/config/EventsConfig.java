package com.vml.usmc.events.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vml.usmc.events.service.EventService;

@Configuration
public class EventsConfig {
    
    @Bean
    public EventService setupEventService() {
        return new EventService();
    }

}
