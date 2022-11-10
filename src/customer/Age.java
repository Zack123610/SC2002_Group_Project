package customer;

import movie.ticket.ITicketAttribute;

/**
 * The enum Age provides implementation for ITicketAttribute interface.
 * It represents the different Age categories and their price multipliers
 */
public enum Age implements ITicketAttribute {

	/**
	 * SENIOR has default multiplier of 0.8
	 */
	SENIOR("Senior Citizen", 0.80),

	/**
	 * ADULT has default multiplier of 1
	 */
	ADULT("Adult", 1),

	/**
	 * CHILD has default multiplier of 0.5
	 */
	CHILD("Child", 0.50);
	
	/**
	 * Name of the age category
	 */
	private String name;

	/**
	 * The multiplier associated with the age
	 */
	private double multiplier;

	/**
	 * Constructor for Age class which creates Age enum with the category and multipler
	 * @param name is the category
	 * @param multiplier is the multiplier
	 */
	Age(String name, double multiplier) {
		this.name = name;
		this.multiplier = multiplier;
	}
	

	@Override
	public double getMultiplier() { return multiplier; }

	/**
	 * Gets the name of the category
	 */
	public String getName() { return name; }
	
	@Override
	public void setMultiplier(double multiplier) { this.multiplier = multiplier; }
}
