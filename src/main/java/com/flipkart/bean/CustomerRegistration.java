package com.flipkart.bean;

import java.time.LocalDate;

public class CustomerRegistration {
    private String regId;
    private String custId;
    private LocalDate date;
    private String username;

    public CustomerRegistration() {
    }

    public CustomerRegistration(String regId, String custId, String username) {
        this.regId = regId;
        this.custId = custId;
        this.username = username;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
