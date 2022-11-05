package cineplex.cinema;

import java.io.Serializable;

/**
 * The Seat class contains information of a seat
 */
public class Seat implements Serializable {

	/**
	 * Represents a static final UUID for Seat
	 */
	private static final long serialVersionUID = 1036306049152454258L;

	/**
	 * Represents whether a seat is occupied or not
	 * The default value is false
	 */
	private boolean occupied = false;

	/**
	 * Represents the seat and cinema code
	 */
	private String seatCode, cinemaCode;
	
	/**
	 * Constructor for {@code Seat} which creates a seat with the seat and cinema code
	 * @param seatCode is the seat code
	 * @param cinemaCode is the cinema code
	 */
	public Seat(String seatCode, String cinemaCode) {
		this.seatCode = seatCode;
		this.cinemaCode = cinemaCode;
	}
	
	/**
	 * Gets the seat code
	 * @return the seat code
	 */
	public String getSeatCode() { return seatCode; }

	/**
	 * Gets the cinema code
	 * @return the cinema code
	 */
	public String getCinemaCode() { return cinemaCode; }
	
	/**
	 * Checks whether a seat is occupied
	 * @return {@code true} if the seat is occupied, {@code false} otherwise
	 */
	public boolean isOccupied() { return occupied; }
	
	/**
	 * Sets the {@code Seat} occupied attribute as {@code true} or {@code false}
	 * @param occupied reflects whether a seat is occupied or not
	 */
	public void setOccupied(boolean occupied) { this.occupied = occupied; }
}
