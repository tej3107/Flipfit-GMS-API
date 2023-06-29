/**
 * DAO class for User management system.
 */
package com.flipkart.dao;
import java.sql.Connection;
import com.flipkart.bean.*;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtils;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO class that provides database operations for User management system.
 */
public class UserGMSDao {
	
	/**
	 * Authenticates a user by checking their username and password.
	 *
	 * @param userName The username of the user.
	 * @param password The password of the user.
	 * @return The exit code: 0 for admin, 1 for customer, 2 for gym owner, 3 for trainer, 4 for invalid credentials.
	 */	   
   public int authenticateUser(String userName, String password) {
	   int exitCode = 4;
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   try {
		   conn = DBUtils.getConnection();
		   
		   stmt = conn.prepareStatement(SQLConstants.SQL_AUTH_QUERY);
		   stmt.setString(1, userName); 
	
		   ResultSet output = stmt.executeQuery();
		   output.next();
		   String desiredPassword = output.getString(2);
		   
		   if(password.equals(desiredPassword)) return output.getInt(3);
		   else return exitCode;
		   
	   } catch(SQLException sqlExcep) {
//		      System.out.println(sqlExcep);
	   } catch(Exception excep) {
	      excep.printStackTrace();
	   }
	   
	   return exitCode;
   }
}
