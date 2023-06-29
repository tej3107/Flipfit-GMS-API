/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class User {
	private String userName; // User's username.
	private String password; // User's password.
	private int roleId; // ID of the user's role.
	
	/**
	 * Constructor for the User class.
	 *
	 * @param userName the username of the user
	 * @param password the password of the user
	 * @param roleId   the ID of the user's role
	 */
	public User(String userName, String password, int roleId) {
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
	}

	public User(){}
	
	/**
	 * Returns the username of the user.
	 *
	 * @return the username
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Sets the username for the user.
	 *
	 * @param userName the username to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Returns the password of the user.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password for the user.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Returns the ID of the user's role.
	 *
	 * @return the role ID
	 */
	public int getRoleId() {
		return roleId;
	}
	
	/**
	 * Sets the ID for the user's role.
	 *
	 * @param roleId the role ID to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}