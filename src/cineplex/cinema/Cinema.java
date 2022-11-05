package cineplex.cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The Cinema class is a model class that stores cinema data.
 * @author Tan Say Hong
 *
 */
public class Cinema extends AbstractCinema {
<<<<<<< HEAD

	private static final long serialVersionUID = -202636338839913176L;
	
=======
	/**
	 * 
	 */
	private static final long serialVersionUID = -202636338839913176L;
	
//	private static double multiplier = 1.0;
//	private int availSeat;
//	private String cinemaCode;
//	private Map<Character, List<Seat>> seatMap;
	
>>>>>>> master
	public Cinema() { }
	public Cinema(String cinemaCode) {
		super.setCinemaCode(cinemaCode);
		availSeat = totalSeats = 24;
		seatMap = new HashMap<>();
		
		for (char row : new char[] {'A', 'B', 'C'}) {
			ArrayList<Seat> temp = new ArrayList<>();
			for (int col=1; col<=8; col++)
				temp.add(new Seat(String.format("%c%d", row, col), cinemaCode));
			seatMap.put(row, temp);
		}
		
		super.setSeatMap(seatMap);
	}
	
	@Override
	public AbstractCinema cloneCinema() { return new Cinema(getCinemaCode()); }
<<<<<<< HEAD
=======

//	public boolean isFull() { return availSeat == 0; }
//	
//	public Seat selectSeat(char row, int col) {
//		Seat seat = null;
//		
//		try {
//			seat = seatMap.get(row).get(col);
//			
//			if (seat.isOccupied())
//				throw new SeatBookingException("Error. This seat is already occupied!");
//			
//		} catch (NullPointerException | IndexOutOfBoundsException e) {
//			System.out.println("Error. Invalid seat selection.");
//			return null;
//		} catch (SeatBookingException e) {
//			System.out.println(e.getMessage());
//			return null;
//		}
//		
//		return seat;
//	}
//	
//	public void bookSeat(Seat seat) {
//		availSeat--;
//		seat.setOccupied(true);
//	}
//	
//	public void clearSeat(Seat seat) {
//		availSeat++;
//		seat.setOccupied(false);
//	}
>>>>>>> master
	
	@Override
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
	public double getMultiplier() { return 1.0; }
<<<<<<< HEAD
=======
	
	
	
	
//	public boolean equals(Cinema other) {
//		return this.getCinemaCode().equals(other.getCinemaCode());
//	}

//	@Override
//	public double getMultiplier() { return multiplier; }
//	public int getAvailSeat() { return availSeat; }
//	public String getCinemaCode() { return cinemaCode; }
//	public Map<Character, List<Seat>> getSeatMap() { return this.seatMap; };
	
//	@Override
//	public void setMultiplier(double multiplier) { Cinema.multiplier = multiplier; }
//	public void setAvailSeat(int availSeat) { this.availSeat = availSeat; }
//	public void setCinemaCode(String cinemaCode) { this.cinemaCode = cinemaCode; }
//	public void setSeatMap(Map<Character, List<Seat>> seatMap) { this.seatMap = seatMap; };
>>>>>>> master
}
