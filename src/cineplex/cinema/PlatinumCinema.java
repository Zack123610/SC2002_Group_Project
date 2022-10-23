package cineplex.cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class PlatinumCinema extends Cinema {
	public PlatinumCinema(String cinemaCode) {
		super.setCinemaCode(cinemaCode);
		super.setAvailSeat(10);
		
		Map<Character, List<Seat>> seatMap = new HashMap<>();
		
		for (char row : new char[] {'A', 'B'}) {
			ArrayList<Seat> temp = new ArrayList<>();
			for (int col=1; col<=5; col++)
				temp.add(new Seat(String.format("%c%d", row, col),cinemaCode));
			seatMap.put(row, temp);
		}
		
		super.setSeatMap(seatMap);
	}
	
	
	@Override
	public void displaySeatingLayout() {
		
	};
}
