package com.flipkart.exception;

/**
 * Exception to check if a user does not exist or if the provided username and password do not match.
 */
public class userNotExist extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor for userNotExist.
	 */
	public userNotExist() {
		
	}
	
	/**
	 * Returns the error message when the exception is thrown.
	 * 
	 * @return The error message indicating that the username or password did not match.
	 */
	@Override
	public String getMessage() {
		return "Username or password did not match.";
	}

}