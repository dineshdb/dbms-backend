package com.sankalpa.ictc_events.model;

import java.util.List;
import javax.persistence.*;

@Entity
public class EventSection {
    @Id
    @GeneratedValue
    int id;
    @ManyToMany(targetEntity = Room.class)
    List rooms;
    java.sql.Date startTime;
    int duration;

}
