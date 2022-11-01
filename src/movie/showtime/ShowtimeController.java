package movie.showtime;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cineplex.Cineplex;
import input.FileController;
import main.MOBLIMA;
import movie.Movie;

public class ShowtimeController {
	private List<Showtime> showtimes;
	private Map<UUID, Showtime> hm = new HashMap<>();
	private List<LocalTime> timeslots = new ArrayList<LocalTime>();
	
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

	public List<Showtime> getShowtimeByMovie(Movie movie) {
		// Search through showtimes and return a list of Showtime 
		return null;
	}

	public List<Showtime> filterAvailableShowtimes(Movie movie, Cineplex cineplex) {
		

		return null;
	}
	
	public void createShowtime() {
		// Request input for date
		// Request input for cineplex (Cineplex controller)

		// Display list of available timeslots (with no of available cinemas)

		// Request input for time
		// Request input for cinema

		// Create day object

		// Request input for cinema (Cinema controller)

		// Create showtime object
		// Add showtime to showtimes
	}
	
	// Display list of available timeslots (with no of available cinemas)
	private List<Showtime> availableTimeslots(Cineplex cineplex) {
		return null;
	}
	
	
	
	
}
