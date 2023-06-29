/**
 * 
 */
package com.flipkart.service;
import com.flipkart.bean.*;
import java.util.*;
import com.flipkart.dao.GymOwnerGMSDao;

/**
 * 
 */
public class GymOwnerService {
	GymOwnerGMSDao ownerDBService = new GymOwnerGMSDao();
	
	/**
	 * Registers a gym owner with the provided user and gym owner details.
	 *
	 * @param user the user details for registration
	 * @param owner the gym owner details for registration
	 */
	public void registerGymOwner(User user, GymOwner owner) {
		ownerDBService.registerGymOwner(user, owner);
	}
	
	/**
	 * Fetches the details of the gym owner with the specified owner ID.
	 *
	 * @param ownerId the owner ID
	 */
	public void fetchOwnerDetails(String ownerId) {
		ownerDBService.fetchOwnerDetails(ownerId);
	}
	
	/**
	 * Fetches the list of gyms owned by the specified owner.
	 *
	 * @param ownerId the owner ID
	 */
	public void fetchMyGyms(String ownerId) {
		ownerDBService.fetchMyGyms(ownerId);
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
	 * @param ownerId the owner ID
	 * @return true if the gym owner is approved, false otherwise
	 */
	public boolean isOwnerApproved(String ownerId) {
		return ownerDBService.isOwnerApproved(ownerId);
	}
}