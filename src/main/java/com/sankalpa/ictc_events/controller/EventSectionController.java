package com.sankalpa.ictc_events.controller;

import com.sankalpa.ictc_events.model.DateString;
import com.sankalpa.ictc_events.model.EventSection;
import com.sankalpa.ictc_events.model.FindRoomHelper;
import com.sankalpa.ictc_events.model.Room;
import com.sankalpa.ictc_events.service.EventSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
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
    public @ResponseBody EventSection addEventSection(@RequestBody EventSection newEventSection){
        return eventSectionService.addEventSection(newEventSection);
    }

    @PutMapping("/eventSections")
    public @ResponseBody EventSection updateEventSection(@RequestBody EventSection updatedEventSection){
        return eventSectionService.updateEventSection(updatedEventSection);
    }

    @DeleteMapping("/eventSections/{eventSectionId}")
    public void deleteEventSection(@PathVariable Long eventSectionId){
        eventSectionService.deleteEvenSection(eventSectionId);
    }
//    // TODO: return a boolean[][] array instead of a list of EventSection
//    @PostMapping("/eventSections/findByDate")
//    public @ResponseBody boolean[][] filterByEventSectionDate(@RequestBody DateString dateString){
//        return eventSectionService.filterByEventSectionDate(dateString);
//    }
}
