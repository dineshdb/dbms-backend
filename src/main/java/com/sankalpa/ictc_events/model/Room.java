package com.sankalpa.ictc_events.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "roomId", scope = Room.class)
public class Room {

    @Id
    @GeneratedValue
    private Long roomId;

    private String roomName;

    private int roomCapacity;
    private int roomFloor;
    private String roomCategory;
    private int costPerDay;
    private int costPerHour;
    private int costPerUnit;

//    @ManyToMany(targetEntity = EventSection.class, mappedBy = "rooms")
//    private List<EventSection> eventSections;

    public Room(){}

    public Room(String roomName, int roomCapacity, int roomFloor, String roomCategory, int costPerDay,
                int costPerHour, int costPerUnit) {
        this.roomName = roomName;
        this.roomCapacity = roomCapacity;
        this.roomFloor = roomFloor;
        this.roomCategory = roomCategory;
        this.costPerDay = costPerDay;
        this.costPerHour = costPerHour;
        this.costPerUnit = costPerUnit;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public int getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(int roomFloor) {
        this.roomFloor = roomFloor;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public int getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(int costPerDay) {
        this.costPerDay = costPerDay;
    }

    public int getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }

    public int getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(int costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

//    public List<EventSection> getEventSections() {
//        return eventSections;
//    }
//
//    public void setEventSections(List<EventSection> eventSections) {
//        this.eventSections = eventSections;
//    }
//
//    public void addEventSection(EventSection eventSection){
//        List<EventSection> eventSections = getEventSections();
//        if (eventSections == null){
//            eventSections = new ArrayList<>();
//        }
//        eventSections.add(eventSection);
//    }
}
