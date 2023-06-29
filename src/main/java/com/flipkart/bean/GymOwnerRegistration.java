package com.flipkart.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class GymOwnerRegistration {
    private String regId;
    private LocalDate regDate;
    private LocalTime regTime;
    private String gymOwnerId;

    public GymOwnerRegistration() {
    }

    public GymOwnerRegistration(String regId, String gymOwnerId) {
        this.regId = regId;
        this.gymOwnerId = gymOwnerId;
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

    public String getGymOwnerId() {
        return gymOwnerId;
    }

    public void setGymOwnerId(String gymOwnerId) {
        this.gymOwnerId = gymOwnerId;
    }
}
