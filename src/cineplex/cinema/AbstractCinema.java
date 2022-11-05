package cineplex.cinema;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import input.Writable;
import movie.ticket.IGetTicketAttribute;

/**
 * The abstract cinema class is the parent class of all cinema classes and provides implementation for the IGetTicketAttribute Interface
 */
public abstract class AbstractCinema extends Writable implements IGetTicketAttribute {

	/**
	 * Represents a static final UUID for Abstract cinemas
	 */
	private static final long serialVersionUID = -5782367057189056125L;

	/**
	 * The number of available seats in the cinema
	 */
	protected int availSeat;

	/**
	 * The total number of seats in the cinema
	 */
	protected int totalSeats;

	/**
	 * The cinema code
	 */
	protected String cinemaCode;

	/**
	 * Represents a map of the seats
	 */
	protected Map<Character, List<Seat>> seatMap;

	/**
	 * Checks if the cinema is full
	 * @return {@code true} if the there are no available seats, {@code false} otherwise
	 */
	public boolean isFull() { return availSeat == 0; }

	/**
	 * Checks if the cinema is empty
	 * @return {@code true} if all seats are available, {@code false} otherwise 
	 */
	public boolean isEmpty() { return availSeat == totalSeats; }
	
	/**
	 * An abstract function to display the seating layout of the cinema
	 */
	public abstract void displaySeatingLayout();

	/**
	 * An abstract function to clone the cinema
	 * @return a cloned {@code AbstractCinema} object
	 */
	public abstract AbstractCinema cloneCinema();
	
	/**
	 * Selects a seat based on its row and column number
	 * The method also handles errors if the seat is occupied or is an invalid choice
	 * @param row is the row number
	 * @param col is the column number
	 * @return the a selected {@code Seat}
	 */
	public Seat selectSeat(char row, int col) {
		Seat seat = null;
		
		try {
			seat = seatMap.get(row).get(col);
			
			if (seat.isOccupied())
				throw new SeatBookingException("Error. This seat is already occupied!");
			
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			System.out.println("Error. Invalid seat selection.");
			return null;
		} catch (SeatBookingException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		return seat;
	}
	
	/**
	 * Books the seat, and sets it as occupied
	 * @param seat is the selected {@code Seat}
	 */
	public void bookSeat(Seat seat) {
		availSeat--;
		seat.setOccupied(true);
	}
	
	/**
	 * Undoes the seat selection and unoccupies the seat
	 * @param seat is the {@code Seat} to be cleared
	 */
	public void clearSeat(Seat seat) {
		availSeat++;
		seat.setOccupied(false);
	}
	
	/**
	 * This method checks whether two {@code AbstractCinema} objects are the same by comparing their cinema codes.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractCinema)
			return this.getCinemaCode().equals(((AbstractCinema) obj).getCinemaCode());
		return false;
	}
	/**
	 * This method hashes the cinema code of the {@code AbstractCinema} object. 
	 * Required for comparing between two {@code AbstractCinema} objects in a set.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cinemaCode);
	}
	
	// Getters
	/**
	 * Gets the number of available seats
	 * @return the available seats
	 */
	public int getAvailSeat() { return availSeat; }

	/**
	 * Gets the total seats in the cinema
	 * @return the total seats
	 */
	public int getTotalSeats() { return totalSeats; }

	/**
	 * Gets the cinema code
	 * @return the cinema code
	 */
	public String getCinemaCode() { return cinemaCode; }

	/**
	 * gets the seat map of the cinema
	 * @return a seat map
	 */
	public Map<Character, List<Seat>> getSeatMap() { return this.seatMap; };
	
	// Setters
	/**
	 * Sets the total seats in the cinema
	 * @param total is the number of seats to be set
	 */
	public void setTotalSeats(int total) { totalSeats = total; }

	/**
	 * Sets the number of available seats in the cinema
	 * @param availSeat is the number of seats to be set
	 */
	public void setAvailSeat(int availSeat) { this.availSeat = availSeat; }

	/**
	 * Sets the cinema code of the cinema
	 * @param cinemaCode is the cinema code to be set
	 */
	public void setCinemaCode(String cinemaCode) { this.cinemaCode = cinemaCode; }

	/**
	 * Sets the seat map of the cinema
	 * @param seatMap is the seat map to be set
	 */
	public void setSeatMap(Map<Character, List<Seat>> seatMap) { this.seatMap = seatMap; };
}
