package com.sankalpa.ictc_events.service;

import com.sankalpa.ictc_events.model.Event;
import com.sankalpa.ictc_events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents(){
        List<Event> events = new ArrayList<Event>();
        eventRepository.findAll().forEach(events::add);
        return events;
    }

//    public List<Event> getAllEvents(Long adminId){
//        return eventRepository.findByAdminUserId(adminId);
//    }

    public Event getEvent(Long eventId){
        return eventRepository.findById(eventId).orElse(null);
    }

    public Event updateEvent(Event updatedEvent){
        return eventRepository.save(updatedEvent);
    }

    public Event addEvent(Event newEvent){
        return eventRepository.save(newEvent);
    }

    public void deleteEvent(Long eventId){
        eventRepository.deleteById(eventId);
    }

//    public List<Event> findByOrganizerUserId(Long organizerId) {
//        return eventRepository.findByOrganizerUserId(organizerId);
//    }
}
