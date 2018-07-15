package com.sankalpa.ictc_events.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TimeSlot {

//    private LocalTime startingTime;
//    private LocalTime endingTime;
    private String startingTime;
    private String endingTime;
    private List<Room> rooms;

    public TimeSlot(){}

    public TimeSlot(String startingTime, String endingTime, List<Room> rooms){
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.rooms = rooms;
    }

//    public TimeSlot(String startingTime, String endingTime, List<Room> rooms) {
//        this.startingTime = LocalTime.parse(startingTime);
//        this.endingTime = LocalTime.parse(endingTime);
//        this.rooms = rooms;
//    }

//    public TimeSlot(LocalTime startingTime, LocalTime endingTime, List<Room> rooms) {
//        this.startingTime = startingTime;
//        this.endingTime = endingTime;
//        this.rooms = rooms;
//    }

    public String getStartingTime() {
        return startingTime.toString();
    }

//    public void setStartingTime(LocalTime startingTime) {
//        this.startingTime = startingTime;
//    }
//
//    public void setStartingTime(String startingTime) {
//        this.startingTime = LocalTime.parse(startingTime);
//    }

    public void setStartingTime(String startingTime){
        this.startingTime = startingTime;
    }

    public String getEndingTime() {
        return endingTime.toString();
    }

//    public void setEndingTime(LocalTime endingTime) {
//        this.endingTime = endingTime;
//    }
//
//    public void setEndingTime(String endingTime) {
//        this.endingTime = LocalTime.parse(endingTime);
//    }

    public void setEndingTime(String endingTime){
        this.endingTime = endingTime;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
