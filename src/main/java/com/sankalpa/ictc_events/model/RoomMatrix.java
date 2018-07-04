package com.sankalpa.ictc_events.model;

import java.time.LocalDate;

public class RoomMatrix {

    private static final int HOURS = 8;
    private static final int ROOMS = 15;

    private int year;
    private int month;
    private int day;
    private boolean[][] matrix = new boolean[HOURS][ROOMS];

    public RoomMatrix(){}

    public RoomMatrix(int year, int month, int day, boolean[][] matrix) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.matrix = matrix;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(boolean[][] matrix) {
        this.matrix = matrix;
    }

    public LocalDate getDate(){
        return LocalDate.of(getYear(), getMonth(), getDay());
    }
}
