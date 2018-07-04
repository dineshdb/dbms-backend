package com.sankalpa.ictc_events.service;

import com.sankalpa.ictc_events.model.*;
import com.sankalpa.ictc_events.repository.OrganizerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizerService {

    private static final Logger log = LoggerFactory.getLogger(OrganizerService.class);

    // TODO: make organizer repository connect to only user table
    @Autowired
    private OrganizerRepository organizerRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private EventSectionService eventSectionService;

    @Autowired
    private RoomService roomService;

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

    public Long createEvent(Event event, Long organizerId) {

        Organizer organizer = getOrganizer(organizerId);
        event.setOrganizer(organizer);

        // TODO: set the eventSections here too.
        return eventService.addEvent(event);
    }

    public void eventInfo(EventInfo eventInfo, Long organizerId) {

        Long eventId = createEvent(eventInfo.getEvent(), organizerId);

        // DEBUG
        log.info("DEBUG: An Event is created with id " + eventId);

        Event event = eventService.getEvent(eventId);

        List<RoomMatrix> roomMatrixList = eventInfo.getRoomMatrixList();

        // DEBUG
        log.info("DEBUG: Event Start Date " + roomMatrixList.get(0).getDate());

        event.setEventStartDate(roomMatrixList.get(0).getDate());

        // DEBUG
        log.info("DEBUG: Event End Date " + roomMatrixList.get(roomMatrixList.size() - 1).getDate());

        event.setEventEndDate(roomMatrixList.get(roomMatrixList.size() - 1).getDate());

        for (RoomMatrix roomMatrix : roomMatrixList){
            Date date = roomMatrix.getDate();

            boolean[][] matrix = roomMatrix.getMatrix();
            for (int i = 0; i < matrix.length; i++){
                if (atLeastOne(matrix[i]) == true){

                    // construct the eventSection
                    Long eventSectionId = eventSectionService.createEventSection(new EventSection());

                    // DEBUG
                    log.info("DEBUG: EventSection Created with Id " + eventSectionId);

                    EventSection eventSection = eventSectionService.getEventSection(eventSectionId);
                    eventSection.setEvent(event);
                    eventSection.setEventSectionStartTimestamp(constructTimestamp(date, 9 + i));

                    // DEBUG
                    log.info("DEBUG: EventSection Timestamp " + constructTimestamp(date, 9 + i));

                    List<Room> rooms = roomService.getAllRoomsInOrder();
                    // rooms have id from 2 to 16

                    int ROOMS = rooms.size();

                    for (int j = 0; j < ROOMS; j++){
                        if(matrix[i][j] == true){
                            Room room = roomService.getRoom((long) 2 + j);

                            // DEBUG
                            log.info("DEBUG: Got room with Id " + room.getRoomId());

                            eventSection.addRoom(room);
                            room.addEventSection(eventSection);
                            roomService.updateRoom((long) 2 + j, room);

                            // DEBUG
                            log.info("DEBUG: Room updated with Id " + room.getRoomId());
                        }
                    }
                    eventSectionService.updateEventSection(eventSectionId, eventSection);

                    // DEBUG
                    log.info("DEBUG: EventSection Updated with Id " + eventSectionId);
                }
            }

        }
        eventService.updateEvent(eventId, event);

        // DEBUG
        log.info("DEBUG: Event Updated with Id " + eventId);

        // TODO: finally update the event;
    }

    private boolean atLeastOne(boolean[] mat){
        // check if any of the time intervals is assigned a room
        // if true at least one room is assigned to that time intervals
        // so we need an eventSection for that.

        boolean result = false;
        for (int i = 0; i < mat.length; i++){
            result = false | mat[i];
        }
        return result;
    }

    private Timestamp constructTimestamp(Date date, int startHour){
        // TODO: replace this deprecated method
        return new Timestamp(date.getYear(), date.getMonth(), date.getDay(), startHour, 0, 0, 0);
    }
}
