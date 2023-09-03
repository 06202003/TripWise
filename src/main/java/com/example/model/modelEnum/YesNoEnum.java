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

    public static YesNoEnum fromValue(String value) {
        for (YesNoEnum yesNo : values()) {
            if (yesNo.getValue().equalsIgnoreCase(value)) {
                return yesNo;
            }
        }
        throw new IllegalArgumentException("No enum constant found for value: " + value);
    }
}


