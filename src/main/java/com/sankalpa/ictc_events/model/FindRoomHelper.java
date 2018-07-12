package com.sankalpa.ictc_events.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class FindRoomHelper {

    private LocalDate eventSectionDate;
    private LocalTime eventSectionStartTime;
    private LocalTime eventSectionEndTime;

    public FindRoomHelper(){}

    public FindRoomHelper(LocalDate eventSectionDate, LocalTime eventSectionStartTime, LocalTime eventSectionEndTime) {
        this.eventSectionDate = eventSectionDate;
        this.eventSectionStartTime = eventSectionStartTime;
        this.eventSectionEndTime = eventSectionEndTime;
    }

    public FindRoomHelper(String eventSectionDate, String eventSectionStartTime, String eventSectionEndTime) {
        this.eventSectionDate = LocalDate.parse(eventSectionDate);
        this.eventSectionStartTime = LocalTime.parse(eventSectionStartTime);
        this.eventSectionEndTime = LocalTime.parse(eventSectionEndTime);
    }

    public LocalDate getEventSectionDate() {
        return eventSectionDate;
    }

    public void setEventSectionDate(LocalDate eventSectionDate) {
        this.eventSectionDate = eventSectionDate;
    }

    public void setEventSectionDate(String eventSectionDate) {
        this.eventSectionDate = LocalDate.parse(eventSectionDate);
    }

    public LocalTime getEventSectionStartTime() {
        return eventSectionStartTime;
    }

    public void setEventSectionStartTime(LocalTime eventSectionStartTime) {
        this.eventSectionStartTime = eventSectionStartTime;
    }

    public void setEventSectionStartTime(String eventSectionStartTime) {
        this.eventSectionStartTime = LocalTime.parse(eventSectionStartTime);
    }

    public LocalTime getEventSectionEndTime() {
        return eventSectionEndTime;
    }

    public void setEventSectionEndTime(LocalTime eventSectionEndTime) {
        this.eventSectionEndTime = eventSectionEndTime;
    }

    public void setEventSectionEndTime(String eventSectionEndTime) {
        this.eventSectionEndTime = LocalTime.parse(eventSectionEndTime);
    }
}
