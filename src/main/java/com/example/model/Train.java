package com.example.model;

import java.time.LocalTime;

public class Train {
    private String trainName;
    private LocalTime departureTime;

    private LocalTime originTime;

    private String ticketPrice;

    private String trainClass;

    public Train(String trainName,  LocalTime departureTime,LocalTime originTime, String ticketPrice) {
        this.trainName = trainName;
        this.departureTime = departureTime;
        this.originTime = originTime;
        this.ticketPrice = ticketPrice;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public LocalTime getOriginTime() {
        return originTime;
    }

    public void setOriginTime(LocalTime originTime) {
        this.originTime = originTime;
    }
}
