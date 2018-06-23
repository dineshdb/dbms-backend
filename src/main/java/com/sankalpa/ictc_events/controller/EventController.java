package com.sankalpa.ictc_events.controller;

import com.sankalpa.ictc_events.model.Event;
import com.sankalpa.ictc_events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public @ResponseBody List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping("/events/{eventId}")
    public @ResponseBody Event getEvent(@PathVariable Long eventId){
        return eventService.getEvent(eventId);
    }

    @PostMapping("/events")
    public void addEvent(@RequestBody Event event){
        eventService.addEvent(event);
    }

    @PutMapping("/events/{eventId}")
    public void updateEvent(@RequestBody Event updatedEvent,
                            @PathVariable Long eventId){
        eventService.updateEvent(eventId, updatedEvent);
    }

    @DeleteMapping("/events/{eventId}")
    public void deleteEvent(@PathVariable Long eventId){
        eventService.deleteEvent(eventId);
    }
}
