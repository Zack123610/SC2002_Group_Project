package cineplex.cinema;

import java.util.List;
import java.util.Map;

import globals.SeatBookingException;
import globals.Writable;
import movie.ticket.ITicketAttribute;

public abstract class AbstractCinema extends Writable implements ITicketAttribute {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7277416626176980489L;
	private double multiplier = 1.0;
	private int availSeat;
	private String cinemaCode;
	private Map<Character, List<Seat>> seatMap;
	
	public boolean isFull() { return availSeat == 0; }
	
	public Seat bookSeat(char row, int col) {
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
		
		availSeat--;
		seat.setOccupied(true);
		return seat;
	}
	
	public Seat clearSeat(char row, int col) {
		Seat seat = null;
		
		try {
			seat = seatMap.get(row).get(col);
			
			if (!seat.isOccupied())
				throw new SeatBookingException("Error. This seat is already empty!");
			
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			System.out.println("Error. Invalid seat selection.");
			return null;
		} catch (SeatBookingException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		availSeat++;
		seat.setOccupied(false);
		return seat;
	}
	
	public abstract void displaySeatingLayout();
	
	
	@Override
	public double getMultiplier() { return multiplier; }
	public int getAvailSeat() { return availSeat; }
	public String getCinemaCode() { return cinemaCode; }
	public Map<Character, List<Seat>> getSeatMap() { return this.seatMap; };
	
	@Override
	public void setMultiplier(double multiplier) { this.multiplier = multiplier; }
	public void setAvailSeat(int availSeat) { this.availSeat = availSeat; }
	public void setCinemaCode(String cinemaCode) { this.cinemaCode = cinemaCode; }
	public void setSeatMap(Map<Character, List<Seat>> seatMap) { this.seatMap = seatMap; };
}
