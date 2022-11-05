package cineplex.cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import movie.ticket.ITicketAttribute;

/**
 * The PlatinumCinema class is a model class which is a child class of {@code AbstractCinema} that stores cinema data.
 */
public class PlatinumCinema extends AbstractCinema implements ITicketAttribute {

	/**
	 * A static final UUID for PlatiniumCinema objects
	 */
	private static final long serialVersionUID = 3292482853076350312L;

	/**
	 * The multiplier for PlatinumCinemas default value =1.5
	 */
	private static double multiplier = 1.5;
	
	/**
	 * Constructor for {@code PlatiniumCinema}
	 * @param cinemaCode is the  cinema code of the Platinium Cinema to be created
	 */
	public PlatinumCinema(String cinemaCode) {
		super.setCinemaCode(cinemaCode);
		totalSeats = availSeat = 10;
		
		Map<Character, List<Seat>> seatMap = new HashMap<>();
		
		for (char row : new char[] {'A', 'B'}) {
			ArrayList<Seat> temp = new ArrayList<>();
			for (int col=1; col<=5; col++)
				temp.add(new Seat(String.format("%c%d", row, col), cinemaCode));
			seatMap.put(row, temp);
		}
		
		super.setSeatMap(seatMap);
	}
	
	/**
	 * Overrides the cloneCinema method in {@code AbstractCinema}
	 * @return a new PlatiniumCinema
	 */
	@Override
	public AbstractCinema cloneCinema() {
		return new PlatinumCinema(cinemaCode);
	}
	
	/**
	 * Overrides the displaySeatingLayout in {@code AbstractCinema}
	 * Displays the layout of {@code PlatiniumCinema}
	 */
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
	
	/**
	 * Overrides the getMultiplier of {@code AbstractCinema}
	 * @return the multiplier of the cinema
	 */
	@Override
	public double getMultiplier() { return multiplier; }
	
	/**
	 * Overrides the setMultiplier of {@code ITicketAttribute}
	 * Sets the multiplier of the {@code PlatiniumCinema}
	 * @param multiplier is the input new multiplier to be set
	 */
	@Override
	public void setMultiplier(double multiplier) { PlatinumCinema.multiplier = multiplier; }
}
