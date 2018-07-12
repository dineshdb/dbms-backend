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
    public @ResponseBody Event addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }

    @PutMapping("/events")
    public @ResponseBody Event updateEvent(@RequestBody Event updatedEvent){
        return eventService.updateEvent(updatedEvent);
    }

    @DeleteMapping("/events/{eventId}")
    public void deleteEvent(@PathVariable Long eventId){
        eventService.deleteEvent(eventId);
    }
}
