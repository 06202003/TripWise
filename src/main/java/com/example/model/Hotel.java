package com.example.model;

import com.example.model.modelEnum.StatusHotelEnum;
import com.example.model.modelEnum.YesNoEnum;

import java.math.BigDecimal;

public class Hotel {
    private int id;
    private String hotelName;
    private String location;
    private int cityId; // This represents the foreign key
    private String tipeRoom;
    private YesNoEnum returnTicket;
    private int maxCapacity;
    private BigDecimal price;
    private StatusHotelEnum status;
    private int remainingRoom;
    private City city;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTipeRoom() {
        return tipeRoom;
    }

    public void setTipeRoom(String tipeRoom) {
        this.tipeRoom = tipeRoom;
    }

    public YesNoEnum getReturnTicket() {
        return returnTicket;
    }

    public void setReturnTicket(YesNoEnum returnTicket) {
        this.returnTicket = returnTicket;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public StatusHotelEnum getStatus() {
        return status;
    }

    public void setStatus(StatusHotelEnum status) {
        this.status = status;
    }

    public int getRemainingRoom() {
        return remainingRoom;
    }

    public void setRemainingRoom(int remainingRoom) {
        this.remainingRoom = remainingRoom;
    }
}
