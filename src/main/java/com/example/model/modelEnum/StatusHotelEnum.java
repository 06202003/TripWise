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

    public static StatusHotelEnum fromValue(String value) {
        for (StatusHotelEnum a : values()) {
            if (a.getValue().equalsIgnoreCase(value)) {
                return a;
            }
        }
        throw new IllegalArgumentException("No enum constant found for value: " + value);
    }
}
