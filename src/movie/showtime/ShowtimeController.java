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
	
	public ShowtimeController() {
		showtimes = FileController.read(System.getProperty("user.dir") + "\\data\\showtime\\");
		for (Showtime showtime : showtimes)
			hm.put(showtime.getID(), showtime);
	}
	
	public void init() {
		for (Showtime showtime : showtimes) {
			showtime.setCinema(MOBLIMA.cinemaController.getCinemaByID(showtime.getCinema().getID()));
			showtime.setMovie(MOBLIMA.movieController.getMovieByID(showtime.getMovie().getID()));
			showtime.setCineplex(MOBLIMA.cineplexController.getCineplexByID(showtime.getCineplex().getID()));
		}
		System.out.println("Showtime Controller initialised successfully!");
	}
	
	public void exit() {
		FileController.write(showtimes, System.getProperty("user.dir") + "\\data\\cinema\\");
		System.out.println("Showtime Controller exited successfully!");
	}
	
	public Showtime getShowtimeByID(UUID id) {
		return hm.containsKey(id) ? hm.get(id) : null;
	}
}
