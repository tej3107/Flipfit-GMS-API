/**
 * Main application class for the Gym Management System.
 */
package com.flipkart.client;

import com.flipkart.bean.User;
import com.flipkart.exception.incorrectDataType;
import com.flipkart.exception.userNotExist;
import com.flipkart.service.UserService;
import com.flipkart.service.UserServiceInterface;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class that serves as the entry point for the Gym Management System application.
 */
public class GMSApplicationClient {

	/**
	 * The main method that starts the Gym Management System application.
	 *
	 * @param args The command line arguments.
	 * @throws incorrectDataType Thrown if an incorrect data type is entered.
	 */
	public static void mains(String args[]) throws incorrectDataType {
	    System.out.println("\nWelcome to FlipFit Gymnasium Application");
	    Scanner in = new Scanner(System.in);
	    int choice = 1;

	    while (choice != 4) {

	        System.out.println("\nMenu:-");
	        System.out.println("\t1. Login\n" 
	        				 + "\t2. GymOwner Registration\n" 
	        				 + "\t3. Customer Registration\n" 
	        				 + "\t4. Exit\n");

	        System.out.print("$ Enter your choice: ");

	        try {
	            choice = in.nextInt();
//	            in.nextLine(); // Consume the newline character after reading the integer

	            switch (choice) {
	                case 1:
	                    openLoginMenu(in);
	                    break;

	                case 2:
	                    GymnOwnerGMSMenu owner = new GymnOwnerGMSMenu();
	                    owner.registerGymOwner(in);
	                    break;

	                case 3:
	                    CustomerGMSMenu customer = new CustomerGMSMenu();
	                    customer.registerCustomer(in);
	                    break;

	                case 4:
	                    // System.exit(0);
	                    break;

	                default:
	                    System.out.println("Invalid Credentials");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Incorrect data type. Please enter a number");
//	            in.nextLine(); // Consume the invalid input
	        }
	        catch (userNotExist e) {
	            System.out.println(e.getMessage());
	        }
	        
	    }
	    in.close();
	}


	/**
	 * Opens the login menu and handles the user login process.
	 *
	 * @param in The Scanner object for user input.
	 * @throws userNotExist       Thrown if the user does not exist.
	 */
	public static void openLoginMenu(Scanner in) throws userNotExist {
		System.out.println("\nEnter your login credentials:-");
		
		System.out.print("$ UserId: ");
		String userName = in.next();
		
		System.out.print("$ Password: ");
		String password = in.next();
		
		int role = 0; // Zero is a dummy value here
		User user = new User(userName, password, role);
		UserServiceInterface authentication = new UserService();
		
		role = authentication.authenticateUser(user);
		
		if (role != 4) {
			System.out.println("\nlogged in Successfully!!!\n\n");
		} else {
			throw new userNotExist();
		}
		
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.getDayOfMonth() + "/" + localDate.getMonth() + "/" + localDate.getYear());
		System.out.println("Hello!! " + userName + "\nWelcome to GMS");
		
		switch (role) {
			case 1: 
				AdminGMSMenu admin = new AdminGMSMenu();
				admin.adminActionPage(in);
				break;
				
			case 2: 
				GymnOwnerGMSMenu owner = new GymnOwnerGMSMenu();
				owner.gymOwnerActionPage(in, user);
				break;
				
			case 3: 
				CustomerGMSMenu customer = new CustomerGMSMenu();
				customer.customerActionPage(in, user);
				break;
				
			default:
				System.out.println("\nIncorrect choice!!! Please try again!!!");
				break;
		}
	}
}