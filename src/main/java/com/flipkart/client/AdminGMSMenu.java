/**
 * Menu class for the admin interface of the Gym Management System.
 */
package com.flipkart.client;

import com.flipkart.service.AdminGMSInterface;
import com.flipkart.service.AdminGMSService;

import java.util.Scanner;

/**
 * Menu class that provides the admin interface for managing the Gym Management System.
 */
public class AdminGMSMenu {

	/**
	 * Approves a gym owner request by entering the owner ID.
	 *
	 * @param in           The Scanner object for user input.
	 * @param adminService The AdminGMSInterface implementation for performing admin actions.
	 */
	public int approveGymOwner(Scanner in, AdminGMSInterface adminService) {
		System.out.print("Enter Owner ID: ");
		String choice = in.next();

		if (adminService.approveSingleOwnerRequest(choice)) {
			System.out.print("Owner " + choice + " request approved successfully");
			return 1;
		} else {
			System.out.print("Error...please try again later");
			return 0;
		}
	}

	/**
	 * Approves a gym request by entering the gym ID.
	 *
	 * @param in           The Scanner object for user input.
	 * @param adminService The AdminGMSInterface implementation for performing admin actions.
	 */
	public void approveGym(Scanner in, AdminGMSInterface adminService) {
		// Add a slot timing menu here
		System.out.print("Enter Gym ID: ");
		String choice = in.next();

		if (adminService.approveSingleGymRequest(choice)) {
			System.out.print("Gym " + choice + " request approved successfully");
		} else {
			System.out.print("Error...please try again later");
		}
	}

	/**
	 * Displays the admin action page and handles user input for various actions.
	 *
	 * @param in The Scanner object for user input.
	 */
	public void adminActionPage(Scanner in) {
		System.out.println("\nWelcome to FlipFit Gymnasium Application");
		AdminGMSInterface adminService = new AdminGMSService();

		int choice = 0;
		while (choice != 10) {
			System.out.println("\nMenu:-");
			System.out.println("\t1.View All Gym Owners\n" 
							+ "\t2.View All Gymnasiums\n" 
							+ "\t3.View Gym Owner Pending Requests\n"
							+ "\t4.View Gymnasiums Pending Requests\n" 
							+ "\t5.Approve Gym Owner Request\n" 
							+ "\t6.Approve Gymnasium Request\n"
							+ "\t7.Approve All Gym Owner Requests\n" 
							+ "\t8.Approve All Gymnasium Requests\n"
							+ "\t9.Block a Gym Owner\n" 
							+ "\t10.RETURN\n");

			System.out.print("$ Enter your choice: ");
			choice = in.nextInt();

			switch (choice) {
				// Case statements
				case 1:
					adminService.seeAllGymOwner();
					break;
				case 2:
					adminService.seeAllGyms();
					break;
				case 3:
					adminService.seePendingGymOwnerRequest();
					break;
				case 4:
					adminService.seePendingGymRequest();
					break;
				case 5:
					if (adminService.seePendingGymOwnerRequest().size()!=0) {
						approveGymOwner(in, adminService);
					}
					else System.out.println("No Pending Request");
					break;
				case 6:
					if (adminService.seePendingGymRequest().size()!=0) {
						approveGym(in, adminService);
					}
					System.out.println("No Pending Request");
					break;
				case 7:
					adminService.approveAllOwnerRequest();
					System.out.println("\nAll gym owner pending requests approved");
					break;
				case 8:
					adminService.approveAllGymRequest();
					System.out.println("\nAll gym pending requests approved");
					break;
				case 9:
					adminService.seeAllGymOwner();
					System.out.println("$ Enter Gym Owner Id to Block:   ");
					String gymOwnerId = in.next();
					adminService.blockGymOwner(gymOwnerId);
					System.out.println("Gym Owner Blocked Successfully");
					break;
				case 10:
					System.out.println("Exit!!");
					break;
				// Default case statement
				default:
					System.out.println("Incorrect choice!!! Please try again!!!");
			}
		}
	}
}