package cineplex.cinema;

import java.io.Serializable;

public class Seat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1036306049152454258L;
	private boolean occupied = false;
	private String seatCode;
	
	public Seat(String seatCode) {
		this.seatCode = seatCode;
	}
	
	public String getSeatCode() { return seatCode; }
	
	public boolean isOccupied() { return occupied; }
	
	public void setOccupied(boolean occupied) { this.occupied = occupied; }
}
