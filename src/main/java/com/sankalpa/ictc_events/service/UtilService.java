package com.sankalpa.ictc_events.service;

import com.sankalpa.ictc_events.model.*;
import com.sankalpa.ictc_events.repository.EventRepository;
import com.sankalpa.ictc_events.repository.EventSectionRepository;
import com.sankalpa.ictc_events.repository.UtilRepository;
import org.apache.tomcat.jni.Local;
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

    @Autowired
    private RoomService roomService;

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

//        // prevent editing the event 1 hour before the event starts
//        List<PerDayInfo> perDayInfoList = eventInfo.getPerDayInfoList();
//        List<TimeSlot> timeSlots = new ArrayList<>();
//
//        String startingDate = eventInfo.getEventStartDate();
//        String startingTime;
//        String currentTime = LocalTime.now().toString();
//
//        for (PerDayInfo pdi : perDayInfoList){
//            if (startingDate.equals(pdi.getDate())){
//                timeSlots = pdi.getTimeSlotList();
//            }
//        }
//
//        startingTime = timeSlots.get(0).getStartingTime();
//        for (TimeSlot ts : timeSlots){
//
//            if (LocalTime.parse(ts.getStartingTime()).isBefore(LocalTime.parse(startingTime))) {
//                startingTime = ts.getStartingTime();
//            }
//        }
//        log.info(startingTime);
//        if (Math.abs(LocalTime.parse(currentTime).getHour() - LocalTime.parse(startingTime).getHour()) <= 1){
//            log.info("Cannot edit the event now");
//            return null;
//
//        } else {

        eventService.deleteEvent(eventId);
        return saveEvent(eventInfo);

        //}

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

    // here CustomDate object actually holds a string containing both the date and time
    public List<TimeSlot> findFreeSlotsAtTime(CustomDate date){

        // date is a string of example "2018-09-20 13:00:00" so split it into date and time
        String[] date_time = date.getDate().split("\\s+");

        List<Event> events = utilRepository.findEventsHappeningAtDate(LocalDate.parse(date_time[0]));

        List<EventSection> eventSections = new ArrayList<>();
        List<TimeSlot> filteredTimeSlots = new ArrayList<>();

        if (events.size() == 0){

            List<Room> allRooms = roomService.getAllRooms();

            LocalTime dayBegin = LocalTime.of(8, 0, 0);
            LocalTime dayEnd = LocalTime.of(17, 0, 0);

            TimeSlot ts = new TimeSlot(dayBegin.toString(), dayEnd.toString(), allRooms);
            filteredTimeSlots.add(ts);

            return filteredTimeSlots;
        }

        for (Event event : events){
            eventSections.addAll(event.getEventSections());
        }

        List<TimeSlot> freeTimeSlots = new ArrayList<>();

        for (EventSection eventSection : eventSections){

            List<Room> rooms = eventSection.getRooms();
            List<Room> allRooms = roomService.getAllRooms();
            List<Room> freeRooms = new ArrayList<>();

            for (Room room : allRooms){
                if (!rooms.contains(room)){
                    freeRooms.add(room);
                }
            }

            LocalTime dayBegin = LocalTime.of(8, 0, 0);
            LocalTime dayEnd = LocalTime.of(17, 0, 0);

            if (dayBegin.isBefore(eventSection.getEventSectionStartTime())){
                TimeSlot ts = new TimeSlot(dayBegin.toString(),
                        eventSection.getEventSectionStartTime().toString(), freeRooms);
                freeTimeSlots.add(ts);
            }

            if (eventSection.getEventSectionEndTime().isBefore(dayEnd)){
                TimeSlot ts = new TimeSlot(eventSection.getEventSectionEndTime().toString(),
                        dayEnd.toString(), freeRooms);
                freeTimeSlots.add(ts);
            }

        }
//        if (date_time.length > 1) {

            // time during which there are free slots
            LocalTime time = LocalTime.parse(date_time[1]);

            for (TimeSlot free : freeTimeSlots) {

                LocalTime start = LocalTime.parse(free.getStartingTime());
                LocalTime end = LocalTime.parse(free.getEndingTime());

                if ((time.isAfter(start) || time.equals(start)) && (time.isBefore(end) || time.equals(end))) {
                    filteredTimeSlots.add(free);
                }
            }

            for (TimeSlot ts : filteredTimeSlots) {
                log.info(ts.getStartingTime() + " " + ts.getEndingTime());
            }
//        }

        return filteredTimeSlots;
    }

    public List<IdMapper> findEventsHappeningAtDate(CustomDate date) {

        String[] date_time = date.getDate().split("\\s+");

        List<Event> events = utilRepository.findEventsHappeningAtDate(LocalDate.parse(date_time[0]));

        List<EventSection> eventSections = new ArrayList<>();
        for (Event event : events){
            eventSections.addAll(event.getEventSections());
        }

        List<TimeSlot> freeTimeSlots = new ArrayList<>();

        for (EventSection eventSection : eventSections){

            List<Room> rooms = eventSection.getRooms();
            List<Room> allRooms = roomService.getAllRooms();
            List<Room> freeRooms = new ArrayList<>();

            for (Room room : allRooms){
                if (!rooms.contains(room)){
                    freeRooms.add(room);
                }
            }

            LocalTime dayBegin = LocalTime.of(8, 0, 0);
            LocalTime dayEnd = LocalTime.of(17, 0, 0);

            if (dayBegin.isBefore(eventSection.getEventSectionStartTime())){
                TimeSlot ts = new TimeSlot(dayBegin.toString(),
                        eventSection.getEventSectionStartTime().toString(), freeRooms);
                freeTimeSlots.add(ts);
            }

            if (eventSection.getEventSectionEndTime().isBefore(dayEnd)){
                TimeSlot ts = new TimeSlot(eventSection.getEventSectionEndTime().toString(),
                        dayEnd.toString(), freeRooms);
                freeTimeSlots.add(ts);
            }

        }

        List<TimeSlot> filteredTimeSlots = new ArrayList<>();
        if (date_time.length > 1) {

            // time during which there are free slots
            LocalTime time = LocalTime.parse(date_time[1]);

            for (TimeSlot free : freeTimeSlots) {

                LocalTime start = LocalTime.parse(free.getStartingTime());
                LocalTime end = LocalTime.parse(free.getEndingTime());

                if ((time.isAfter(start) || time.equals(start)) && (time.isBefore(end) || time.equals(end))) {
                    filteredTimeSlots.add(free);
                }
            }

            for (TimeSlot ts : filteredTimeSlots) {
                log.info(ts.getStartingTime() + " " + ts.getEndingTime());
            }
        }

        return mapperHelper(events);
    }

    public List<IdMapper> findEventsByEventName(String name) {
        List<Event> events = utilRepository.findEventsByEventName(name);
        return mapperHelper(events);
    }
}
