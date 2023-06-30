package com.flipkart.bean;

public class BookedSlot {
    private int bookingId;
    private String slotId;
    private String userName;
    private String slotDate;
    private int slotTime;
    private String address;
    private String gymName;

    public BookedSlot() {
    }

    public BookedSlot(int bookingId, String slotId, String userName, String slotDate, int slotTime,String address, String gymName) {
        this.bookingId = bookingId;
        this.slotId = slotId;
        this.userName = userName;
        this.slotDate = slotDate;
        this.slotTime = slotTime;
        this.address = address;
        this.gymName = gymName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(String slotDate) {
        this.slotDate = slotDate;
    }

    public int getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(int slotTime) {
        this.slotTime = slotTime;
    }
}
