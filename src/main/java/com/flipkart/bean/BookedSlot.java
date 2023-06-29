package com.flipkart.bean;

public class BookedSlot {
    private int bookingId;
    private String slotId;
    private String custId;
    private String slotDate;
    private int slotTime;

    public BookedSlot() {
    }

    public BookedSlot(int bookingId, String slotId, String custId, String slotDate, int slotTime) {
        this.bookingId = bookingId;
        this.slotId = slotId;
        this.custId = custId;
        this.slotDate = slotDate;
        this.slotTime = slotTime;
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

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
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
