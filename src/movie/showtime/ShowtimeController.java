package movie.showtime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import input.FileController;
import main.MOBLIMA;

public class ShowtimeController {
	private List<Showtime> showtimes;
	private Map<UUID, Showtime> hm = new HashMap<>();
	
	// Initialisation Code
	public ShowtimeController() {
		showtimes = FileController.read("./data/showtime/");
		for (Showtime showtime : showtimes)
			hm.put(showtime.getID(), showtime);
	}
	public void init() {
		for (Showtime showtime : showtimes) {
			showtime.setMovie(MOBLIMA.movieController.getMovieByID(showtime.getMovie().getID()));
			showtime.setCineplex(MOBLIMA.cineplexController.getCineplexByID(showtime.getCineplex().getID()));
		}
		System.out.println("Showtime Controller initialised successfully!");
	}
	public void exit() {
		FileController.write(showtimes, "./data/showtime/");
		System.out.println("Showtime Controller exited successfully!");
	}
	public Showtime getShowtimeByID(UUID id) {
		return hm.containsKey(id) ? hm.get(id) : null;
	}
	
	
	
	
	
	
	
	
}
