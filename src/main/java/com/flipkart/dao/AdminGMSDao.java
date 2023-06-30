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

public class AdminGMSDao {
	/**
	* Fetches details of all gym owners from the database.
	*/
   
   public ArrayList<GymOwner> fetchGymOwnerDetails() throws Exception{
//	   System.out.println("Connecting to database...");
	   ArrayList<GymOwner> gymOwners = new ArrayList<>();
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   conn = DBUtils.getConnection();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_OWNER_QUERY);
		   ResultSet output = stmt.executeQuery();

		   if (output.next()) {
		       // At least one gym owner is present
		       System.out.println("\n\tID\tGymOwner Name");
		       do {
				   GymOwner gym_own = new GymOwner(
					   output.getString(1),
					   "pwd",
					   3,
					   output.getString(2),
					   output.getString(3),
					   output.getString(4),
					   output.getString(5),
					   output.getString(7),
					   output.getString(8),
					   output.getString(9),
					   output.getInt(10)
				   );
				   gymOwners.add(gym_own);
		           System.out.println("\t" + output.getString(1) + " \t " + output.getString(2));
		       } while (output.next());
		   } else {
		       // No gym owner present
		       System.out.println("No gym owner registered yet");
		   }

	   } catch(SQLException sqlExcep) {
		      System.out.println(sqlExcep);
			  throw sqlExcep;
	   } catch(Exception excep) {
	      excep.printStackTrace();
		  throw excep;
	   }
	   return gymOwners;
   }
   
   
   /**
    * Fetches details of all gymnasiums from the database.
    */
   public ArrayList<Gymnasium> fetchGymnasiumDetails() throws Exception{
//	   System.out.println("Connecting to database...");

	   ArrayList<Gymnasium> gyms = new ArrayList<>();
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   conn = DBUtils.getConnection();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_GYM_QUERY);
		   ResultSet output = stmt.executeQuery();

		   if (output.next()) {
		       // At least one gym owner is present
			   System.out.println("\n\tID\tGymnasium Name");
		       do {
				   Gymnasium gm = new Gymnasium(
						   output.getString(1),
						   output.getString(2),
						   output.getString(3),
						   output.getDouble(4),
						   output.getInt(5),
						   output.getInt(6),
						   output.getString(7)
				   );
				   gyms.add(gm);
				   System.out.println("\t" + output.getString(1) + " \t " + output.getString(2));
		       } while (output.next());
		   } else {
		       // No gym owner present
		       System.out.println("No gymnasiums registered yet");
		   }
	   } catch(SQLException sqlExcep) {
		      System.out.println(sqlExcep);
			  throw sqlExcep;
	   } catch(Exception excep) {
	      excep.printStackTrace();
		  throw excep;
	   }
	   return gyms;
   }
   
   
   /**
   * Fetches all pending gym owner requests from the database.
   * 
   * @return true if at least one pending gym owner request is present, false otherwise.
   */
   public ArrayList<GymOwner> fetchPendingGymOwnerRequests() throws Exception{
	    // System.out.println("Connecting to database...");
	   ArrayList<GymOwner> gymOwners = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement stmt = null;

	    try {
	        conn = DBUtils.getConnection();

	        stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_PENDING_OWNER_REQ_QUERY);
	        ResultSet output = stmt.executeQuery();

	        if (output.next()) {
				GymOwner gmown = new GymOwner(
						output.getString(1),
						"pwd",3,
						output.getString(2),
						output.getString(3),
						output.getString(4),
						output.getString(5),
						output.getString(7),
						output.getString(8),
						output.getString(9),
						output.getInt(10)
				);
				gymOwners.add(gmown);
	            // At least one gym owner is present
	            System.out.println("\n\tID\tGymOwner Name");
	            do {
	                System.out.println("\t" + output.getString(1) + " \t " + output.getString(2));
	            } while (output.next());
	        } else {
	            // No gym owner present
	            System.out.println("No pending gymowner requests");
	        }
	    } catch (SQLException sqlExcep) {
	         System.out.println(sqlExcep);
			 throw sqlExcep;
	    } catch (Exception excep) {
	        excep.printStackTrace();
			throw excep;
	    }
	    return gymOwners;
	}

   
   
   /**
    * Fetches all pending gymnasium requests from the database.
    * 
    * @return true if at least one pending gymnasium request is present, false otherwise.
    */
   public ArrayList<Gymnasium> fetchPendingGymnasiumRequest() throws Exception{
	    // System.out.println("Connecting to database...");

	   ArrayList<Gymnasium> gyms = new ArrayList<>();
	   Connection conn = null;
	    PreparedStatement stmt = null;

	    try {
	        conn = DBUtils.getConnection();

	        stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_PENDING_GYM_REQ_QUERY);
	        ResultSet output = stmt.executeQuery();

	        if (output.next()) {
	            // At least one gymnasium request is present
	            System.out.println("\n\tID\tGymnasium Name");
	            do {
					Gymnasium gm = new Gymnasium(
							output.getString(1),
							output.getString(2),
							output.getString(3),
							output.getDouble(4),
							output.getInt(5),
							output.getInt(6),
							output.getString(7)
					);
					gyms.add(gm);
	                System.out.println("\t" + output.getString(1) + " \t " + output.getString(2));
	            } while (output.next());
	        } else {
	            // No gymnasium request present
	            System.out.println("No gymnasium request present");
//	            return false;
	        }
	    } catch (SQLException sqlExcep) {
	         System.out.println(sqlExcep);
			 throw sqlExcep;
	    } catch (Exception excep) {
	        excep.printStackTrace();
			throw excep;
	    }
	    return gyms;
	}

   
   /**
    * Updates all pending gym owner requests as approved in the database.
    */
   public boolean updateAllPendingGymOwnerRequests() throws Exception{
//	   System.out.println("Connecting to database...");
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   conn = DBUtils.getConnection();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_APPR_ALL_OWNER_QUERY);
		   stmt.executeUpdate();
		   return true;
	   } catch (SQLException sqlExcep) {
		   System.out.println(sqlExcep);
		   throw sqlExcep;
	   } catch (Exception excep) {
		   excep.printStackTrace();
		   throw excep;
	   } 
   }

   
   /**
    * Updates all pending gymnasium requests as approved in the database.
    */
   public boolean updateAllPendingGymnasiumRequests() throws Exception{
//	   System.out.println("Connecting to database...");
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   conn = DBUtils.getConnection();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_APPR_ALL_GYM_QUERY);
		   stmt.executeUpdate();
		   return true;
	   } catch (SQLException sqlExcep) {
		   System.out.println(sqlExcep);
		   throw sqlExcep;
	   } catch (Exception excep) {
		   excep.printStackTrace();
		   throw excep;
	   } 
   }
   
   
   /**
    * Updates a single gym owner request as approved in the database.
    * 
    * @param userName the ID of the gym owner request to be updated.
    */
   public boolean updateSingleGymOwnerRequests(String userName) throws Exception{
//	   System.out.println("Connecting to database...");
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   conn = DBUtils.getConnection();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_APPR_SING_OWNER_REQ_QUERY);
		   stmt.setString(1, userName);
		   stmt.executeUpdate();
		   return true;
	   } catch (SQLException sqlExcep) {
		   System.out.println(sqlExcep);
		   throw sqlExcep;
	   } catch (Exception excep) {
		   excep.printStackTrace();
		   throw excep;
	   } 
   }
   
   
   /**
    * Updates a single gymnasium request as approved in the database.
    * 
    * @param GymnasiumId the ID of the gymnasium request to be updated.
    */
   public boolean updateSingleGymnasiumRequests(String GymnasiumId) throws Exception{
//	   System.out.println("Connecting to database...");
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   conn = DBUtils.getConnection();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_APPR_SING_GYM_REQ_QUERY);
		   stmt.setString(1, GymnasiumId);
		   stmt.executeUpdate();
		   return true;
	   } catch (SQLException sqlExcep) {
		   System.out.println(sqlExcep);
		   throw sqlExcep;
	   } catch (Exception excep) {
		   excep.printStackTrace();
		   throw excep;
	   } 
   }
   
   
   /**
    * Block a gym owner by rejecting their requests in the database.
    * 
    * @param userName the ID of the gym owner to be Block.
    */
   public boolean unApproveGymOwner(String userName) throws Exception{
//	   System.out.println("Connecting to database...");
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   conn = DBUtils.getConnection();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_UNAPPR_SING_GYM_REQ_QUERY);
		   stmt.setString(1, userName);
		   stmt.executeUpdate();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_UNAPPR_SING_OWNER_REQ_QUERY);
		   stmt.setString(1, userName);
		   stmt.executeUpdate();
		   return true;
		   
	   } catch (SQLException sqlExcep) {
		   System.out.println(sqlExcep);
		   throw sqlExcep;
	   } catch (Exception excep) {
		   excep.printStackTrace();
		   throw excep;
	   }
   }
   
}
