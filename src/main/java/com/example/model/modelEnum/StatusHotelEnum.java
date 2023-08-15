package com.example.model.modelEnum;

public enum StatusHotelEnum {
    AVAILABLE("Available"),
    FULL("Full"),
    CLOSED("Closed");

    private final String value;

    private StatusHotelEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
