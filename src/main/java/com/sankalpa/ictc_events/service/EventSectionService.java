package com.sankalpa.ictc_events.service;

import com.sankalpa.ictc_events.model.EventSection;
import com.sankalpa.ictc_events.repository.EventSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventSectionService {

    @Autowired
    private EventSectionRepository eventSectionRepository;

    public List<EventSection> getAllEventSections(){
        List<EventSection> eventSections = new ArrayList<EventSection>();
        eventSectionRepository.findAll().forEach(eventSections::add);
        return eventSections;
    }

    public EventSection getEventSection(Long eventSectionId){
        return eventSectionRepository.findById(eventSectionId).orElse(null);
    }

    public void updateEventSection(Long eventSectionId,
                                   EventSection updatedEvenSection){
        eventSectionRepository.save(updatedEvenSection);
    }

    public void addEventSection(EventSection newEventSection){
        eventSectionRepository.save(newEventSection);
    }

    public void deleteEvenSection(Long eventSectionId){
        eventSectionRepository.deleteById(eventSectionId);
    }

    public Long createEventSection(EventSection eventSection) {
        addEventSection(eventSection);
        return eventSection.getEventSectionId();
    }
}
