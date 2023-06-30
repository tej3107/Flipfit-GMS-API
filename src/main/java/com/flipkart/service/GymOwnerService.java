/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;
import com.flipkart.dao.GymOwnerGMSDao;

import java.util.ArrayList;

/**
 * 
 */
public class GymOwnerService {
	GymOwnerGMSDao ownerDBService = new GymOwnerGMSDao();
	
	/**
	 * Registers a gym owner with the provided user and gym owner details.
	 *
	 * @param owner the gym owner details for registration
	 */
	public void registerGymOwner(GymOwner owner) {
		ownerDBService.registerGymOwner(owner);
	}
	
	/**
	 * Fetches the details of the gym owner with the specified owner ID.
	 *
	 * @param userName the owner ID
	 */
	public void fetchOwnerDetails(String userName) {
		ownerDBService.fetchOwnerDetails(userName);
	}
	
	/**
	 * Fetches the list of gyms owned by the specified owner.
	 *
	 * @param userName the owner ID
	 */
	public void fetchMyGyms(String userName) {
		ownerDBService.fetchMyGyms(userName);
	}
	
	/**
	 * Adds gym details for the specified gym, available slots, and capacity.
	 *
	 * @param gym the gym details
	 * @param slotAvailable the list of available slots
	 * @param capacity the capacity of the gym
	 */
	public void addGymDetails(Gymnasium gym, ArrayList<Integer> slotAvailable, int capacity) {
		ownerDBService.addGymDetails(gym, slotAvailable, capacity);
	}
	
	/**
	 * Checks if the gym owner with the specified owner ID is approved.
	 *
	 * @param userName the owner ID
	 * @return true if the gym owner is approved, false otherwise
	 */
	public boolean isOwnerApproved(String userName) {
		return ownerDBService.isOwnerApproved(userName);
	}
}