package com.example.model;

import java.time.LocalTime;

public class Airplane {
    private String airplaneName;
    private LocalTime originTime;
    private LocalTime departureTime;
    private String ticketPrice;
    private String airplaneClass;


    public Airplane(String airplaneName,LocalTime originTime, LocalTime departureTime, String ticketPrice,String airplaneClass) {
        this.airplaneName = airplaneName;
        this.originTime = originTime;
        this.departureTime = departureTime;
        this.ticketPrice = ticketPrice;
        this.airplaneClass = airplaneClass;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public LocalTime getOriginTime() {
        return originTime;
    }

    public void setOriginTime(LocalTime originTime) {
        this.originTime = originTime;
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

    public String getAirplaneClass() {
        return airplaneClass;
    }

    public void setAirplaneClass(String airplaneClass) {
        this.airplaneClass = airplaneClass;
    }
}
