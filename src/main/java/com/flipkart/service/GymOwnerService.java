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
		try{ownerDBService.registerGymOwner(owner);}
		catch (Exception e){}
	}
	
	/**
	 * Fetches the details of the gym owner with the specified owner ID.
	 *
	 * @param userName the owner ID
	 */
	public void fetchOwnerDetails(String userName) {
		try{ownerDBService.fetchOwnerDetails(userName);}
		catch (Exception e){}
	}
	
	/**
	 * Fetches the list of gyms owned by the specified owner.
	 *
	 * @param userName the owner ID
	 */
	public void fetchMyGyms(String userName) {
		try{ownerDBService.fetchMyGyms(userName);}
		catch (Exception e){}
	}
	
	/**
	 * Adds gym details for the specified gym, available slots, and capacity.
	 *
	 * @param gym the gym details
	 * @param slotAvailable the list of available slots
	 * @param capacity the capacity of the gym
	 */
	public void addGymDetails(Gymnasium gym, ArrayList<Integer> slotAvailable, int capacity) {
		try{ownerDBService.addGymDetails(gym, slotAvailable, capacity);}
		catch (Exception e){}
	}
	
	/**
	 * Checks if the gym owner with the specified owner ID is approved.
	 *
	 * @param userName the owner ID
	 * @return true if the gym owner is approved, false otherwise
	 */
	public boolean isOwnerApproved(String userName) {
		try {return ownerDBService.isOwnerApproved(userName);}
		catch (Exception e){return false;}
	}
}