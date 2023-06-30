package com.flipkart.exception;

public class userNameAlreadyExist extends Exception{

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for userNotExist.
     */
    public userNameAlreadyExist() {

    }

    /**
     * Returns the error message when the exception is thrown.
     *
     * @return The error message indicating that the username or password did not match.
     */
    @Override
    public String getMessage() {
        return "Username already exist.";
    }

}