package com.sankalpa.ictc_events.repository;

import com.sankalpa.ictc_events.model.EventSection;
import com.sankalpa.ictc_events.model.FindRoomHelper;
import com.sankalpa.ictc_events.model.Room;
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
                "and ((e.eventSectionStartTime between ?2 and ?3) or (e.eventSectionEndTime between ?2 and ?3))")
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
}
