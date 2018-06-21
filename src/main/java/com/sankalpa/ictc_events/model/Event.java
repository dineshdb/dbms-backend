package com.sankalpa.ictc_events.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Event  {
    @Id
    @GeneratedValue
    private Long id;
    String eventName;
    String eventDescription;

    @ManyToOne
    Organizer organizer;

    @OneToMany(targetEntity = EventSection.class)
    List eventSection;


}
