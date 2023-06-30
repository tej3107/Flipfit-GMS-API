/**
 * Menu class for the customer interface of the Gym Management System.
 */
package com.flipkart.client;

import com.flipkart.bean.Customer;
import com.flipkart.service.CustomerService;

import java.util.Scanner;

/**
 * Menu class that provides the customer interface for managing the Gym Management System.
 */
public class CustomerGMSMenu {
	
	CustomerService customerService = new CustomerService();
	
	/**
	 * Registers a new customer by collecting personal details.
	 *
	 * @param in The Scanner object for user input.
	 */
	public void registerCustomer(Scanner in) {
		System.out.println("Add Personal Details:-");
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
		System.out.print("$ Enter your Password: ");
		String password = in.next();
		
//		User user = new User(username, password, 3);

		Customer customer = new Customer(username,password,3,name,mobile,email,address);
		
		customerService.registerCustomer(customer);
		customerActionPage(in,customer);
	}
	
	/**
	 * Displays the gym catalog and allows the customer to book a slot.
	 *
	 * @param in       The Scanner object for user input.
	 * @param customer
	 */
	public void viewCatalog(Scanner in, Customer customer) {
		System.out.println("Book a Slot*\nMenu:-");
		customerService.fetchGymList();
		
		System.out.print("$ Enter your Gym ID: ");
		String gymId = in.next();
		
		customerService.fetchAvailableSlots(gymId);
		System.out.print("$ Enter your Slot ID: ");
		String slotId = in.next();
		
		try {
			int response = customerService.bookSlots(slotId, customer.getUserName());


		switch (response) {
			case 0:
				System.out.println("Changed your slot time with new gym location");
				break;
			case 1:
				System.out.println("No slots left");
				break;
			case 2:
				System.out.println("Slot is booked");
				break;
			default:
				System.out.println("Incorrect choice!!! Please try again!!!");
		}
		}
		catch(Exception e){

		}
	}
	
	/**
	 * Displays the customer action page and handles user input for various actions.
	 *
	 * @param in       The Scanner object for user input.
	 * @param customer
	 */
	public void customerActionPage(Scanner in, Customer customer) {
		int choice = 0;
		
		while (choice != 3) {
			System.out.println("\nMenu:-");
			System.out.println("\t1.View Gyms and Book Gym\n" 
							 + "\t2.View Booked Slots\n" 
							 + "\t3.Exit");
			System.out.print("$ Enter your choice: ");
			choice = in.nextInt();
			
			switch (choice) {
				case 1:
					viewCatalog(in,customer);
					break;
				case 2:
					customerService.bookedSlots(customer.getUserName());
					break;
				case 3:
					break;
				default:
					System.out.println("Incorrect choice!!! Please try again!!!");
			}
		}
	}
}