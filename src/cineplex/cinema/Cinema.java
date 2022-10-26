package cineplex.cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import globals.SeatBookingException;
import globals.Writable;
import movie.ticket.ITicketAttribute;


public class Cinema extends Writable implements ITicketAttribute {
	/**
	 * 
	 */
	private static final long serialVersionUID = -202636338839913176L;
	
	private static double multiplier = 1.0;
	private int availSeat;
	private String cinemaCode;
	private Map<Character, List<Seat>> seatMap;
	
	public Cinema() {}
	public Cinema(String cinemaCode) {
		availSeat = 24;
		this.cinemaCode = cinemaCode;
		seatMap = new HashMap<>();
		
		for (char row : new char[] {'A', 'B', 'C'}) {
			ArrayList<Seat> temp = new ArrayList<>();
			for (int col=1; col<=8; col++)
				temp.add(new Seat(String.format("%c%d", row, col), cinemaCode));
			seatMap.put(row, temp);
		}
	}
	
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
	
	public void displaySeatingLayout() {
		System.out.println(
				"|             SCREEN             |\n" +
				"|________________________________|\n\n" +
				"     1  2  3  4    5  6  7  8    ");
		
		for (char row : seatMap.keySet()) {
			List<Seat> seats = seatMap.get(row);
			int cnt = 0;
			System.out.print(row + "   ");
			
			for (Seat seat : seats) {
				System.out.print("|" + (seat.isOccupied() ? "X" : "O") + "|");
				if (++cnt == 4)
					System.out.print("  ");
			}
			System.out.print("   " + row + "\n");
		}
		
		System.out.println(
				"            __________             \n" +
				"            |ENTRANCE|             \n");
	}
	
	// Compare whether two cinemas objects are referring to the same room 
	public boolean equals(Cinema other) {
		return this.getCinemaCode().equals(other.getCinemaCode());
	}

	@Override
	public double getMultiplier() { return multiplier; }
	public int getAvailSeat() { return availSeat; }
	public String getCinemaCode() { return cinemaCode; }
	public Map<Character, List<Seat>> getSeatMap() { return this.seatMap; };
	
	@Override
	public void setMultiplier(double multiplier) { Cinema.multiplier = multiplier; }
	public void setAvailSeat(int availSeat) { this.availSeat = availSeat; }
	public void setCinemaCode(String cinemaCode) { this.cinemaCode = cinemaCode; }
	public void setSeatMap(Map<Character, List<Seat>> seatMap) { this.seatMap = seatMap; };
}
