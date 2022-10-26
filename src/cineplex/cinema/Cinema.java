package cineplex.cinema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import globals.SeatBookingException;
import globals.Writable;
import input.FileController;
import movie.ticket.ITicketAttribute;


public class Cinema extends Writable implements ITicketAttribute {
	/**
	 * 
	 */
	private static final long serialVersionUID = -202636338839913176L;
	
	private double multiplier = 1.0;
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
	
	
	
	

	
//	public static void main(String[] args) {
//		AbstractCinema WM1 = new Cinema("WM1");
//		AbstractCinema WM2 = new Cinema("WM2");
//		AbstractCinema WM3 = new Cinema("WM3");
//		                            
//		AbstractCinema JM1 = new Cinema("JM1");
//		AbstractCinema JM2 = new Cinema("JM2");
//		AbstractCinema JM3 = new PlatinumCinema("JM3");
//		                           
//		AbstractCinema DE1 = new Cinema("DE1");
//		AbstractCinema DE2 = new PlatinumCinema("DE2");
//		AbstractCinema DE3 = new PlatinumCinema("DE3");
//		
//		List<AbstractCinema> toSer = Arrays.asList(WM1, WM2, WM3, JM1, JM2 ,JM3, DE1, DE2, DE3);
//		
//		for (AbstractCinema cinema: toSer)
//			System.out.println("Name: " + cinema.getCinemaCode() + " | ID: " + cinema.getID());
//		
//		FileController.write(toSer, System.getProperty("user.dir") + "\\data\\cinema\\");
//	}
}
