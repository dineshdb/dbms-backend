package com.sankalpa.ictc_events.service;

import com.sankalpa.ictc_events.model.*;
import com.sankalpa.ictc_events.repository.EventRepository;
import com.sankalpa.ictc_events.repository.EventSectionRepository;
import com.sankalpa.ictc_events.repository.UtilRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UtilService {

    final Logger log = LoggerFactory.getLogger(UtilService.class);

    @Autowired
    private UtilRepository utilRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private EventSectionService eventSectionService;

    public List<Room> findRooms(FindRoomHelper findRoomHelper) {
        return utilRepository.findRooms(findRoomHelper);
    }

    public Event saveEvent(EventInfo eventInfo) {

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now();

        if (eventInfo.getEventStartDate() == null && eventInfo.getEventEndDate() == null){
            // find out the event start and end date from event info
            List<PerDayInfo> perDayInfoList = eventInfo.getPerDayInfoList();
            List<LocalDate> dates = new ArrayList<>();

            for (PerDayInfo pdi : perDayInfoList){
                dates.add(LocalDate.parse(pdi.getDate()));
            }

            Collections.sort(dates);

            startDate = dates.get(0);
            endDate = dates.get(dates.size() - 1);

        } else {
            startDate = LocalDate.parse(eventInfo.getEventStartDate());
            endDate = LocalDate.parse(eventInfo.getEventEndDate());

            log.info("Found event starting date: " + startDate.toString());
            log.info("Found event end date: " + endDate.toString());
        }

        Event event = eventService.addEvent(
                new Event(eventInfo.getEventName(), eventInfo.getEventDescription(),
                        eventInfo.getExpectedNumberOfParticipants(), eventInfo.getEventDurationInDays(),
                        startDate, endDate,
                        eventInfo.getOrganizerName(), eventInfo.getOrganizerEmail(), eventInfo.getOrganizerAddress(),
                        eventInfo.getOrganizerPhone())
        );

        List<PerDayInfo> perDayInfoList = eventInfo.getPerDayInfoList();
        List<EventSection> eventSections = new ArrayList<>();

        for (PerDayInfo p : perDayInfoList){

            LocalDate date = LocalDate.parse(p.getDate());
            List<TimeSlot> timeSlots = p.getTimeSlotList();

            for (TimeSlot t : timeSlots) {
                EventSection eventSection = eventSectionService.addEventSection(
                        new EventSection(date, LocalTime.parse(t.getStartingTime()), LocalTime.parse(t.getEndingTime()))
                );
                eventSection.setRooms(t.getRooms());
                eventSection.setEvent(event);
                eventSectionService.updateEventSection(eventSection);

                eventSections.add(eventSection);
            }
        }

        event.setEventSections(eventSections);
        eventService.updateEvent(event);

        return event;
    }

    public Event updateEvent(Long eventId, EventInfo eventInfo) {

        // prevent editing the event 1 hour before the event starts
        List<PerDayInfo> perDayInfoList = eventInfo.getPerDayInfoList();
        List<TimeSlot> timeSlots = new ArrayList<>();

        String startingDate = eventInfo.getEventStartDate();
        String startingTime;
        String currentTime = LocalDateTime.now().toString();

        for (PerDayInfo pdi : perDayInfoList){
            if (startingDate.equals(pdi.getDate())){
                timeSlots = pdi.getTimeSlotList();
            }
        }

        startingTime = timeSlots.get(0).getStartingTime();
        for (TimeSlot ts : timeSlots){

            if (LocalDateTime.parse(ts.getStartingTime()).isBefore(LocalDateTime.parse(startingTime))) {
                startingTime = ts.getStartingTime();
            }
        }

        if (Math.abs(LocalDateTime.parse(currentTime).getHour() - LocalDateTime.parse(startingTime).getHour()) <= 1){
            log.info("Cannot edit the event now");
            return null;

        } else {

            eventService.deleteEvent(eventId);
            return saveEvent(eventInfo);

        }

//        Event event = eventService.getEvent(eventId);
//
//        event.setOrganizerName(eventInfo.getOrganizerName());
//        event.setOrganizerEmail(eventInfo.getOrganizerEmail());
//        event.setOrganizerAddress(eventInfo.getOrganizerAddress());
//        event.setOrganizerPhone(eventInfo.getOrganizerPhone());
//
//        event.setEventName(eventInfo.getEventName());
//        event.setEventDescription(eventInfo.getEventDescription());
//        event.setEventDurationInDays(eventInfo.getEventDurationInDays());
//        event.setEventEndDate(eventInfo.getEventEndDate());
//        event.setEventStartDate(eventInfo.getEventStartDate());
//        event.setExpectedNumberOfParticipants(eventInfo.getExpectedNumberOfParticipants());
//
//        List<PerDayInfo> perDayInfoList = eventInfo.getPerDayInfoList();
//        List<EventSection> eventSections = event.getEventSections();
//
//        // remove old eventSections
//        for (EventSection e : eventSections){
//            eventSectionService.deleteEvenSection(e.getEventSectionId());
//        }
//
//        eventSections = new ArrayList<>();
//
//        for (PerDayInfo p : perDayInfoList){
//
//            LocalDate date = p.getDate();
//            List<TimeSlot> timeSlots = p.getTimeSlotList();
//
//            for (TimeSlot t : timeSlots) {
//                EventSection eventSection = eventSectionService.addEventSection(
//                        new EventSection(date, t.getStartingTime(), t.getEndingTime())
//                );
//                eventSection.setRooms(t.getRooms());
//                eventSection.setEvent(event);
//                eventSectionService.updateEventSection(eventSection);
//
//                eventSections.add(eventSection);
//            }
//        }
//
//        event.setEventSections(eventSections);
//        eventService.updateEvent(event);
//
//        return event;
    }

    public List<IdMapper> mapperHelper(List<Event> events){

        List<IdMapper> mappers = new ArrayList<>();

        for (Event event : events){
            IdMapper mapper = new IdMapper();
            EventInfo eventInfo = new EventInfo(event.getOrganizerName(), event.getOrganizerEmail(),
                    event.getOrganizerAddress(), event.getOrganizerPhone(), event.getEventName(),
                    event.getEventDescription(), event.getEventDurationInDays(), event.getEventStartDate().toString(),
                    event.getEventEndDate().toString(), event.getExpectedNumberOfParticipants());

            mapper.setEventId(event.getEventId());

            List<EventSection> eventSections = event.getEventSections();
            List<PerDayInfo> perDayInfoList = new ArrayList<>();

            while (eventSections.size() != 0){

                PerDayInfo pdi = new PerDayInfo(eventSections.get(0).getEventSectionDate().toString());
                List<TimeSlot> slots = new ArrayList<>();

                for (int j = 0; j < eventSections.size(); j++){

                    if (pdi.getDate().equals(eventSections.get(j).getEventSectionDate().toString())){
                        // remove this eventSection
                        EventSection e = eventSections.get(j);
                        TimeSlot timeSlot = new TimeSlot(e.getEventSectionStartTime().toString(),
                                e.getEventSectionEndTime().toString(),
                                e.getRooms());
                        slots.add(timeSlot);
                        eventSections.remove(e);
                    }
                }

                pdi.setTimeSlotList(slots);
                perDayInfoList.add(pdi);
            }

            eventInfo.setPerDayInfoList(perDayInfoList);
            mapper.setEventInfo(eventInfo);
            mappers.add(mapper);
        }
        return mappers;

    }

    public List<IdMapper> showAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return mapperHelper(events);
    }

    public void deleteEvent(Long eventId) {
        eventService.deleteEvent(eventId);
    }

    // returns a list of IdMapper<eventId,EventInfo> that start at a specific 'date'
    public List<IdMapper> findEventsStartingAtDate(CustomDate date) {
        List<Event> events = utilRepository.findEventsStartingAtDate(LocalDate.parse(date.getDate()));
        return mapperHelper(events);
    }

    public List<IdMapper> findEventsByOrganizerName(String organizerName){
        List<Event> events = utilRepository.findEventsByOrganizerName(organizerName);
        return mapperHelper(events);
    }

    public List<IdMapper> findEventsHappeningAtDate(CustomDate date) {
        List<Event> events = utilRepository.findEventsHappeningAtDate(LocalDate.parse(date.getDate()));
        return mapperHelper(events);
    }

    public List<IdMapper> findEventsByEventName(String name) {
        List<Event> events = utilRepository.findEventsByEventName(name);
        return mapperHelper(events);
    }
}
