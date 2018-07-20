package com.sankalpa.ictc_events.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(value = "ADMIN")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "userId", scope = Admin.class)
public class Admin extends User {

//    @OneToMany(mappedBy = "admin", targetEntity = Event.class, fetch = FetchType.LAZY)
//    private List<Event> events;

    public Admin() {
    }

    public Admin(String userName, String userPassword) {
        super(userName, userPassword);
    }

//
//    public List<Event> getEvents() {
//        return events;
//    }
//
//    public void setEvents(List<Event> events) {
//        this.events = events;
//    }
}
