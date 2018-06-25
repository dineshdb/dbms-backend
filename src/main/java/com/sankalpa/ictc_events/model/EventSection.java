package com.sankalpa.ictc_events.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;

@Entity
public class EventSection {

    @Id
    @GeneratedValue
    private Long eventSectionId;

    @Column(nullable = false)
    private Timestamp eventSectionStartTimestamp;

    private String eventSectionDescription;

    @Column(nullable = false)
    private Time eventSectionDuration;

    @ManyToOne
    private Event event;

    @ManyToMany(targetEntity = Room.class, mappedBy = "eventSections")
    private List rooms;

    public Long getEventSectionId() {
        return eventSectionId;
    }

    public EventSection(){}

    public EventSection(Timestamp eventSectionStartTimestamp, String eventSectionDescription,
                        Time eventSectionDuration, Event event, List rooms) {
        this.eventSectionStartTimestamp = eventSectionStartTimestamp;
        this.eventSectionDescription = eventSectionDescription;
        this.eventSectionDuration = eventSectionDuration;
        this.event = event;
        this.rooms = rooms;
    }

    public void setEventSectionId(Long eventSectionId) {
        this.eventSectionId = eventSectionId;
    }

    public Timestamp getEventSectionStartTimestamp() {
        return eventSectionStartTimestamp;
    }

    public void setEventSectionStartTimestamp(Timestamp eventSectionStartTimestamp) {
        this.eventSectionStartTimestamp = eventSectionStartTimestamp;
    }

    public String getEventSectionDescription() {
        return eventSectionDescription;
    }

    public void setEventSectionDescription(String eventSectionDescription) {
        this.eventSectionDescription = eventSectionDescription;
    }

    public Time getEventSectionDuration() {
        return eventSectionDuration;
    }

    public void setEventSectionDuration(Time eventSectionDuration) {
        this.eventSectionDuration = eventSectionDuration;
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
}
