package com.sankalpa.ictc_events.model;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PerDayInfo {

    private String date;
    private List<TimeSlot> timeSlotList;

    public PerDayInfo(){}

    public PerDayInfo(String date){
        this.date = date;
    }

    public PerDayInfo(String date, List<TimeSlot> timeSlotList) {
        this.date = date;
        this.timeSlotList = timeSlotList;
    }

//    public PerDayInfo(String date, List<TimeSlot> timeSlotList) {
//        this.date = date;
//        this.timeSlotList = timeSlotList;
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public void setDate(String date) {
//        this.date = LocalDate.parse(date);
//    }

    public List<TimeSlot> getTimeSlotList() {
        return timeSlotList;
    }

    public void setTimeSlotList(List<TimeSlot> timeSlotList) {
        this.timeSlotList = timeSlotList;
    }
}
