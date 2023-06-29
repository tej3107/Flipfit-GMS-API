package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerGMSDao {
	
	/**
	 * Registers a new customer in the database.
	 *
	 * @param user     The user information.
	 * @param customer The customer information.
	 */
	public void registerCustomer(User user, Customer customer) {
		// Connect to the database and register the customer
		// Retrieve customer ID and register in the Customer schema
		// Register in the CustomerRegistration schema
		// Register in the User schema
		// Handle any exceptions that occur
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// Getting customer Id
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_CUSTOMER_QUERY);
		    ResultSet output = stmt.executeQuery();
		    output.next();
		    int count = output.getInt(1);
		    count++;
		    count++;
		    
//		    user.setUserName(Integer.toString(count));
		    
		    
		    // Registering in Customer schema
			System.out.println(user.getUserName()+customer.getName()+customer.getMobile());
			System.out.println(customer.getEmail()+customer.getAddress());
		    stmt = conn.prepareStatement(SQLConstants.SQL_REGISTER_CUSTOMER_QUERY);
		    stmt.setString(1, user.getUserName());
		    stmt.setString(2, user.getUserName());
		    stmt.setString(3, customer.getName());
		    stmt.setString(4, customer.getMobile());
		    stmt.setString(5, customer.getEmail());
		    stmt.setString(6, customer.getAddress());
		    
		    stmt.executeUpdate();
		    
		    
		    // Getting RegId
		    conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_CUSTOMER_REG_QUERY);
		    output = stmt.executeQuery();
		    output.next();
		    count = output.getInt(1);
		    count++;
		    
		    String regId = new String();
		    regId = (Integer.toString(count));
		    
		    // Registering in CustomerRegistration Schema
		    stmt = conn.prepareStatement(SQLConstants.SQL_REGISTER_CUSTOMER_REG_QUERY);
		    stmt.setString(1, regId);
		    stmt.setString(2, user.getUserName());
		    stmt.executeUpdate();
		    
		    
		    // Registering in User Schema
		    stmt = conn.prepareStatement(SQLConstants.SQL_REGISTER_CUSTOMER_USER_QUERY);
		    stmt.setString(1, user.getUserName());
		    stmt.setString(2, user.getPassword());
		    stmt.setInt(3, 3);
		    
		    stmt.executeUpdate();
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	}
	
	/**
	 * Fetches the list of all gyms from the database.
	 */
	public ArrayList<Gymnasium> fetchGymList() {
		// Connect to the database and fetch the list of all gyms
		// Print the fetched gym details
		// Handle any exceptions that occur
		ArrayList<Gymnasium> gymList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_GYM_QUERY);
	
		    ResultSet output = stmt.executeQuery();
		    System.out.println("\tGymID\tName\tAddress");
		    while(output.next()) {
				Gymnasium gym = new Gymnasium(output.getString(1),output.getString(2),output.getString(3),
						output.getDouble(4),output.getInt(5),output.getInt(6),output.getString(7));
				gymList.add(gym);
		    	System.out.println("\t "+output.getString(1) + "\t " + output.getString(2) + "\t " + output.getString(3));
		    }
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		return gymList;
	}
	
	/**
	 * Fetches the list of available slots for a given gym from the database.
	 *
	 * @param gymId The ID of the gym.
	 */
	public ArrayList<Slots> fetchSlotList(String gymId) {
		// Connect to the database and fetch the list of slots for the specified gym
		// Print the fetched slot details
		// Handle any exceptions that occur
		ArrayList<Slots> slotList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_GYM_SLOT_QUERY);
		    stmt.setString(1, gymId); 
		    ResultSet output = stmt.executeQuery();
