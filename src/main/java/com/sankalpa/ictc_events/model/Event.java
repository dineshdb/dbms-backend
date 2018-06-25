package com.sankalpa.ictc_events.model;

import java.util.List;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class Event  {

    @Id
    @GeneratedValue
    private Long eventId;

    @Column(nullable = false)
    private String eventName;

    private String eventDescription;
    private int expectedNumberOfParticipants;

    @Column(nullable = false)
    private Date eventStartDate;

    @Column(nullable = false)
    private Date eventEndDate;

    @ManyToOne
    private Organizer organizer;

    @OneToMany(mappedBy = "event", targetEntity = EventSection.class)
    private List eventSections;

    public Event(){}

    public Event(String eventName, String eventDescription, int expectedNumberOfParticipants,
                 Date eventStartDate, Date eventEndDate, Organizer organizer, List eventSections) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.expectedNumberOfParticipants = expectedNumberOfParticipants;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.organizer = organizer;
        this.eventSections = eventSections;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public int getExpectedNumberOfParticipants() {
        return expectedNumberOfParticipants;
    }

    public void setExpectedNumberOfParticipants(int expectedNumberOfParticipants) {
        this.expectedNumberOfParticipants = expectedNumberOfParticipants;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public List getEventSections() {
        return eventSections;
    }

    public void setEventSections(List eventSections) {
        this.eventSections = eventSections;
    }
}
