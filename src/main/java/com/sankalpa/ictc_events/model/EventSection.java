package com.sankalpa.ictc_events.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class EventSection {

    @Id
    @GeneratedValue
    private Long eventSectionId;

    private LocalDate eventSectionDate;
    private LocalTime eventSectionTime;

    @ManyToOne
    private Event event;

    @ManyToMany(targetEntity = Room.class, mappedBy = "eventSections")
    private List<Room> rooms;

    public Long getEventSectionId() {
        return eventSectionId;
    }

    public EventSection(){}

    public EventSection(LocalDate eventSectionDate, LocalTime eventSectionTime, Event event, List rooms) {
        this.eventSectionDate = eventSectionDate;
        this.eventSectionTime = eventSectionTime;
        this.event = event;
        this.rooms = rooms;
    }

    public void setEventSectionId(Long eventSectionId) {
        this.eventSectionId = eventSectionId;
    }

    public LocalDate getEventSectionDate() {
        return eventSectionDate;
    }

    public void setEventSectionDate(LocalDate eventSectionDate) {
        this.eventSectionDate = eventSectionDate;
    }

    public LocalTime getEventSectionTime() {
        return eventSectionTime;
    }

    public void setEventSectionTime(LocalTime eventSectionTime) {
        this.eventSectionTime = eventSectionTime;
    }

    public LocalDate getDate(){
        return eventSectionDate;
    }

    public int getHour(){
        return eventSectionTime.getHour();
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
