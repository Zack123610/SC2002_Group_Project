package cineplex.cinema;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Seat implements Serializable {
	private boolean occupied = false;
	private String seatCode;
	
	public Seat(String seatCode) {
		this.seatCode = seatCode;
	}
	
	public String getSeatCode() {
		return seatCode;
	}
	
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
}
