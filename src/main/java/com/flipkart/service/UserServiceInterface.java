/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.User;

/**
 * 
 */
public interface UserServiceInterface {
	/**
	 * Registers a customer with the provided registration data.
	 *
	 * @param customerData the registration data for the customer
	 * @return true if the registration is successful, false otherwise
	 */
//	public boolean registerCustomer(Registration customerData);
	
	/**
	 * Registers a gym owner with the provided registration data.
	 *
	 * @param ownerData the registration data for the gym owner
	 * @return true if the registration is successful, false otherwise
	 */
//	public boolean registerGymOwner(Registration ownerData);
	
	/**
	 * Authenticates a user with the provided user data.
	 *
	 * @param userData the user data for authentication
	 * @return the authentication result as an integer code:
	 *         - 0 for successful authentication
	 *         - 1 for invalid username or password
	 *         - 2 for account locked
	 *         - 3 for account expired
	 */
	public int authenticateUser(User userData);
	
	/**
	 * Logs out a user with the provided user data.
	 *
	 * @param userData the user data for logout
	 * @return true if the logout is successful, false otherwise
	 */
	public boolean logout(User userData);
}