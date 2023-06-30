package com.flipkart.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class GymOwnerRegistration {
    private String regId;
    private LocalDate regDate;
    private LocalTime regTime;
    private String userName;

    public GymOwnerRegistration() {
    }

    public GymOwnerRegistration(String regId, String userName) {
        this.regId = regId;
        this.userName = userName;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public LocalTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalTime regTime) {
        this.regTime = regTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
