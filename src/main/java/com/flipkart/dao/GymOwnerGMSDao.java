/**
 * DAO class for Gym Owner management system.
 */
package com.flipkart.dao;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Gymnasium;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class that provides database operations for Gym Owner management system.
 */
public class GymOwnerGMSDao {
	
	
	/**
	 * Registers a new gym owner in the database.
	 *
	 * @param owner The gym owner information.
	 */
	public ArrayList<String> registerGymOwner(GymOwner owner) {
		
		ArrayList<String> arrayList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// Getting owner Id
			conn = DBUtils.getConnection();

			stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_USER_QUERY);
			stmt.setString(1,owner.getUserName());
			ResultSet output1 = stmt.executeQuery();
//			output1.next();
			if(output1.next()){
				arrayList.add("false");arrayList.add("Username already exist");
				System.out.println("");
				return arrayList;
			}


			stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_GYMOWNER_QUERY);
		    ResultSet output = stmt.executeQuery();
		    output.next();
		    int count = output.getInt(1);
		    count++;
		    
//		    user.setUserName(Integer.toString(count));
		    
		    
		    
		    // Registering in Owner schema
		    stmt = conn.prepareStatement(SQLConstants.SQL_REGISTER_GYMOWNER_QUERY);
		    stmt.setString(1, owner.getUserName());
		    stmt.setString(2, owner.getName());
		    stmt.setString(3, owner.getMobile());
		    stmt.setString(4, owner.getEmail());
		    stmt.setString(5, owner.getAddress());
		    stmt.setString(6, owner.getAadhaarNumber());
		    stmt.setString(7, owner.getPanNumber());
		    stmt.setString(8, owner.getGstNumber());
		    
		    stmt.executeUpdate();
		    
		    
		    // Getting RegId
		    conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_GYMOWNER_REG_QUERY);
		    output = stmt.executeQuery();
		    output.next();
		    count = output.getInt(1);
		    count++;
		    
		    String regId = new String();
		    regId = (Integer.toString(count));
		    
		    
		    // Registering in CustomerRegistration Schema
		    stmt = conn.prepareStatement(SQLConstants.SQL_REGISTER_GYMOWNER_REG_QUERY);
		    stmt.setString(1, regId);
		    stmt.setString(2, owner.getUserName());
		    stmt.executeUpdate();
		    
		    
		    // Registering in User Schema
		    stmt = conn.prepareStatement(SQLConstants.SQL_REGISTER_GYMOWNER_USER_QUERY);
		    stmt.setString(1, owner.getUserName());
		    stmt.setString(2, owner.getPassword());
		    stmt.setInt(3, 2);
		    
		    stmt.executeUpdate();
	    } catch(SQLException sqlExcep) {
			System.out.println(sqlExcep);
			arrayList.add("false");arrayList.add(sqlExcep.getMessage());
			return arrayList;
	    } catch(Exception excep) {
	           excep.printStackTrace();
			arrayList.add("false");arrayList.add(excep.getMessage());
			return arrayList;
	    }
		return arrayList;
	}
	
	
	/**
	 * Fetches the details of a gym owner from the database.
	 *
	 * @param userName The username of the gym owner.
	 */
	public GymOwner fetchOwnerDetails(String userName) {
		System.out.println("reach1");
		GymOwner gymOwner = new GymOwner();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		   
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_SING_OWNER_DET_QUERY);
		    stmt.setString(1, userName); 
	
		    ResultSet output = stmt.executeQuery();
		    System.out.println("\tID\tGymOwner Name");
		    if(output.next()) {
				gymOwner.setUserName(output.getString(1));
				gymOwner.setName(output.getString(2));
				gymOwner.setMobile(output.getString(3));
				gymOwner.setEmail(output.getString(4));
				gymOwner.setAddress(output.getString(5));
//				gymOwner.setDob(output.get(6));
				gymOwner.setAadhaarNumber(output.getString(7));
				gymOwner.setPanNumber(output.getString(8));
				gymOwner.setGstNumber(output.getString(9));
				gymOwner.setApproved(output.getInt(10));
		    	System.out.println("\t"+output.getString(1) + "\t " + output.getString(2));
		    }
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		return gymOwner;
	}
	
	/**
	 * Fetches the list of gyms owned by a gym owner from the database.
	 *
	 * @param userName The username of the gym owner.
	 */
	public ArrayList<Gymnasium> fetchMyGyms(String userName) {

		ArrayList<Gymnasium> gymList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		   
	    try {
	    	conn = DBUtils.getConnection();
		   
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_OWNER_GYM_DET_QUERY);
		    stmt.setString(1, userName); 
	
		    ResultSet output = stmt.executeQuery();
		    System.out.println("\tID\tGymnasium Name");
		    while(output.next()) {
				Gymnasium gym = new Gymnasium( output.getString(1),
						output.getString(2),output.getString(3),
						output.getDouble(4),output.getInt(5),
						output.getInt(6),output.getString(7)
				);
				gymList.add(gym);
		    	System.out.println("\t"+output.getString(1) + "\t " + output.getString(2));
		    }
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		return gymList;
	}
	
	/**
	 * Checks if a gym owner is approved based on their username.
	 *
	 * @param userName The username of the gym owner.
	 * @return true if the gym owner is approved, false otherwise.
	 */
	public boolean isOwnerApproved(String userName) {
		   
		Connection conn = null;
		PreparedStatement stmt = null;
		   
	    try {
	    	conn = DBUtils.getConnection();
		   
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_OWNER_APPROVAL_QUERY);
		    stmt.setString(1, userName); 
	
		    ResultSet output = stmt.executeQuery();
		    if(output.next()) return output.getBoolean(1);
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	    
	    return false;
	}
	
	/**
	 * Adds gym details to the database.
	 *
	 * @param gym             The gymnasium information.
	 * @param slotAvailable   The list of available slots.
	 * @param capacity        The capacity of the gym.
	 */
	public void addGymDetails(Gymnasium gym, ArrayList<Integer> slotAvailable, int capacity) {
		   
		Connection conn = null;
		PreparedStatement stmt = null;
		   
	    try {
	    	conn = DBUtils.getConnection();
		   
		    stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_GYM_QUERY);
		    ResultSet output = stmt.executeQuery();
		    output.next();
		    int count = output.getInt(1);
		    count++;
		    
		    gym.setGymId(Integer.toString(count));
		    
		    stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_GYM_QUERY);
		    stmt.setString(1, gym.getGymId());
		    stmt.setString(2, gym.getName());
		    stmt.setString(3, gym.getAddress());
		    stmt.setDouble(4, gym.getTotalArea());
		    stmt.setInt(5, gym.getNumItem());
		    stmt.setInt(6, 0);
		    stmt.setString(7, gym.getUserName());
		    
		    stmt.executeUpdate();
		    
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	    
	    List<String> days=new ArrayList<String>();
	    days.add("Monday");days.add("Tuesday");days.add("Wednesday");days.add("Thursday");
	    days.add("Friday");days.add("Saturday");days.add("Sunday");
	    
	    
	    for (String i : days) {
	    	for (Integer j : slotAvailable) {
	    		try {
	    			conn = DBUtils.getConnection();
					   
				    stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_SLOTS_QUERY);
				    ResultSet output = stmt.executeQuery();
				    output.next();
				    int count = output.getInt(1);
				    count++;
				    
				    String slotId = Integer.toString(count);
				    
				    stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_SLOTS_QUERY);
				    stmt.setString(1, slotId);
				    stmt.setString(2, gym.getGymId());
				    stmt.setInt(3, capacity);
				    stmt.setString(4, i);
				    stmt.setInt(5, j);
				    
				    stmt.executeUpdate();
				    
				    
				    
	    		}catch(SQLException sqlExcep) {
//				       System.out.println(sqlExcep);
			    } catch(Exception excep) {
			           excep.printStackTrace();
			    }
	        }
        }
	    
	    
	    return;
	}
	
}
