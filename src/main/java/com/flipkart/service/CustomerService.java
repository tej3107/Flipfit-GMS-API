/**
 * 
 */
package com.flipkart.service;
import com.flipkart.bean.*;
import java.time.LocalDate;
import com.flipkart.dao.*;

/**
 * 
 */
public class CustomerService {
	CustomerGMSDao customerDao = new CustomerGMSDao();
	
	/**
	 * Registers a customer with the provided user and customer details.
	 *
	 * @param user the user details for registration
	 * @param customer the customer details for registration
	 */
	public void registerCustomer(User user, Customer customer) {
		customerDao.registerCustomer(user, customer);
	}
	
	/**
	 * Fetches the details of a customer with the specified customer ID.
	 *
	 * @param customerId the customer ID
	 * @return the customer details
	 */
	public Customer fetchCustomerDetails(String customerId) {
		return new Customer();
	}
	
	/**
	 * Fetches the list of gyms.
	 */
	public void fetchGymList() {
		customerDao.fetchGymList();
		return;
	}
	
	/**
	 * Fetches the available slots for the specified gym ID.
	 *
	 * @param gymId the gym ID
	 */
	public void fetchAvilableSlots(String gymId) {
		customerDao.fetchSlotList(gymId);
	}
	
	/**
	 * Books a slot for the specified slot ID and customer ID.
	 *
	 * @param slotId the slot ID to book
	 * @param customerId the customer ID booking the slot
	 * @return 0 if the slot is already booked, 1 if the slot is full, 2 if the slot is booked successfully
	 */
	public int bookSlots(String slotId, String customerId) {
		if (isFull(slotId)) {
			return 1;
		} else if (alreadyBooked(slotId, customerId)) {
			return 0;
		} else {
			customerDao.bookSlots(slotId, customerId);
			return 2;
		}
	}
	
	/**
	 * Checks if the specified slot ID is already booked by the customer.
	 *
	 * @param slotId the slot ID to check
	 * @param customerId the customer ID
	 * @return true if the slot is already booked by the customer, false otherwise
	 */
	public boolean alreadyBooked(String slotId, String customerId) {
		return customerDao.changeGymSlot(slotId, customerId);
	}
	
	/**
	 * Checks if the specified slot ID is full.
	 *
	 * @param slotId the slot ID to check
	 * @return true if the slot is full, false otherwise
	 */
	public boolean isFull(String slotId) {
		return customerDao.isFull(slotId);
	}
	
	/**
	 * Books a slot for the specified slot ID, customer ID, and date.
	 *
	 * @param slotId the slot ID to book
	 * @param customerId the customer ID booking the slot
	 * @param date the date of the booking
	 * @return true if the slot is booked successfully, false otherwise
	 */
	public boolean bookSlot(String slotId, String customerId, int date) {
		return true;
	}
	
	/**
	 * Retrieves the list of booked slots for the specified customer ID.
	 *
	 * @param customerId the customer ID
	 */
	public void bookedSlots(String customerId) {
		customerDao.bookedGymList(customerId);
		return ;
	}
}