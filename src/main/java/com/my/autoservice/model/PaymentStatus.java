package com.my.autoservice.model;

public enum PaymentStatus {
    PAYED("Payed"),
    NOT_PAYED("Not payed");
    String value;

    PaymentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
