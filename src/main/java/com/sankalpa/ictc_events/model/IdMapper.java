package com.sankalpa.ictc_events.model;

public class IdMapper {

    private Long eventId;
    private EventInfo eventInfo;

    public IdMapper(){}

    public IdMapper(Long eventId, EventInfo eventInfo) {
        this.eventId = eventId;
        this.eventInfo = eventInfo;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public EventInfo getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(EventInfo eventInfo) {
        this.eventInfo = eventInfo;
    }
}
