/**
 * 
 */
package com.flipkart.bean;
import java.time.LocalDate;

/**
 * 
 */
public class GymOwner extends User{
//	private String ownerId; // ID of the gym owner.
	private String name; // Name of the gym owner.
//	private String username;
	private String mobile; // Mobile number of the gym owner.
	private String email; // Email address of the gym owner.
	private String address; // Address of the gym owner.
	private LocalDate dob; // Date of birth of the gym owner.
	
	private String aadhaarNumber; // Aadhaar number of the gym owner.
	private String panNumber; // PAN number of the gym owner.
	private String gstNumber; // GST number of the gym owner.
//	private String password;
	private int approved; // Approval status of the gym owner.

	public GymOwner(String username, String password, int roleId,  String name, String mobile, String email, String address, String aadhaarNumber, String panNumber, String gstNumber, int approved) {
		super(username, password, roleId);
//		this.ownerId = ownerId;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.aadhaarNumber = aadhaarNumber;
		this.panNumber = panNumber;
		this.gstNumber = gstNumber;
		this.approved = approved;
	}

	/**
	 * Default constructor for the GymOwner class.
	 */



	public GymOwner() {
		
	}
	
	/**
	 * Checks if the gym owner is approved.
	 *
	 * @return true if approved, false otherwise
	 */
	public int isApproved() {
		return approved;
	}

	/**
	 * Sets the approval status for the gym owner.
	 *
	 * @param approved the approval status to set
	 */
	public void setApproved(int approved) {
		this.approved = approved;
	}

//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

	public int getApproved() {
		return approved;
	}

	/**
	 * Returns the ID of the gym owner.
	 *
	 * @return the owner ID
	 */
//	public String getOwnerId() {
//		return ownerId;
//	}
//
//	/**
//	 * Sets the ID for the gym owner.
//	 *
//	 * @param ownerId the owner ID to set
//	 */
//	public void setOwnerId(String ownerId) {
//		this.ownerId = ownerId;
//	}
	
	/**
	 * Returns the name of the gym owner.
	 *
	 * @return the name of the gym owner
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the gym owner.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the mobile number of the gym owner.
	 *
	 * @return the mobile number
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * Sets the mobile number for the gym owner.
	 *
	 * @param mobile the mobile number to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * Returns the email address of the gym owner.
	 *
	 * @return the email address
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email address for the gym owner.
	 *
	 * @param email the email address to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Returns the address of the gym owner.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the address for the gym owner.
	 *
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Returns the date of birth of the gym owner.
	 *
	 * @return the date of birth
	 */
	public LocalDate getDob() {
		return dob;
	}
	
	/**
	 * Sets the date of birth for the gym owner.
	 *
	 * @param dob the date of birth to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	/**
	 * Returns the Aadhaar number of the gym owner.


	 *
	 * @return the Aadhaar number
	 */
	public String getAadhaarNumber() {
		return aadhaarNumber;
	}
	
	/**
	 * Sets the Aadhaar number for the gym owner.
	 *
	 * @param aadhaarNumber the Aadhaar number to set
	 */
	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	
	/**
	 * Returns the PAN number of the gym owner.
	 *
	 * @return the PAN number
	 */
	public String getPanNumber() {
		return panNumber;
	}
	
	/**
	 * Sets the PAN number for the gym owner.
	 *
	 * @param panNumber the PAN number to set
	 */
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	
	/**
	 * Returns the GST number of the gym owner.
	 *
	 * @return the GST number
	 */
	public String getGstNumber() {
		return gstNumber;
	}
	
	/**
	 * Sets the GST number for the gym owner.
	 *
	 * @param gstNumber the GST number to set
	 */
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
}