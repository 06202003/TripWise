package com.example.model;

import java.util.Date;

public class Ticket {
    private int id;
    private String name;
    private int NIK;
    private int PNR; //kode booking
    private String orderDate;
    private String contact;
    private String address;
    private String price;
    private String departure;
    private String arrival;
    private Date departureTime;
    private Date arrivalTime;
    private int noChair;

    public Ticket(int id, String name, int NIK, int PNR, String orderDate, String contact, String address, String price, String departure, String arrival, Date departureTime, Date arrivalTime, int noChair) {
        this.id = id;
        this.name = name;
        this.NIK = NIK;
        this.PNR = PNR;
        this.orderDate = orderDate;
        this.contact = contact;
        this.address = address;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.noChair = noChair;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNIK() {
        return NIK;
    }

    public void setNIK(int NIK) {
        this.NIK = NIK;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getNoChair() {
        return noChair;
    }

    public void setNoChair(int noChair) {
        this.noChair = noChair;
    }
}
