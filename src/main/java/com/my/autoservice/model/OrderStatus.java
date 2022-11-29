package com.my.autoservice.model;

public enum OrderStatus {
    ACCEPTED("Accepted"),
    IN_PROGRESS("In progress"),
    SUCCESSFUL("Successful"),
    NOT_SUCCESSFUL("Not successful"),
    PAID("Paid");
    private String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
