/**
 * Class representing the Gym Owner's menu in the Gym Management System.
 */
package com.flipkart.client;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;
import com.flipkart.bean.User;
import com.flipkart.service.GymOwnerService;

/**
 * Class representing the Gym Owner's menu in the Gym Management System.
 */
public class GymnOwnerGMSMenu {
	GymOwnerService ownerService = new GymOwnerService();
	
	/**
	 * Registers a new Gym Owner.
	 *
	 * @param in The Scanner object for user input.
	 */
	public void registerGymOwner(Scanner in) {
		System.out.println("Please Enter your Details:-");
		System.out.print("$ Enter Username: ");
		String username = in.next();
		System.out.print("$ Enter your Name: ");
		String name = in.next();
		System.out.print("$ Enter your mobile: ");
		String mobile = in.next();
		System.out.print("$ Enter your email: ");
		String email = in.next();
		System.out.print("$ Enter your address: ");
		String address = in.next();
		System.out.print("$ Enter your aadhaarNumber: ");
		String aadhaarNumber = in.next();
		System.out.print("$ Enter your panNumber: ");
		String panNumber = in.next();
		System.out.print("$ Enter your DOB: ");
		String DOB = in.next();
		System.out.print("$ Enter your gstNumber: ");
		String gstNumber = in.next();
		System.out.print("Enter your Password: ");
		String password = in.next();
		User user = new User(username, password, 3);
		
		GymOwner owner = new GymOwner();
		owner.setName(name);
		owner.setMobile(mobile);
		owner.setEmail(email);
		owner.setAddress(address);
		owner.setAadhaarNumber(aadhaarNumber);
		owner.setPanNumber(panNumber);
		owner.setGstNumber(gstNumber);
		ownerService.registerGymOwner(user, owner);
		
		gymOwnerActionPage(in, user);
	}
	
	/**
	 * Fetches the details of a Gym Owner.
	 *
	 * @param ownerId The ID of the Gym Owner.
	 */
	public void fetchOwnerDetails(String ownerId) {
		ownerService.fetchOwnerDetails(ownerId);
	}
	
	/**
	 * Fetches the Gyms owned by a Gym Owner.
	 *
	 * @param ownerId The ID of the Gym Owner.
	 */
	public void fetchMyGyms(String ownerId) {
		ownerService.fetchMyGyms(ownerId);
	}
	
	/**
	 * Registers a new Gym for a Gym Owner.
	 *
	 * @param in       The Scanner object for user input.
	 * @param ownerId  The ID of the Gym Owner.
	 */
	public void registerGym(Scanner in, String ownerId) {
		Gymnasium gym = new Gymnasium();
		
		System.out.print("$  Gym Name: ");
		String name = in.next();
		
		System.out.print("$  Address: ");
		in.nextLine();
		String address = in.nextLine();
		
		System.out.print("$  Area: ");
		double area = in.nextInt();
		
		System.out.print("$  Number of Machines: ");
		int numItem = in.nextInt();
		
		System.out.print("$ Enter capacity of slot: ");
		int capacity = in.nextInt();
		
		System.out.println("$ Enter time slot in sequence giving space (Railways time zone, No character allowed): ");
		
		String timeline = in.nextLine();
		timeline = in.nextLine();
		
		ArrayList<Integer> slotAvailable = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(timeline);  
	    while (st.hasMoreTokens()) { 
	        slotAvailable.add(Integer.parseInt(st.nextToken()));  
	    }  
	     
		gym.setOwnerId(ownerId);
		gym.setName(name);
		gym.setAddress(address);
		gym.setTotalArea(area);
		gym.setNumItem(numItem);
		gym.setApproved(0);
		ownerService.addGymDetails(gym, slotAvailable, capacity);
	}

	/**
	 * Displays the Gym Owner's menu and handles the user's actions.
	 *
	 * @param in   The Scanner object for user input.
	 * @param user The User object representing the Gym Owner.
	 */
	public void gymOwnerActionPage(Scanner in, User user) {
		int choice = 0;
		
		if (!ownerService.isOwnerApproved(user.getUserName())) {
			System.out.println("Not Approved!!");
			choice = 4;
		}
		
		while (choice != 4) {
			System.out.println("\nMenu:-");
			System.out.println("\t1.Get Details \n\t2.Add Gym \n\t3.View My Gyms \n\t4.Return");
			
			System.out.print("Enter your choice: ");
			choice = in.nextInt();
			System.out.println("\n");
			switch (choice) {
				case 1:
					fetchOwnerDetails(user.getUserName());
					break;
				case 2:
					registerGym(in, user.getUserName());
					break;
				case 3:
					fetchMyGyms(user.getUserName());
					break;
				case 4:
					break;
				default:
					System.out.println("Wrong Choice");
			}
		}
	}
}