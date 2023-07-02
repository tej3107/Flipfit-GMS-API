/**
 * 
 */
package com.flipkart.constants;

/**
 * SQLConstants Class for SQL Queries 
 */
public class SQLConstants {

	public static final String SQL_AUTH_QUERY = "Select * From User Where userName = (?)";

	public static final String SQL_INSERT_SESSION_QUERY = "Insert Into Session Values (?,?,?)";
	public static final String SQL_DELETE_QUERY_FOR_SESSION = "DELETE from Session Where token = (?)";

	public static final String SQL_FETCH_SESSION_QUERY = "Select * From Session Where token = (?)";
	public static final String SQL_FETCH_ALL_OWNER_QUERY = "Select * From GymOwner";
	public static final String SQL_FETCH_ALL_GYM_QUERY = "Select * From Gymnasium";
	public static final String SQL_FETCH_PENDING_OWNER_REQ_QUERY = "Select * From GymOwner Where Approved = 0";
	public static final String SQL_FETCH_PENDING_GYM_REQ_QUERY = "Select * From Gymnasium Where Approved = 0";
	public static final String SQL_APPR_SING_OWNER_REQ_QUERY = "Update GymOwner Set Approved = 1 Where userName = (?)";
	public static final String SQL_APPR_SING_GYM_REQ_QUERY = "Update Gymnasium Set Approved = 1 Where GymnasiumId = (?)";
	public static final String SQL_UNAPPR_SING_GYM_REQ_QUERY = "Update Gymnasium Set Approved = 0 Where userName = (?)";
	public static final String SQL_UNAPPR_SING_OWNER_REQ_QUERY = "Update GymOwner Set Approved = 0 Where userName = (?)";
	public static final String SQL_APPR_ALL_OWNER_QUERY = "Update GymOwner Set Approved = 1";
	public static final String SQL_APPR_ALL_GYM_QUERY = "Update Gymnasium Set Approved = 1";
	
	
	public static final String SQL_FETCH_SING_OWNER_DET_QUERY = "Select * From GymOwner Where userName = (?)";
	public static final String SQL_FETCH_OWNER_GYM_DET_QUERY = "Select * From Gymnasium Where userName = (?)";
	public static final String SQL_FETC_GYM_DET_QUERY = "Select * From Gymnasium Where gymnasiumId = (?)";
	public static final String SQL_FETCH_OWNER_APPROVAL_QUERY = "Select Approved From GymOwner Where userName = (?)";
	public static final String SQL_SIZE_GYM_QUERY = "Select Count(*) From Gymnasium";
	public static final String SQL_INSERT_GYM_QUERY = "Insert Into Gymnasium Values (?,?,?,?,?,?,?)";
	public static final String SQL_SIZE_SLOTS_QUERY = "Select Count(*) From Slots";
	public static final String SQL_INSERT_SLOTS_QUERY = "Insert Into Slots Values (?,?,?,?,?)";
	public static final String SQL_SIZE_GYMOWNER_QUERY = "Select Count(*) From GymOwner";
	public static final String SQL_SIZE_GYMOWNER_REG_QUERY = "Select Count(*) From GymOwnerRegistration";
	public static final String SQL_REGISTER_GYMOWNER_QUERY = "Insert Into GymOwner Values (?,?,?,?,?,NULL,?,?,?,0)";
	public static final String SQL_REGISTER_GYMOWNER_REG_QUERY = "Insert Into GymOwnerRegistration Values (?,NULL,NULL,?)";
	public static final String SQL_REGISTER_GYMOWNER_USER_QUERY = "Insert Into User Values (?,?,?)";
	
	
	public static final String SQL_FETCH_GYM_SLOT_QUERY = "Select * From Slots Where GymnasiumId = (?)";
	public static final String SQL_SIZE_BOOK_QUERY = "Select Count(*) From BookedSlot";
	public static final String SQL_SIZE_CUSTOMER_QUERY = "Select Count(*) From Customer";
	public static final String SQL_SIZE_CUSTOMER_REG_QUERY = "Select Count(*) From CustomerRegistration";
	public static final String SQL_INSERT_BOOK_QUERY = "Insert Into BookedSlot (SlotId, userName, SlotDate, SlotTime) Values (?,?,?,?)";
	public static final String SQL_FETCH_BOOK_QUERY_FOR_A_CUST = "Select * from BookedSlot Where userName = (?) And SlotDate = (?) And SlotTime = (?)";
	public static final String SQL_COUNT_CURRENT_CAPACITY_QUERY = "Select Count(*) From BookedSlot Where SlotId = (?)";
	public static final String SQL_CHECK_CAPACITY_QUERY = "Select * From Slots Where SlotId = (?)";
	public static final String SQL_FETCH_MY_BOOKINGS_QUERY = "Select * From BookedSlot Where userName = (?)";
	public static final String SQL_FETCH_SLOT_DETAILS_QUERY = "Select * From Slots Where SlotId = (?)";
	public static final String SQL_FETCH_USER_QUERY = "Select * From User Where userName = (?)";

	public static final String SQL_FETCH_CUSTOMER_QUERY = "Select * From Customer Where userName = (?)";

	public static final String SQL_REGISTER_CUSTOMER_QUERY = "Insert Into Customer Values (?,?,?,?,?,NULL)";
	public static final String SQL_REGISTER_CUSTOMER_REG_QUERY = "Insert Into CustomerRegistration Values (?,NULL,?)";
	public static final String SQL_REGISTER_CUSTOMER_USER_QUERY = "Insert Into User Values (?,?,?)";
	
	
	public static final String SQL_DATE_CHECK_FROM_SLOTID = "SELECT date, SlotTime from slots WHERE SlotId = (?)";
	public static final String SQL_FETCH_SLOTID_FOR_CUSTOMER = "SELECT * from BookedSlot WHERE userName = (?)";
	public static final String SQL_DELETE_QUERY_FOR_CUST_IN_BOOKEDSLOT = "DELETE from BookedSlot Where userName = (?) And SlotDate = (?) And SlotTime = (?)";
	public static final String SQL_DELETE_QUERY_CUST_USER_IN_BOOKEDSLOT = "DELETE from BookedSlot Where userName = (?) And slotId = (?)";
	public static final String SQL_UPDATE_CAPACITY_QUERY = "Update Slots Set capacity = (?) Where slotId = (?)";
	
	
}