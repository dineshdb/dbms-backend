package com.sankalpa.ictc_events.model;

import java.sql.Date;

public class RoomMatrix {

    private static final int HOURS = 8;
    private static final int ROOMS = 15;

    private Date date;
    private boolean[][] matrix = new boolean[HOURS][ROOMS];

    public RoomMatrix(){}

    public RoomMatrix(Date date, boolean[][] matrix){
        this.date = date;
        this.matrix = matrix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(boolean[][] matrix) {
        this.matrix = matrix;
    }
}
