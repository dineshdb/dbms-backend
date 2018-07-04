package com.sankalpa.ictc_events.model;

import java.util.List;

public class EventInfo {

    private Event event;
    private List<RoomMatrix> roomMatrixList;

    public EventInfo(){}

    public EventInfo(Event event, List<RoomMatrix> roomMatrixList) {
        this.event = event;
        this.roomMatrixList = roomMatrixList;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<RoomMatrix> getRoomMatrixList() {
        return roomMatrixList;
    }

    public void setRoomMatrixList(List<RoomMatrix> roomMatrixList) {
        this.roomMatrixList = roomMatrixList;
    }
}
