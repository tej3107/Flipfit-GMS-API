/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;

import java.util.ArrayList;

/**
 * 
 */
public interface AdminGMSInterface {
	
	/**
	 * Displays all gym owners.
	 */
	public ArrayList<GymOwner> seeAllGymOwner() throws Exception;
	
	/**
	 * Displays all gyms.
	 *
	 * @return
	 */
	public ArrayList<Gymnasium> seeAllGyms() throws Exception;
	
	/**
	 * Checks if there are pending gym owner requests.
	 *
	 * @return true if there are pending gym owner requests, false otherwise
	 */
	public ArrayList<GymOwner> seePendingGymOwnerRequest() throws Exception;
	
	/**
	 * Checks if there are pending gym requests.
	 *
	 * @return true if there are pending gym requests, false otherwise
	 */
	public ArrayList<Gymnasium> seePendingGymRequest() throws Exception;
	
	/**
	 * Approves a single gym owner request with the specified request ID.
	 *
	 * @param userName the ID of the gym owner request to approve
	 * @return true if the request is approved successfully, false otherwise
	 */
	public boolean approveSingleOwnerRequest(String userName) throws Exception;
	
	/**
	 * Approves all pending gym owner requests.
	 *
	 * @return true if all requests are approved successfully, false otherwise
	 */
	public boolean approveAllOwnerRequest() throws Exception;
	
	/**
	 * Approves a single gym request with the specified gym ID.
	 *
	 * @param gymId the ID of the gym request to approve
	 * @return true if the request is approved successfully, false otherwise
	 */
	public boolean approveSingleGymRequest(String gymId) throws Exception;
	
	/**
	 * Approves all pending gym requests.
	 *
	 * @return true if all requests are approved successfully, false otherwise
	 */
	public boolean approveAllGymRequest() throws Exception;
	
	/**
	 * Blocks a gym owner with the specified owner ID.
	 *
	 * @param userName the ID of the gym owner to block
	 */
	public boolean blockGymOwner(String userName) throws Exception;
}