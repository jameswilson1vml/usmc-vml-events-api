package com.vml.usmc.events.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vml.usmc.events.entity.EventEntity;
import com.vml.usmc.events.model.Event;
import com.vml.usmc.events.model.Type;
import com.vml.usmc.events.repository.IEventRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EventService {

    @Autowired
    private IEventRepository eventRepo;
    
    public Event createSampleEvent(UUID id) {
        Event sampleEvent = new Event();
        if(id != null) {
            sampleEvent.setId(id);
        } else {
            sampleEvent.setId(UUID.randomUUID());
        }
        sampleEvent.setName("Sample event");
        sampleEvent.setType(Type.NATIONAL_PARTNERSHIP);
        sampleEvent.setIncludesBattlePositions(false);

        return sampleEvent;
    }

    public Set<Event> getAllEvents(UUID promotionId) {
        List<EventEntity> entities;
        Set<Event> events = new HashSet<Event>();
        Event event;

        if(promotionId != null) {
            entities = eventRepo.findByfkPromotionId(promotionId);
        } else {
            entities = eventRepo.findAll();
        }

        for(EventEntity entity : entities) {
            event = new Event();
            event.setId(entity.getId());
            event.setPromotionId(entity.getFkPromotionId());
            event.setName(entity.getName());
            events.add(event);
        }

        return events;
    }

    public Event getEventById(UUID id) {
        EventEntity entity;
        Event event = new Event();
        
        try {
            if(id == null) {
                event = createSampleEvent(id);
            } else {
                entity = eventRepo.getReferenceById(id);
                event.setId(id);
                event.setName(entity.getName());
            }
        } catch(EntityNotFoundException e) {
            //add logging
            event = createSampleEvent(id);
        }

        return event;
    }

    public UUID addNewEvent(Event event) {
        EventEntity entity = new EventEntity();
        UUID id = UUID.randomUUID();

        entity.setId(id);
        entity.setName(event.getName());
        entity.setFkPromotionId(event.getPromotionId());
        eventRepo.save(entity);
        return id;
    }
}