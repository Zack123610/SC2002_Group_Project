package cineplex.cinema;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Seat implements Serializable {
	public boolean occupied = false;
	private String seatCode;
	private String cinema;
	
	public Seat(String seatCode, String Cinemacode) {
		this.seatCode = seatCode;
		this.cinema = Cinemacode;
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
	public String CinemaCode()
	{
		return this.cinema;
	}
}
