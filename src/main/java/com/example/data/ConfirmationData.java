package com.example.data;

public class ConfirmationData {
    private String hotelName;
    private String paymentMethod;
    private String checkInDate;
    private String checkOutDate;

    public ConfirmationData(String hotelName, String paymentMethod, String checkInDate, String checkOutDate) {
        this.hotelName = hotelName;
        this.paymentMethod = paymentMethod;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Hotel Name: " + hotelName + ", Payment Method: " + paymentMethod +
                ", Check-in Date: " + checkInDate + ", Check-out Date: " + checkOutDate;
    }
}
