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

	private static final long serialVersionUID = -202636338839913176L;
	
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
}
