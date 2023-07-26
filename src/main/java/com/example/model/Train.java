package com.example.model;

import java.util.Date;

public class Train {
    private int id;
    private String station;
    private int noTrain;

    public Train(int id, String station, int noTrain) {
        this.id = id;
        this.station = station;
        this.noTrain = noTrain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public int getNoTrain() {
        return noTrain;
    }

    public void setNoTrain(int noTrain) {
        this.noTrain = noTrain;
    }
}
