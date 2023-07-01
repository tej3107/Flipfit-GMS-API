/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Slots {
	private String slotId; // ID of the slot.
	private String gymId; // ID of the gymnasium.

	private int capacity; // Capacity of the slot.
	private int time; // Time of the slot.
	private String date;
	
	/**
	 * Default constructor for the Slots class.
	 */
	public Slots() {
		
	}

	public int getTime() {
		return time;
	}

	public Slots(String slotId, String gymId, int capacity, String date, int time) {
		this.slotId = slotId;
		this.gymId = gymId;
		this.capacity = capacity;
		this.time = time;
		this.date = date;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Returns the ID of the slot.
	 *
	 * @return the slot ID
	 */
	public String getSlotId() {
		return slotId;
	}
	
	/**
	 * Sets the ID for the slot.
	 *
	 * @param slotId the slot ID to set
	 */
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}
	
	/**
	 * Returns the capacity of the slot.
	 *
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * Sets the capacity for the slot.
	 *
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	
	/**
	 * Returns the ID of the gymnasium.
	 *
	 * @return the gymnasium ID
	 */
	public String getGymId() {
		return gymId;
	}

	/**
	 * Sets the ID for the gymnasium.
	 *
	 * @param gymId the gymnasium ID to set
	 */
	public void setGymId(String gymId) {
		this.gymId = gymId;
	}
}