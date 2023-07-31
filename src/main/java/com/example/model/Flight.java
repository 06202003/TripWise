package com.example.model;

import java.util.Date;

public class Flight {
    private int id;
    private int noFlight;
    private String airport;
    private String Luggage;
//    tipe flight
//    nama flight
//

    public Flight(int id, int noFlight, String airport, String luggage) {
        this.id = id;
        this.noFlight = noFlight;
        this.airport = airport;
        Luggage = luggage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoFlight() {
        return noFlight;
    }

    public void setNoFlight(int noFlight) {
        this.noFlight = noFlight;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getLuggage() {
        return Luggage;
    }

    public void setLuggage(String luggage) {
        Luggage = luggage;
    }
}
