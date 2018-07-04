package com.sankalpa.ictc_events.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class EventSection {

    @Id
    @GeneratedValue
    private Long eventSectionId;

    private LocalDateTime eventSectionStartTimestamp;

    @ManyToOne
    private Event event;

    @ManyToMany(targetEntity = Room.class, mappedBy = "eventSections")
    private List<Room> rooms;

    public Long getEventSectionId() {
        return eventSectionId;
    }

    public EventSection(){}

    public EventSection(LocalDateTime eventSectionStartTimestamp, Event event, List rooms) {
        this.eventSectionStartTimestamp = eventSectionStartTimestamp;
        this.event = event;
        this.rooms = rooms;
    }

    public void setEventSectionId(Long eventSectionId) {
        this.eventSectionId = eventSectionId;
    }

    public LocalDateTime getEventSectionStartTimestamp() {
        return eventSectionStartTimestamp;
    }

    public void setEventSectionStartTimestamp(LocalDateTime eventSectionStartTimestamp) {
        this.eventSectionStartTimestamp = eventSectionStartTimestamp;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List getRooms() {
        return rooms;
    }

    public void setRooms(List rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room){
        List<Room> rooms = getRooms();
        if (rooms == null){
            rooms = new ArrayList<>();
        }
        rooms.add(room);
    }
}
