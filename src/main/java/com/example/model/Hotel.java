package com.example.model;

import java.util.Date;

public class Hotel {
//    nama hotel
//
    private String checkIn;
    private String checkOut;
    private String tipeRoom;
    private String returnTicket;

    public Hotel(String checkIn, String checkOut, String tipeRoom, String returnTicket) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.tipeRoom = tipeRoom;
        this.returnTicket = returnTicket;
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
