package com.sankalpa.ictc_events.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private int eventDurationInDays;

    private Date eventStartDate;
    private Date eventEndDate;

    private int accepted;

    @ManyToOne
    private Admin admin;

    @ManyToOne
    private Organizer organizer;

    @OneToMany(mappedBy = "event", targetEntity = EventSection.class)
    @JsonIgnore
    private List<EventSection> eventSections;

    public Event(){}

    public Event(String eventName, String eventDescription, int expectedNumberOfParticipants,
                 int eventDurationInDays, int accepted) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.expectedNumberOfParticipants = expectedNumberOfParticipants;
        this.eventDurationInDays = eventDurationInDays;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.accepted = accepted;
    }

    public Event(String eventName, String eventDescription, int expectedNumberOfParticipants,
                 int eventDurationInDays, Date eventStartDate, Date eventEndDate, int accepted) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.expectedNumberOfParticipants = expectedNumberOfParticipants;
        this.eventDurationInDays = eventDurationInDays;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.accepted = accepted;
    }



    public Event(String eventName, String eventDescription, int expectedNumberOfParticipants,
                 int eventDurationInDays, Date eventStartDate, Date eventEndDate, int accepted,
                 Admin admin, Organizer organizer, List eventSections) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.expectedNumberOfParticipants = expectedNumberOfParticipants;
        this.eventDurationInDays = eventDurationInDays;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.accepted = accepted;
        this.admin = admin;
        this.organizer = organizer;
        this.eventSections = eventSections;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
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

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

    public int getEventDurationInDays() {
        return eventDurationInDays;
    }

    public void setEventDurationInDays(int eventDurationInDays) {
        this.eventDurationInDays = eventDurationInDays;
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
