package com.sankalpa.ictc_events.repository;

import com.sankalpa.ictc_events.model.*;
import org.hibernate.event.spi.EvictEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UtilRepository {

    @Autowired
    @PersistenceContext
    private EntityManager em;

    public List<Room> findRooms(FindRoomHelper findRoomHelper){

        LocalDate date = findRoomHelper.getEventSectionDate();
        LocalTime startTime = findRoomHelper.getEventSectionStartTime();
        LocalTime endTime = findRoomHelper.getEventSectionEndTime();
        List<Room> rooms = new ArrayList<>();
        List<EventSection> eventSectionsWithin = new ArrayList<>();

        // TODO: check if this works
        eventSectionsWithin.addAll((List<EventSection>) em.createQuery("select e from EventSection e where e.eventSectionDate=?1 " +
                "and ((e.eventSectionStartTime between ?2 and ?3) or (e.eventSectionEndTime between ?2 and ?3) " +
                "or ((?2 >= e.eventSectionStartTime) and (?3 <= e.eventSectionEndTime)))")
                .setParameter(1, date)
                .setParameter(2, startTime)
                .setParameter(3, endTime)
                .getResultList());

        // holds all the rooms
        rooms.addAll((List<Room>) em.createQuery("select r from Room r").getResultList());

        for (EventSection e : eventSectionsWithin){
            // remove these rooms from the 'rooms' list
            List<Room> excludeList = e.getRooms();

            for (Room room : excludeList){
                int index = rooms.indexOf(room);
                if (index != -1){
                    rooms.remove(index);
                }
            }
        }

        return rooms;
    }

    public List<Event> findEventsStartingAtDate(LocalDate date) {
        return (List<Event>) em.createQuery("select e from Event e where e.eventStartDate=?1")
                .setParameter(1, date)
                .getResultList();
    }

    public List<Event> findEventsByOrganizerName(String organizerName) {
        return (List<Event>) em.createQuery("select e from Event e where upper(e.organizerName) " +
                "like concat('%', upper(?1), '%')")
                .setParameter(1, organizerName)
                .getResultList();
    }

    public List<Event> findEventsHappeningAtDate(LocalDate date) {
        return (List<Event>) em.createQuery("select e from Event e where ?1>=e.eventStartDate and " +
                "?1<=eventEndDate")
                .setParameter(1, date)
                .getResultList();
    }

    public List<Event> findEventsByEventName(String eventName){
        return (List<Event>) em.createQuery("select e from Event e where upper(e.eventName) " +
                "like concat('%', upper(?1), '%')")
                .setParameter(1, eventName)
                .getResultList();
    }
}