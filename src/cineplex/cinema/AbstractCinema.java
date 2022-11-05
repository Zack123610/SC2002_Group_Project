package cineplex.cinema;

import java.util.List;
import java.util.Map;
<<<<<<< HEAD
import java.util.Objects;

import input.Writable;
import movie.ticket.IGetTicketAttribute;

public abstract class AbstractCinema extends Writable implements IGetTicketAttribute {

=======

import globals.SeatBookingException;
import globals.Writable;
import movie.ticket.IGetTicketAttribute;

public abstract class AbstractCinema extends Writable implements IGetTicketAttribute {
	/**
	 * 
	 */
>>>>>>> master
	private static final long serialVersionUID = -5782367057189056125L;
	protected int availSeat, totalSeats;
	protected String cinemaCode;
	protected Map<Character, List<Seat>> seatMap;
	
	public boolean isFull() { return availSeat == 0; }
	public boolean isEmpty() { return availSeat == totalSeats; }
	
	public abstract void displaySeatingLayout();
	public abstract AbstractCinema cloneCinema();
	
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
	
	public void bookSeat(Seat seat) {
		availSeat--;
		seat.setOccupied(true);
	}
	
	public void clearSeat(Seat seat) {
		availSeat++;
		seat.setOccupied(false);
	}
	
<<<<<<< HEAD
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
=======
	// Compare whether two cinemas objects are referring to the same room 
	public boolean equals(AbstractCinema other) {
		return this.getCinemaCode().equals(other.getCinemaCode());
	}

>>>>>>> master
	public int getAvailSeat() { return availSeat; }
	public int getTotalSeats() { return totalSeats; }
	public String getCinemaCode() { return cinemaCode; }
	public Map<Character, List<Seat>> getSeatMap() { return this.seatMap; };
	
<<<<<<< HEAD
	// Setters
=======
>>>>>>> master
	public void setTotalSeats(int total) { totalSeats = total; }
	public void setAvailSeat(int availSeat) { this.availSeat = availSeat; }
	public void setCinemaCode(String cinemaCode) { this.cinemaCode = cinemaCode; }
	public void setSeatMap(Map<Character, List<Seat>> seatMap) { this.seatMap = seatMap; };
}
