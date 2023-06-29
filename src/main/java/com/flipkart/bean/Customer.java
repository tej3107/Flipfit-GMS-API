/**
 * 
 */
package com.flipkart.bean;
import java.time.LocalDate;

/**
 * 
 */
public class Customer {
	private String customerId; // Customer ID of the customer.
	private String username;
	private String name; // Name of the customer.
	private String mobile; // Mobile number of the customer.
	private String email; // Email address of the customer.
	private String address; // Address of the customer.
	private LocalDate dob; // Date of birth of the customer.
	private String password;
	
	/**
	 * Default constructor for the Customer class.
	 */
	public Customer() {
		
	}
	
	/**
	 * Returns the customer ID of the customer.
	 *
	 * @return the customer ID
	 */
	public String getCustomerId() {
		return customerId;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets the customer ID for the customer.
	 *
	 * @param customerId the customer ID to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * Returns the name of the customer.
	 *
	 * @return the name of the customer
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the customer.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the mobile number of the customer.
	 *
	 * @return the mobile number
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * Sets the mobile number for the customer.
	 *
	 * @param mobile the mobile number to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * Returns the email address of the customer.
	 *
	 * @return the email address
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email address for the customer.
	 *
	 * @param email the email address to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Returns the address of the customer.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the address for the customer.
	 *
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Returns the date of birth of the customer.
	 *
	 * @return the date of birth
	 */
	public LocalDate getDob() {
		return dob;
	}
	
	/**
	 * Sets the date of birth for the customer.
	 *
	 * @param dob the date of birth to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
}