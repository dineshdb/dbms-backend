package com.sankalpa.ictc_events.service;

import com.sankalpa.ictc_events.model.DateString;
import com.sankalpa.ictc_events.model.EventSection;
import com.sankalpa.ictc_events.model.Room;
import com.sankalpa.ictc_events.repository.EventSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventSectionService {

//    private static final int ROOMS = 15;
//    private static final int HOURS = 8;

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

    public EventSection updateEventSection(EventSection updatedEvenSection){
        return eventSectionRepository.save(updatedEvenSection);
    }

    public EventSection addEventSection(EventSection newEventSection){
        return eventSectionRepository.save(newEventSection);
    }

    public void deleteEvenSection(Long eventSectionId){
        eventSectionRepository.deleteById(eventSectionId);
    }

//    public Long createEventSection(EventSection eventSection) {
//        addEventSection(eventSection);
//        return eventSection.getEventSectionId();
//    }

    // TODO: no need to return a boolean matrix;

//    public boolean[][] filterByEventSectionDate(DateString dateString){
//
//        // TODO: make sure that eventSections are sorted by Time i.e. from 9 to 16
//
//        LocalDate date = LocalDate.of(dateString.getYear(), dateString.getMonth(), dateString.getDay());
//        List<EventSection> eventSections =  eventSectionRepository.findByeventSectionDate(date);
//
//        boolean[][] matrix = new boolean[HOURS][ROOMS];
//
//        for (int i = 0; i < HOURS; i++){
//            for (int j = 0; j < ROOMS; j++){
//                matrix[i][j] = false;
//            }
//        }
//
//        for (int i = 0; i < HOURS; i++){
//
//            EventSection eventSection = eventSections.get(i);
//            List<Room> rooms = eventSection.getRooms();
//
//            for (Room room : rooms){
//                Long roomId = room.getRoomId();
//                matrix[i][(int) (roomId - 2)] = true;
//            }
//
//        }
//
//        return matrix;
//    }
}
