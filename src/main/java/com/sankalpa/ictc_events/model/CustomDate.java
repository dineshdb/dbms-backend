package com.sankalpa.ictc_events.model;

import java.time.LocalDate;

public class CustomDate {
    private LocalDate date;

    public CustomDate(){};

    public CustomDate(String date){
        this.date = LocalDate.parse(date);
    }

    public CustomDate(LocalDate date){
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
