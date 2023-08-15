package com.example.model.modelEnum;

public enum YesNoEnum {
    YES("Yes"),
    NO("No");

    private final String value;

    private YesNoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


