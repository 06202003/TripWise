package com.example.model;

import java.time.LocalTime;

public class Train {
    private String trainId;
    private String trainName;
    private String departureTime;

    private String originTime;

    private String ticketPrice;

    private String trainClass;

    public Train(String trainId, String trainName, String departureTime, String originTime, String ticketPrice, String trainClass) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.departureTime = departureTime;
        this.originTime = originTime;
        this.ticketPrice = ticketPrice;
        this.trainClass = trainClass;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainClass() {
        return trainClass;
    }

    public void setTrainClass(String trainClass) {
        this.trainClass = trainClass;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getOriginTime() {
        return originTime;
    }

    public void setOriginTime(String originTime) {
        this.originTime = originTime;
    }
}
