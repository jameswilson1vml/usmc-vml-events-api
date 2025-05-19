package com.vml.usmc.events.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vml.usmc.events.model.Event;
import com.vml.usmc.events.service.EventService;

import java.net.URI;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/events")
@Tag(name = "Events", description = "Events management APIs")
public class EventController {

    @Autowired
    private EventService eventService;

    @Operation(summary = "Get all events", description = "Returns a list of all available events", parameters = {
        @Parameter(in = ParameterIn.QUERY, name = "promotionId", description = "An optional query parameter to filter by promotionId", required = false, allowEmptyValue = false)
    })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved events",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Event.class)))
    })
    @GetMapping
    public ResponseEntity<Set<Event>> getEvents(@RequestParam(name = "promotionId", required = false) UUID promotionId) {
        return ResponseEntity.ok(eventService.getAllEvents(promotionId));
    }

    @Operation(summary = "Get an event", description = "Returns an event by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved an event",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Event.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @Operation(summary = "Post an event", description = "Adds an event")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created an event",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Event.class)))
    })
    @PostMapping
    public ResponseEntity<Event> addEvent(@Valid @RequestBody Event event) {
        UUID id = eventService.addNewEvent(event);

        event.setId(id);

        return ResponseEntity.created(URI.create("/events/" + id.toString()))
            .body(event);
    }
}
