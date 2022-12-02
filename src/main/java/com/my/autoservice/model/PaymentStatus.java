package com.my.autoservice.model;

public enum PaymentStatus {
    PAYED("Payed"),
    NOT_PAYED("Not payed");
    private String value;

    PaymentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