//		    System.out.println(output);
		    System.out.println("\tSlotID\tGymID\tDay\ttime");
		    while(output.next()) {
				Slots slot = new Slots(output.getString(1),output.getString(2),
						output.getInt(3),output.getString(4),output.getInt(5));
				slotList.add(slot);
		    	System.out.println("\t "+ output.getString(1) + " \t " 
		    			+ output.getString(2) + "\t " 
		    			+ output.getString(4) +"    " + output.getString(5)+":00hrs");
		    }
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		return slotList;
	}
	
	
	/**
	 * Books a slot for a customer in the database.
	 *
	 * @param slotId     The ID of the slot to book.
	 * @param customerId The ID of the customer.
	 */
	public void bookSlots(String slotId,String customerId) {
		// Connect to the database and book the slot for the customer
		// Retrieve necessary details from the slot
		// Insert the booking details into the database
		// Handle any exceptions that occur
		   
		Connection conn = null;
		PreparedStatement stmt = null;
		   
	    try {
	    	conn = DBUtils.getConnection();
		    
		    stmt = conn.prepareStatement(SQLConstants.SQL_DATE_CHECK_FROM_SLOTID);
		    stmt.setString(1, slotId);
		    ResultSet output = stmt.executeQuery();
		    output.next();
		    String date = output.getString(1);
		    Integer times = output.getInt(2);
		    
		    stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_BOOK_QUERY);
		    stmt.setString(1, slotId);
		    stmt.setString(2, customerId);
		    stmt.setString(3, date);
		    stmt.setInt(4, times);
		    
		    stmt.executeUpdate();
		    
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	    
	    return;
	}
	
	/**
	 * Checks if a slot is full based on its capacity.
	 *
	 * @param slotId The ID of the slot to check.
	 * @return true if the slot is full, false otherwise.
	 */
	public boolean isFull(String slotId) {
		// Connect to the database and check the current capacity of the slot
		// Retrieve the total capacity of the slot
		// Return whether the current capacity is equal to or greater than the total capacity
		// Handle any exceptions that occur
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_COUNT_CURRENT_CAPACITY_QUERY);
		    stmt.setString(1, slotId); 
		    ResultSet output = stmt.executeQuery();
		    output.next();
		    int current_capacity = output.getInt(1);
		    
		    stmt = conn.prepareStatement(SQLConstants.SQL_CHECK_CAPACITY_QUERY);
		    stmt.setString(1, slotId); 
		    output = stmt.executeQuery();
		    output.next();
		    int total_capacity = output.getInt(3);
		    
		    return current_capacity>=total_capacity;
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		return false;
	}
	
	/**
	 * Fetches the list of gyms booked by a customer from the database.
	 *
	 * @param custId The ID of the customer.
	 */
	public ArrayList<BookedSlot> bookedGymList(String custId) {
		// Connect to the database and fetch the list of slots booked by the customer
		// Print the fetched slot details
		// Handle any exceptions that occur
		ArrayList<BookedSlot> bookedSlotList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection(); 
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_SLOTID_FOR_CUSTOMER);
		    stmt.setString(1, custId); 
		    ResultSet output = stmt.executeQuery();
//		    System.out.println("customer fetch");

//			System.out.println("\tSlotID\tGymID\tDay\ttime");
		    while(output.next()) {
//				System.out.println(output.getString(2));
				String slotId= output.getString(2);
		    	stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_SLOT_DETAILS_QUERY);
			    stmt.setString(1, slotId);
			    ResultSet out = stmt.executeQuery();
			    out.next();
//				System.out.println("slot fetch");

				BookedSlot bookedSlot = new BookedSlot(output.getInt(1),
						output.getString(2),output.getString(3),
						output.getString(4),output.getInt(5));
				bookedSlotList.add(bookedSlot);
		    }
		    
		    
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		return bookedSlotList;
	}
	
	
	/**
	 * Changes the booked slot for a customer in the database.
	 *
	 * @param slotId     The ID of the new slot to book.
	 * @param customerId The ID of the customer.
	 * @return true if the slot is changed successfully, false otherwise.
	 */
	public boolean changeGymSlot(String slotId,String customerId) {
		// Connect to the database and retrieve the details of the new slot
		// Retrieve the day and times of the new slot
		// Retrieve the current bookings of the customer on the same day and times
		// Delete the existing bookings and insert the new booking
		// Return whether the slot was changed successfully
		// Handle any exceptions that occur
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = DBUtils.getConnection();
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_SLOT_DETAILS_QUERY);
		    stmt.setString(1, slotId); 
		    ResultSet output = stmt.executeQuery();
		    output.next();
		    String day = output.getString(4);
		    Integer times = output.getInt(5);
		    
		    
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_BOOK_QUERY_FOR_A_CUST);
		    stmt.setString(1, customerId); 
		    stmt.setString(2, day); 
		    stmt.setInt(3, times); 
		    output = stmt.executeQuery();
		    
		    boolean flag = false;
		    
		    while(output.next()){
		    	flag=true;
//		    	System.out.println("Reaching to delete  - " + Integer.toString(output.getInt(1)));
		        PreparedStatement preparedStmt = conn.prepareStatement(SQLConstants.SQL_DELETE_QUERY_FOR_CUST_IN_BOOKEDSLOT);
		        preparedStmt.setString(1, customerId);
		        preparedStmt.setString(2, day);
		        preparedStmt.setInt(3, times);
		        preparedStmt.execute();
			    
			    
			    stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_BOOK_QUERY);
			    stmt.setString(1, slotId);
			    stmt.setString(2, customerId);
			    stmt.setString(3, day);
			    stmt.setInt(4, times);
			    
			    stmt.executeUpdate();
		        
		    }
		    return flag;
			
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		return true;
	}
	
}
