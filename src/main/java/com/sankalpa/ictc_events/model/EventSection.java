package com.sankalpa.ictc_events.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Cascade;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "eventSectionId", scope = EventSection.class)
public class EventSection {

    @Id
    @GeneratedValue
    private Long eventSectionId;

    private LocalDate eventSectionDate;
    private LocalTime eventSectionStartTime;
    private LocalTime eventSectionEndTime;

    @ManyToOne
    @JsonIgnore
    private Event event;

    @ManyToMany(targetEntity = Room.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Room> rooms;

    public EventSection(){}

    public EventSection(LocalDate eventSectionDate, LocalTime eventSectionStartTime, LocalTime eventSectionEndTime) {
        this.eventSectionDate = eventSectionDate;
        this.eventSectionStartTime = eventSectionStartTime;
        this.eventSectionEndTime = eventSectionEndTime;
    }

    public void setEventSectionId(Long eventSectionId) {
        this.eventSectionId = eventSectionId;
    }

    public Long getEventSectionId() {
        return eventSectionId;
    }

    public LocalDate getEventSectionDate() {
        return eventSectionDate;
    }

    public void setEventSectionDate(LocalDate eventSectionDate) {
        this.eventSectionDate = eventSectionDate;
    }


    public LocalTime getEventSectionStartTime() {
        return eventSectionStartTime;
    }

    public LocalTime getEventSectionEndTime() {
        return eventSectionEndTime;
    }

    public void setEventSectionEndTime(LocalTime eventSectionEndTime) {
        this.eventSectionEndTime = eventSectionEndTime;
    }

//    public LocalDate getDate(){
//        return eventSectionDate;
//    }

//    public int getHour(){
//        return eventSectionStartTime.getHour();
//    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
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
