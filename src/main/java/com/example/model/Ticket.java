package com.example.model;

import java.util.Date;

public class Ticket extends User{
    private int id;
    private int PNR;
    private String orderDate;
    private String price;
    private String departure;
    private String arrival;
    private Date departureTime;
    private Date arrivalTime;
    private int chairNumber;

    public Ticket(int id, int PNR, String orderDate, String price, String departure, String arrival, Date departureTime, Date arrivalTime, int chairNumber) {
        super();
        this.id = id;
        this.PNR = PNR;
        this.orderDate = orderDate;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.chairNumber = chairNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPNR() {
        return PNR;
    }

    public void setPNR(int PNR) {
        this.PNR = PNR;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(int chairNumber) {
        this.chairNumber = chairNumber;
    }
}
