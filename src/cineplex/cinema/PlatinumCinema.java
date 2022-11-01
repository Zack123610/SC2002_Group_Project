package cineplex.cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlatinumCinema extends Cinema {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3292482853076350312L;
	private static double multiplier = 1.5;

	public PlatinumCinema(String cinemaCode) {
		super.setCinemaCode(cinemaCode);
		super.setAvailSeat(10);
		
		Map<Character, List<Seat>> seatMap = new HashMap<>();
		
		for (char row : new char[] {'A', 'B'}) {
			ArrayList<Seat> temp = new ArrayList<>();
			for (int col=1; col<=5; col++)
				temp.add(new Seat(String.format("%c%d", row, col), cinemaCode));
			seatMap.put(row, temp);
		}
		
		super.setSeatMap(seatMap);
	}
	
	
	@Override
	public void displaySeatingLayout() {
		System.out.println(
				"|             SCREEN             |\n" +
				"|________________________________|\n\n" +
				"     1     2     3     4     5   ");
		
		for (char row : super.getSeatMap().keySet()) {
			List<Seat> seats = super.getSeatMap().get(row);
			System.out.print(" " + row + " ");
			
			for (Seat seat : seats) 
				System.out.print("| " + (seat.isOccupied() ? "X" : "O") + " | ");
			System.out.print(row + "\n");
		}
		
		System.out.println(
				"            __________           \n" +
				"            |ENTRANCE|           \n");
	}
	
	@Override
	public double getMultiplier() { return multiplier; }
	
	@Override
	public void setMultiplier(double multiplier) { PlatinumCinema.multiplier = multiplier; }
}
