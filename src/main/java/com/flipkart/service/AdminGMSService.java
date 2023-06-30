/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;
import com.flipkart.dao.AdminGMSDao;

import java.util.ArrayList;

/**
 * 
 */
public class AdminGMSService implements AdminGMSInterface{
	
	AdminGMSDao adminDBService = new AdminGMSDao();
	
	public AdminGMSService() {
//		seeAllGyms();
	}
	
	/**
	 * Displays all gym owners.
	 */
	public ArrayList<GymOwner> seeAllGymOwner() throws Exception{
//
		return adminDBService.fetchGymOwnerDetails();
	}
	
	/**
	 * Displays all gyms.
	 *
	 * @return
	 */
	public ArrayList<Gymnasium> seeAllGyms() throws Exception{
		return adminDBService.fetchGymnasiumDetails();
	}
	
	/**
	 * Checks if there are pending gym owner requests.
	 *
	 * @return true if there are pending gym owner requests, false otherwise
	 */
	public ArrayList<GymOwner> seePendingGymOwnerRequest() throws Exception{
		return adminDBService.fetchPendingGymOwnerRequests();
		
	}
	
	/**
	 * Checks if there are pending gym requests.
	 *
	 * @return true if there are pending gym requests, false otherwise
	 */
	public ArrayList<Gymnasium> seePendingGymRequest() throws Exception{
		return adminDBService.fetchPendingGymnasiumRequest();
	}
	
	/**
	 * Approves a single gym owner request with the specified request ID.
	 *
	 * @param userName the ID of the gym owner request to approve
	 * @return true if the request is approved successfully, false otherwise
	 */
	public boolean approveSingleOwnerRequest(String userName) throws Exception{
		adminDBService.updateSingleGymOwnerRequests(userName);
		return true;
	}
	
	/**
	 * Approves all pending gym owner requests.
	 *
	 * @return true if all requests are approved successfully, false otherwise
	 */
	public boolean approveAllOwnerRequest() throws Exception{
		adminDBService.updateAllPendingGymOwnerRequests();
		return true;
	}
	
	/**
	 * Approves a single gym request with the specified gym ID.
	 *
	 * @param gymId the ID of the gym request to approve
	 * @return true if the request is approved successfully, false otherwise
	 */
	public boolean approveSingleGymRequest(String gymId) throws Exception{
		adminDBService.updateSingleGymnasiumRequests(gymId);
		return true;
	}
	
	/**
	 * Approves all pending gym requests.
	 *
	 * @return true if all requests are approved successfully, false otherwise
	 */
	public boolean approveAllGymRequest() throws Exception{
		adminDBService.updateAllPendingGymnasiumRequests();
		return true;
	}
	
	/**
	 * Blocks a gym owner with the specified owner ID.
	 *
	 * @param userName the ID of the gym owner to block
	 */
	public boolean blockGymOwner(String userName) throws Exception{
		adminDBService.unApproveGymOwner(userName);
		return true;
	}
}