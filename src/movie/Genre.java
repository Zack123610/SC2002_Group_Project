package movie;

import java.io.Serializable;

import movie.ticket.ITicketAttribute;

public enum Genre implements ITicketAttribute, Serializable {
	THREED("3D"),
	ACTION("Action"),
	BLOCKBLASTER("Blockbuster");

	
	private String name;
	private double multipler;
	
	Genre(String name) {
		this.name = name;
		this.multipler = 1.0;
	}

	
	public String getName() {
		return name;
	}
	@Override
	public void setMultiplier(double multiplier) {
		this.multipler = multiplier;
	}
	@Override
	public double getMultiplier() {
		return multipler;
	}

}
