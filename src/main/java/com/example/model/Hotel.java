package com.example.model;

import java.util.Date;

public class Hotel {
    private String nameHotel;
    private String location;
    private String checkIn;
    private String checkOut;
    private String tipeRoom;
    private String returnTicket;
    private String maxCapacity;
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Hotel(String nameHotel, String location, String checkIn, String checkOut, String tipeRoom, String returnTicket, String maxCapacity, String price) {
        this.nameHotel = nameHotel;
        this.location = location;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.tipeRoom = tipeRoom;
        this.returnTicket = returnTicket;
        this.maxCapacity = maxCapacity;
        this.price = price;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(String maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getTipeRoom() {
        return tipeRoom;
    }

    public void setTipeRoom(String tipeRoom) {
        this.tipeRoom = tipeRoom;
    }

    public String getReturnTicket() {
        return returnTicket;
    }

    public void setReturnTicket(String returnTicket) {
        this.returnTicket = returnTicket;
    }
}
