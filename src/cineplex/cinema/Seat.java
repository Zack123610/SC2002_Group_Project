package cineplex.cinema;

import java.io.Serializable;

public class Seat implements Serializable {

	private static final long serialVersionUID = 1036306049152454258L;
	private boolean occupied = false;
	private String seatCode, cinemaCode;
	
	public Seat(String seatCode, String cinemaCode) {
		this.seatCode = seatCode;
		this.cinemaCode = cinemaCode;
	}
	
	public String getSeatCode() { return seatCode; }
	public String getCinemaCode() { return cinemaCode; }
	
	public boolean isOccupied() { return occupied; }
	
	public void setOccupied(boolean occupied) { this.occupied = occupied; }
}
