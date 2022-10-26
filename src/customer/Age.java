package customer;

import java.io.Serializable;

import movie.ticket.ITicketAttribute;

public enum Age implements ITicketAttribute, Serializable {
	SENIOR("Senior", 0.80),
	ADULT("Adult", 1),
	CHILDREN("Children", 0.50);
	
	
	private String name;
	private double multiplier;

	Age(String name, double multiplier) {
		this.name = name;
		this.multiplier = multiplier;
	}
	
	@Override
	public double getMultiplier() { return multiplier; }
	public String getName() { return name; }
	
	@Override
	public void setMultiplier(double multiplier) { this.multiplier = multiplier; }

}
