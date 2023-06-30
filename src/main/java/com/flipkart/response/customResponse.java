package com.flipkart.response;

import java.util.ArrayList;
import java.util.Objects;

public class customResponse<T> {
    private int statusCode;
    private String message;
    private ArrayList<T> data;

    public customResponse(int statusCode, String message, ArrayList<T> data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }
    // Getters and setters here...
}
