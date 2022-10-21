package cineplex.cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import globals.Writable;
import movie.ticket.ITicketAttribute;

@SuppressWarnings("serial")
public class Cinema extends Writable implements ITicketAttribute {
	private double multiplier = 1.0;
	private int availSeat;
	private String cinemaCode;
	private Map<Character, List<Seat>> seatMap;
	
	public Cinema() { }
	public Cinema(String cinemaCode) {
		availSeat = 24;
		this.cinemaCode = cinemaCode;
		seatMap = new HashMap<>();
		
		for (char row : new char[] {'A', 'B', 'C'}) {
			ArrayList<Seat> temp = new ArrayList<>();
			for (int col=1; col<=8; col++)
				temp.add(new Seat(String.format("%c%d", row, col)));
			seatMap.put(row, temp);
		}
	}
	
	public boolean isFull() {
		return availSeat == 0;
	}
	
	public Seat bookSeat(char row, int col) {
		Seat seat = seatMap.get(row).get(col);

		if (seat.isOccupied())
			return null;
		
		availSeat--;
		seat.setOccupied(true);
		return seat;
	}
	
	public void displaySeatingLayout() {
		
	}
	
	
	@Override
	public double getMultiplier() { return multiplier; }
	public int getAvailSeat() { return availSeat; }
	public String getCinemaCode() { return cinemaCode; }
	
	@Override
	public void setMultiplier(double multiplier) { this.multiplier = multiplier; }
	public void setAvailSeat(int availSeat) { this.availSeat = availSeat; }
	public void setCinemaCode(String cinemaCode) { this.cinemaCode = cinemaCode; }
	public void setSeatMap(Map<Character, List<Seat>> seatMap) { this.seatMap = seatMap; };
}
