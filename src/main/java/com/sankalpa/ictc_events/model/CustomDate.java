package com.sankalpa.ictc_events.model;

import java.time.LocalDate;

public class CustomDate {
    private String date;

    public CustomDate(){};

    public CustomDate(String date){
        this.date = date;
    }

//    public CustomDate(LocalDate date){
//        this.date = date;
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
