package com.sankalpa.ictc_events.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "eventId", scope = Event.class)
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

    private LocalDate eventStartDate;
    private LocalDate eventEndDate;

    private String organizerName;
    private String organizerEmail;
    private String organizerAddress;
    private String organizerPhone;

//    private int accepted;

//    @ManyToOne
//    private Admin admin;

//    @ManyToOne
//    private Organizer organizer;

    @OneToMany(mappedBy = "event", targetEntity = EventSection.class, cascade = CascadeType.ALL)
    private List<EventSection> eventSections;

    public Event(){}

    public Event(String eventName, String eventDescription, int expectedNumberOfParticipants,
                 int eventDurationInDays, LocalDate eventStartDate, LocalDate eventEndDate, String organizerName,
                 String organizerEmail, String organizerAddress, String organizerPhone) {

        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.expectedNumberOfParticipants = expectedNumberOfParticipants;
        this.eventDurationInDays = eventDurationInDays;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.organizerName = organizerName;
        this.organizerEmail = organizerEmail;
        this.organizerAddress = organizerAddress;
        this.organizerPhone = organizerPhone;
    }

    //    public Event(String eventName, String eventDescription, int expectedNumberOfParticipants,
//                 int eventDurationInDays, int accepted) {
//        this.eventName = eventName;
//        this.eventDescription = eventDescription;
//        this.expectedNumberOfParticipants = expectedNumberOfParticipants;
//        this.eventDurationInDays = eventDurationInDays;
//        this.eventStartDate = eventStartDate;
//        this.eventEndDate = eventEndDate;
////        this.accepted = accepted;
//    }
//
//    public Event(String eventName, String eventDescription, int expectedNumberOfParticipants,
//                 int eventDurationInDays, LocalDate eventStartDate, LocalDate eventEndDate, int accepted) {
//        this.eventName = eventName;
//        this.eventDescription = eventDescription;
//        this.expectedNumberOfParticipants = expectedNumberOfParticipants;
//        this.eventDurationInDays = eventDurationInDays;
//        this.eventStartDate = eventStartDate;
//        this.eventEndDate = eventEndDate;
////        this.accepted = accepted;
//    }



//    public Event(String eventName, String eventDescription, int expectedNumberOfParticipants,
//                 int eventDurationInDays, LocalDate eventStartDate, LocalDate eventEndDate, int accepted,
//                 Admin admin, Organizer organizer, List eventSections) {
//        this.eventName = eventName;
//        this.eventDescription = eventDescription;
//        this.expectedNumberOfParticipants = expectedNumberOfParticipants;
//        this.eventDurationInDays = eventDurationInDays;
//        this.eventStartDate = eventStartDate;
//        this.eventEndDate = eventEndDate;
////        this.accepted = accepted;
//        this.admin = admin;
//        this.organizer = organizer;
//        this.eventSections = eventSections;
//    }


    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public String getOrganizerAddress() {
        return organizerAddress;
    }

    public void setOrganizerAddress(String organizerAddress) {
        this.organizerAddress = organizerAddress;
    }

    public String getOrganizerPhone() {
        return organizerPhone;
    }

    public void setOrganizerPhone(String organizerPhone) {
        this.organizerPhone = organizerPhone;
    }

//    public Admin getAdmin() {
//        return admin;
//    }
//
//    public void setAdmin(Admin admin) {
//        this.admin = admin;
//    }

    public LocalDate getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(LocalDate eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public LocalDate getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(LocalDate eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

//    public int getAccepted() {
//        return accepted;
//    }
//
//    public void setAccepted(int accepted) {
//        this.accepted = accepted;
//    }

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

//
//    public Organizer getOrganizer() {
//        return organizer;
//    }
//
//    public void setOrganizer(Organizer organizer) {
//        this.organizer = organizer;
//    }

    public List getEventSections() {
        return eventSections;
    }

    public void setEventSections(List eventSections) {
        this.eventSections = eventSections;
    }
}
