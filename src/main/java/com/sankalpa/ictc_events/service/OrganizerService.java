package com.sankalpa.ictc_events.service;

import com.sankalpa.ictc_events.model.Event;
import com.sankalpa.ictc_events.model.EventInfo;
import com.sankalpa.ictc_events.model.Organizer;
import com.sankalpa.ictc_events.model.RoomMatrix;
import com.sankalpa.ictc_events.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizerService {

    // TODO: make organizer repository connect to only user table
    @Autowired
    private OrganizerRepository organizerRepository;

    @Autowired
    private EventService eventService;

    public List<Organizer> getAllOrganizers(){
        List<Organizer> organizers = new ArrayList<Organizer>();
        organizerRepository.findAll().forEach(organizers::add);
        return organizers;
    }

    public void updateOrganizer(Long organizerId, Organizer updatedOrganizer){
        organizerRepository.save(updatedOrganizer);
    }

    public void addOrganizer(Organizer newOrganizer){
        organizerRepository.save(newOrganizer);
    }

    public void deleteOrganizer(Long organizerId){
        organizerRepository.deleteById(organizerId);
    }

    public Organizer getOrganizer(Long organizerId){
        return organizerRepository.findById(organizerId).orElse(null);
    }

    public List<Event> getAllEvents(Long organizerId) {
        return eventService.findByOrganizerUserId(organizerId);
    }

    public void createEvent(Event event, Long organizerId) {

        Organizer organizer = getOrganizer(organizerId);
        event.setOrganizer(organizer);

        // TODO: set the eventSections here too.
        eventService.addEvent(event);
    }

    public void eventInfo(EventInfo eventInfo, Long organizerId) {

        Event event = eventInfo.getEvent();
        createEvent(event, organizerId);

        List<RoomMatrix> roomMatrixList = new ArrayList<>();
        roomMatrixList = eventInfo.getRoomMatrixList();

        event.setEventStartDate(roomMatrixList.get(0).getDate());
        event.setEventEndDate(roomMatrixList.get(roomMatrixList.size() - 1).getDate());

        for (RoomMatrix matrix : roomMatrixList){
            Date date = matrix.getDate();

        }

        // TODO: finally update the event;
    }
}
