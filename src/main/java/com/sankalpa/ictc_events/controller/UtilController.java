package com.sankalpa.ictc_events.controller;

import com.sankalpa.ictc_events.model.*;
import com.sankalpa.ictc_events.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class UtilController {

    @Autowired
    private UtilService utilService;

    @PostMapping("/findRooms")
    public @ResponseBody List<Room> findRooms(@RequestBody FindRoomHelper findRoomHelper){
        return utilService.findRooms(findRoomHelper);
    }

    @PostMapping("/saveEvent")
    public @ResponseBody Event saveEvent(@RequestBody EventInfo eventInfo){
        return utilService.saveEvent(eventInfo);
    }

    @PostMapping("/updateEvent/{eventId}")
    public @ResponseBody Event updateEvent(@PathVariable Long eventId, @RequestBody EventInfo eventInfo){
        return utilService.updateEvent(eventId, eventInfo);
    }

    @GetMapping("/showAllEvents")
    public @ResponseBody List<IdMapper> showAllEvents(){
        return utilService.showAllEvents();
    }

    @PostMapping("/deleteEvent/{eventId}")
    public void deleteEvent(@PathVariable Long eventId){
        utilService.deleteEvent(eventId);
    }

    @PostMapping("/findEventsStartingAtDate")
    public @ResponseBody List<IdMapper> findEventsStartingAtDate(@RequestBody CustomDate date){
        return utilService.findEventsStartingAtDate(date);
    }

    @PostMapping("/findEventsByOrganizerName")
    public @ResponseBody List<IdMapper> findEventsByOrganizerName(@RequestBody CustomName name){
        return utilService.findEventsByOrganizerName(name.getName());
    }
}
