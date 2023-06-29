package com.flipkart.exception;

/**
 * Exception to check if a course is already registered by a student.
 */
public class incorrectDataType extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String datatype;
	
	/**
	 * Constructor for incorrectDataType.
	 * 
	 * @param datatype The data type that was incorrect.
	 */
	public incorrectDataType(String datatype) {
		this.datatype = datatype;
	}
	
	/**
	 * Returns the error message when the exception is thrown.
	 * 
	 * @return The error message indicating the incorrect data type.
	 */
	@Override
	public String getMessage() {
		return "Incorrect data type. Please enter " + datatype;
	}

}