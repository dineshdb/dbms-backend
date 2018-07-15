package com.sankalpa.ictc_events.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class FindRoomHelper {

    private String eventSectionDate;
    private String eventSectionStartTime;
    private String eventSectionEndTime;

    public FindRoomHelper(){}

    public FindRoomHelper(String eventSectionDate, String eventSectionStartTime, String eventSectionEndTime) {
        this.eventSectionDate = eventSectionDate;
        this.eventSectionStartTime = eventSectionStartTime;
        this.eventSectionEndTime = eventSectionEndTime;
    }

//    public FindRoomHelper(String eventSectionDate, String eventSectionStartTime, String eventSectionEndTime) {
//        this.eventSectionDate = LocalDate.parse(eventSectionDate);
//        this.eventSectionStartTime = LocalTime.parse(eventSectionStartTime);
//        this.eventSectionEndTime = LocalTime.parse(eventSectionEndTime);
//    }

    public String getEventSectionDate() {
        return eventSectionDate;
    }

    public void setEventSectionDate(String eventSectionDate) {
        this.eventSectionDate = eventSectionDate;
    }

//    public void setEventSectionDate(String eventSectionDate) {
//        this.eventSectionDate = LocalDate.parse(eventSectionDate);
//    }

    public String getEventSectionStartTime() {
        return eventSectionStartTime;
    }

    public void setEventSectionStartTime(String eventSectionStartTime) {
        this.eventSectionStartTime = eventSectionStartTime;
    }

//    public void setEventSectionStartTime(String eventSectionStartTime) {
//        this.eventSectionStartTime = LocalTime.parse(eventSectionStartTime);
//    }

    public String getEventSectionEndTime() {
        return eventSectionEndTime;
    }

    public void setEventSectionEndTime(String eventSectionEndTime) {
        this.eventSectionEndTime = eventSectionEndTime;
    }

//    public void setEventSectionEndTime(String eventSectionEndTime) {
//        this.eventSectionEndTime = LocalTime.parse(eventSectionEndTime);
//    }
}
