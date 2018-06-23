package com.sankalpa.ictc_events.model;

import javax.persistence.*;
import java.util.List;

@Entity
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

    @ManyToMany(targetEntity = EventSection.class)  // room is the source column
    @JoinTable(name = "EventSection_Room",
            joinColumns = @JoinColumn(name = "Room_Id"),
            inverseJoinColumns = @JoinColumn(name = "EventSection_Id"))
    private List eventSections;
    // TODO: make use of eventSections

    public Room(){}

    public Room(Long roomId, String roomName, int roomCapacity, int roomFloor, String roomCategory, int costPerDay,
                int costPerHour, int costPerUnit, List eventSections) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomCapacity = roomCapacity;
        this.roomFloor = roomFloor;
        this.roomCategory = roomCategory;
        this.costPerDay = costPerDay;
        this.costPerHour = costPerHour;
        this.costPerUnit = costPerUnit;
        this.eventSections = eventSections;
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

    public List getEventSections() {
        return eventSections;
    }

    public void setEventSections(List eventSections) {
        this.eventSections = eventSections;
    }
}
