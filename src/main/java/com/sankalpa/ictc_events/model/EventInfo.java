package com.sankalpa.ictc_events.model;

import java.time.LocalDate;
import java.util.List;

public class EventInfo {

    private String organizerName;
    private String organizerEmail;
    private String organizerAddress;
    private String organizerPhone;

    private String eventName;
    private String eventDescription;
    private int eventDurationInDays;
    private String eventStartDate;
    private String eventEndDate;
    private int expectedNumberOfParticipants;

    private List<PerDayInfo> perDayInfoList;

    public EventInfo(){}

    public EventInfo(String organizerName, String organizerEmail, String organizerAddress, String organizerPhone,
                     String eventName, String eventDescription, int eventDurationInDays, String eventStartDate,
                     String eventEndDate, int expectedNumberOfParticipants, List<PerDayInfo> perDayInfoList) {
        this.organizerName = organizerName;
        this.organizerEmail = organizerEmail;
        this.organizerAddress = organizerAddress;
        this.organizerPhone = organizerPhone;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDurationInDays = eventDurationInDays;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.expectedNumberOfParticipants = expectedNumberOfParticipants;
        this.perDayInfoList = perDayInfoList;
    }
//
//    public EventInfo(String organizerName, String organizerEmail, String organizerAddress, String organizerPhone,
//                     String eventName, String eventDescription, int eventDurationInDays, String eventStartDate,
//                     String eventEndDate, int expectedNumberOfParticipants, List<PerDayInfo> perDayInfoList) {
//        this.organizerName = organizerName;
//        this.organizerEmail = organizerEmail;
//        this.organizerAddress = organizerAddress;
//        this.organizerPhone = organizerPhone;
//        this.eventName = eventName;
//        this.eventDescription = eventDescription;
//        this.eventDurationInDays = eventDurationInDays;
//        this.eventStartDate = LocalDate.parse(eventStartDate);
//        this.eventEndDate = LocalDate.parse(eventEndDate);;
//        this.expectedNumberOfParticipants = expectedNumberOfParticipants;
//        this.perDayInfoList = perDayInfoList;
//    }

    public EventInfo(String organizerName, String organizerEmail, String organizerAddress, String organizerPhone,
                     String eventName, String eventDescription, int eventDurationInDays, String eventStartDate,
                     String eventEndDate, int expectedNumberOfParticipants) {
        this.organizerName = organizerName;
        this.organizerEmail = organizerEmail;
        this.organizerAddress = organizerAddress;
        this.organizerPhone = organizerPhone;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDurationInDays = eventDurationInDays;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.expectedNumberOfParticipants = expectedNumberOfParticipants;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public String getOrganizerAddress() {
        return organizerAddress;
    }

    public void setOrganizerAddress(String organizerAddress) {
        this.organizerAddress = organizerAddress;
    }

    public String getOrganizerPhone() {
        return organizerPhone;
    }

    public void setOrganizerPhone(String organizerPhone) {
        this.organizerPhone = organizerPhone;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public int getEventDurationInDays() {
        return eventDurationInDays;
    }

    public void setEventDurationInDays(int eventDurationInDays) {
        this.eventDurationInDays = eventDurationInDays;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

//    public void setEventEndDate(LocalDate eventEndDate) {
//        this.eventEndDate = eventEndDate;
//    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public int getExpectedNumberOfParticipants() {
        return expectedNumberOfParticipants;
    }

    public void setExpectedNumberOfParticipants(int expectedNumberOfParticipants) {
        this.expectedNumberOfParticipants = expectedNumberOfParticipants;
    }

    public List<PerDayInfo> getPerDayInfoList() {
        return perDayInfoList;
    }

    public void setPerDayInfoList(List<PerDayInfo> perDayInfoList) {
        this.perDayInfoList = perDayInfoList;
    }

    //    private Event event;
//    private List<RoomMatrix> roomMatrixList;
//
//    public EventInfo(){}
//
//    public EventInfo(Event event, List<RoomMatrix> roomMatrixList) {
//        this.event = event;
//        this.roomMatrixList = roomMatrixList;
//    }
//
//    public Event getEvent() {
//        return event;
//    }
//
//    public void setEvent(Event event) {
//        this.event = event;
//    }
//
//    public List<RoomMatrix> getRoomMatrixList() {
//        return roomMatrixList;
//    }
//
//    public void setRoomMatrixList(List<RoomMatrix> roomMatrixList) {
//        this.roomMatrixList = roomMatrixList;
//    }
}
