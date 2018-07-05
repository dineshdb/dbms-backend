package com.sankalpa.ictc_events.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(value = "ADMIN")
public class Admin extends User {

    @OneToMany(mappedBy = "admin", targetEntity = Event.class)
    @JsonIgnore
    private List<Event> events;

    public Admin() {
    }

    public Admin(String userName, String userPassword) {
        super(userName, userPassword);
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
