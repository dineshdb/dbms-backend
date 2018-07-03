package com.sankalpa.ictc_events.controller;

import com.sankalpa.ictc_events.model.EventSection;
import com.sankalpa.ictc_events.service.EventSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class EventSectionController {

    @Autowired
    private EventSectionService eventSectionService;

    @GetMapping("/eventSections")
    public @ResponseBody List<EventSection> getAllEventSections(){
        return eventSectionService.getAllEventSections();
    }

    @GetMapping("/eventSections/{eventSectionId}")
    public @ResponseBody EventSection getEventSection(@PathVariable Long eventSectionId){
        return eventSectionService.getEventSection(eventSectionId);
    }

    @PostMapping("/eventSections")
    public void addEventSection(@RequestBody EventSection newEventSection){
        eventSectionService.addEventSection(newEventSection);
    }

    @PutMapping("/eventSections/{eventSectionId}")
    public void updateEventSection(@PathVariable Long eventSectionId,
                                   @RequestBody EventSection updatedEventSection){
        eventSectionService.updateEventSection(eventSectionId, updatedEventSection);
    }

    @DeleteMapping("/eventSections/{eventSectionId}")
    public void deleteEventSection(@PathVariable Long eventSectionId){
        eventSectionService.deleteEvenSection(eventSectionId);
    }

}
