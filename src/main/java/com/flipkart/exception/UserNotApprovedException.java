/**
 * Exception to check if a user is approved by the administration.
 */
package com.flipkart.exception;

import com.flipkart.bean.User;

/**
 * Exception to check if a user is approved by the administration.
 */
public class UserNotApprovedException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private User userId;
	
	/**
	 * Constructor for UserNotApprovedException.
	 * 
	 * @param user The User object representing the user.
	 */
	public UserNotApprovedException(User user) {
		this.userId = user;
		System.out.println("User not found from exception\n");
	}

	/**
	 * Getter for the user ID.
	 * 
	 * @return The User object representing the user.
	 */
	public User getUserId() {
		return userId;
	}

}