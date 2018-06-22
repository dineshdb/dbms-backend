package com.sankalpa.ictc_events.model;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    int roomId;
    String roomName;
    int roomCapacity;
    int roomFloor;
    String roomCategory;
    int costPerDay;
    int costPerHour;
    int costPerUnit;
}
