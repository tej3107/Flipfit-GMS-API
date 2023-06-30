package com.flipkart.bean;

import java.time.LocalDate;

public class CustomerRegistration {
    private String regId;
//    private String custId;
    private LocalDate date;
    private String userName;

    public CustomerRegistration() {
    }

    public CustomerRegistration(String regId, String userName) {
        this.regId = regId;
        this.userName = userName;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

//    public String getCustId() {
//        return custId;
//    }
//
//    public void setCustId(String custId) {
//        this.custId = custId;
//    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
