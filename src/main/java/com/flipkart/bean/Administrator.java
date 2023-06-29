/**
 * Represents an administrator.
 */
package com.flipkart.bean;
import java.util.*;

/**
 * Administrator class represents the details of an administrator.
 */
public class Administrator {
	private String adminId; // Administrator ID of the administrator.
	private String name; // Name of the administrator.
	private String mobile; // Mobile number of the administrator.
	 
	/**
	 * Default constructor for the Administrator class.
	 */
	public Administrator() {
		
	}
	
	/**
	 * Returns the admin ID of the administrator.
	 *
	 * @return the admin ID
	 */
	public String getAdminId() {
		return adminId;
	}
	
	/**
	 * Sets the admin ID for the administrator.
	 *
	 * @param adminId the admin ID to set
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	/**
	 * Returns the name of the administrator.
	 *
	 * @return the name of the administrator
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the administrator.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the mobile number of the administrator.
	 *
	 * @return the mobile number
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * Sets the mobile number for the administrator.
	 *
	 * @param mobile the mobile number to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}