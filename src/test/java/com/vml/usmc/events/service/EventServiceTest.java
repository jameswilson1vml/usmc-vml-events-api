package com.vml.usmc.events.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.vml.usmc.events.model.Event;
import com.vml.usmc.events.model.Type;

@SpringBootTest
public class EventServiceTest {
    
    @InjectMocks
    private EventService eventService;

    @Test
    void createSampleEvent_ShouldReturnSampleEvent() throws Exception {
        Event event = eventService.createSampleEvent(null);

        assertNotNull(event);
        assertEquals(event.getName(), "Sample event");
        assertEquals(event.getType(), Type.NATIONAL_PARTNERSHIP);
    }
}
