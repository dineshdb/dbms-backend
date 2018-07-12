package com.sankalpa.ictc_events.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue( value = "ORG")
public class Organizer extends User{

    // TODO: no use of organizer class for now; organizer is embedded within the event;
//
//    private String organizerName;
//    private String organizerEmail;
//    private String organizerAddress;
//    private String organizerPhone;
//
//    @OneToMany(targetEntity = Event.class, mappedBy = "organizer")
//    @JsonIgnore
//    private List<Event> events;
//
//    public Organizer(){}
//
//    public Organizer(String organizerName, String organizerEmail, String organizerAddress, String organizerPhone) {
//        this.organizerName = organizerName;
//        this.organizerEmail = organizerEmail;
//        this.organizerAddress = organizerAddress;
//        this.organizerPhone = organizerPhone;
//        this.events = events;
//    }
//
//    public Organizer(String userName, String userPassword, String organizerName, String organizerEmail,
//                     String organizerAddress, String organizerPhone) {
//        super(userName, userPassword);
//        this.organizerName = organizerName;
//        this.organizerEmail = organizerEmail;
//        this.organizerAddress = organizerAddress;
//        this.organizerPhone = organizerPhone;
//        this.events = events;
//    }
//
//    public String getOrganizerName() {
//        return organizerName;
//    }
//
//    public void setOrganizerName(String organizerName) {
//        this.organizerName = organizerName;
//    }
//
//    public String getOrganizerEmail() {
//        return organizerEmail;
//    }
//
//    public void setOrganizerEmail(String organizerEmail) {
//        this.organizerEmail = organizerEmail;
//    }
//
//    public String getOrganizerAddress() {
//        return organizerAddress;
//    }
//
//    public void setOrganizerAddress(String organizerAddress) {
//        this.organizerAddress = organizerAddress;
//    }
//
//    public String getOrganizerPhone() {
//        return organizerPhone;
//    }
//
//    public void setOrganizerPhone(String organizerPhone) {
//        this.organizerPhone = organizerPhone;
//    }
//
//    public List getEvents() {
//        return events;
//    }
//
//    public void setEvents(List events) {
//        this.events = events;
//    }
}
