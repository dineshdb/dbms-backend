package com.sankalpa.ictc_events.controller;

import com.sankalpa.ictc_events.model.Event;
import com.sankalpa.ictc_events.model.EventInfo;
import com.sankalpa.ictc_events.model.Organizer;
import com.sankalpa.ictc_events.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OrganizerController {
    // TODO: ignore organizer controller for now since no organizer is present

//    @Autowired
//    private OrganizerService organizerService;
//
//    @GetMapping("/organizers")
//    public @ResponseBody List<Organizer> getAllOrganizers(){
//        return organizerService.getAllOrganizers();
//    }
//
//    @GetMapping("/organizers/{organizerId}")
//    public @ResponseBody Organizer getOrganizer(@PathVariable Long organizerId){
//        return organizerService.getOrganizer(organizerId);
//    }
//
//    @PostMapping("/organizers")
//    public void addOrganizer(@RequestBody Organizer newOrganizer){
//        organizerService.addOrganizer(newOrganizer);
//    }
//
//    @PutMapping("/organizers/{organizerId}")
//    public void updateorganizer(@RequestBody Organizer updatedOrganizer, @PathVariable Long organizerId){
//        organizerService.updateOrganizer(organizerId, updatedOrganizer);
//    }
//
//    @DeleteMapping("/organizers/{organizerId}")
//    public void deleteOrganizer(@PathVariable Long organizerId){
//        organizerService.deleteOrganizer(organizerId);
//    }
//
//    @GetMapping("/organizers/{organizerId}/events")
//    public List<Event> getAllEvents(@PathVariable Long organizerId){
//        return organizerService.getAllEvents(organizerId);
//    }
//
//    @PostMapping("/organizers/{organizerId}/events")
//    public void createEvent(@RequestBody Event event, @PathVariable Long organizerId){
//        organizerService.createEvent(event, organizerId);
//    }
//
//    @PostMapping("/organizers/{organizerId}/eventInfo")
//    public void eventInfo(@RequestBody EventInfo eventInfo, @PathVariable Long organizerId){
//        organizerService.eventInfo(eventInfo, organizerId);
//    }
}
