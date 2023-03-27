package com.company;

import java.io.Serial;
import java.io.Serializable;

public class Consultation implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    private String date;
    private String time;
    private String cost;
    private String notes;
    private int consultTime;
    private String bookedDoctor;

    public Consultation(String date, String time, String cost, String notes, int consultTime, String bookedDoctor) {
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.notes = notes;
        this.consultTime = consultTime;
        this.bookedDoctor = bookedDoctor;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getCost() {
        return cost;
    }

    public String getNotes() {
        return notes;
    }

    public int getConsultTime() {
        return consultTime;
    }

    public String getBookedDoctor() {
        return bookedDoctor;
    }
}
