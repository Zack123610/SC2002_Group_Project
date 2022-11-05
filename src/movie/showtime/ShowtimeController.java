package movie.showtime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import cineplex.Cineplex;
import cineplex.cinema.AbstractCinema;
import input.FileController;
import input.NumberHandler;
import input.StringHandler;
import main.IShowtimeController;
import main.MOBLIMA;
import movie.Movie;

public class ShowtimeController implements IShowtimeController {
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
	}
	public void exit() {
		FileController.write(showtimes, "./data/showtime/");
	}
	public Showtime getShowtimeByID(UUID id) {
		return hm.containsKey(id) ? hm.get(id) : null;
	}
	
	
	public void displayShowtimes(List<Showtime> list) {
		System.out.println("--- Display Showtimes ---");
		if (list.size() == 0) {
			System.out.println("No Showtimes Available.");
			return;
		}
		for (int i=0; i<list.size(); i++)
			System.out.printf("%d) %s\n", i+1, list.get(i).toString());
	}
	
	public Showtime selectShowtime(List<Showtime> list) {
		displayShowtimes(list);
		
		if (list.size() == 0) 
			return null;

		System.out.print("Please select a showtime (0 to cancel): ");
		int idx = NumberHandler.readInt(list.size());
		return idx == 0 ? null : list.get(idx-1);
	}

<<<<<<< HEAD
	public void updateShowtime() {		
		List<Showtime> availToBeUpdated = showtimes
				.stream()
				.filter(s -> s.getCinema().isEmpty())
				.collect(Collectors.toList());
		
		Showtime oldShowtime = selectShowtime(availToBeUpdated), newShowtime;
		if (oldShowtime == null)
			return;
		if ((newShowtime = create()) == null) 
			return;
		
		System.out.println(newShowtime.toString());
		System.out.print("You are about to update this showtime. Please confirm (Y/N): ");
		if (StringHandler.readString("Y", "N").equals("Y")) {
			showtimes.add(newShowtime);
			delete(oldShowtime);
		}
=======
	public void updateShowtime() {
		Showtime curr = selectShowtime(showtimes);
		if (curr == null)
			return;
		
		// ToDo: Add update code. Only showtimes with empty cinemas can be updated
		System.out.println("To update showtime here");
>>>>>>> master
	}
	
	public void createShowtime() {
		Showtime showtime = create();
		if (showtime == null)
			return;
		
		System.out.println(showtime.getMovie().toString());
		System.out.println(showtime.toString());
		System.out.print("Please confirm creation of new showtime (Y/N): ");
		if (StringHandler.readString("Y", "N").equals("Y")) {
			showtimes.add(showtime);
			System.out.println("New showtime successfully created.");
		} else 
			System.out.println("Cancelled creation of new showtime.");
	}
	
	enum CreateState { SELECT_DATE, SELECT_CINEPLEX, SELECT_TIME, FILTER_TIME, SELECT_CINEMA, SELECT_MOVIE, FINISH }
	
	private Showtime create() {
		boolean done = false;
		CreateState state = CreateState.SELECT_DATE;
		LocalTime[] timeslots = {
				LocalTime.of(0, 0), LocalTime.of(3, 0), LocalTime.of(6, 0), LocalTime.of(9, 0),
				LocalTime.of(12, 0), LocalTime.of(15, 0), LocalTime.of(18, 0), LocalTime.of(21, 0)};
		
		Cineplex cineplex = null;
		LocalDate date = null;
		LocalTime time = null;
		Day day = null;
		HashSet<AbstractCinema> avail = null;
		AbstractCinema cinema = null;
		Movie movie = null;
		Showtime result = null;
		int idx;
		
		while (!done) 
			switch (state) {
			case SELECT_DATE:
				date = getDateAfterToday();
				state = (date == null) 
						? CreateState.FINISH
						: CreateState.SELECT_CINEPLEX;
				break;
				
			case SELECT_CINEPLEX:
				cineplex = MOBLIMA.cineplexController.selectCineplex();
				if (cineplex == null) {
					System.out.println("You have cancelled the selection. Going back...");
					state = CreateState.SELECT_DATE;
					break;
				}
				
			case SELECT_TIME:
				for (int i=0; i<timeslots.length; i++) 
					System.out.printf("%d) %s\n", i+1, timeslots[i].toString());
				System.out.print("Please select a timeslot (0 to cancel): ");
				idx = NumberHandler.readInt(8);
				
				time = (idx == 0) ? null : timeslots[idx-1];
				state = (time == null) 
						? CreateState.SELECT_CINEPLEX 
						: CreateState.FILTER_TIME;
				break;
				
			case FILTER_TIME:
				day = new Day(date, time);
				avail = new HashSet<AbstractCinema>(cineplex.getCinemaList());
				
				for (Showtime showtime : showtimes) 
					if (showtime.getCineplex() == cineplex && showtime.getDay().equals(day)) 
						avail.remove(showtime.getCinema());
				
				if (avail.size() == 0) 
					System.out.println("No empty cinemas available at this time. Going back...");
				
				state = avail.size() == 0
						? CreateState.SELECT_TIME
						: CreateState.SELECT_CINEMA;
				break;
				
			case SELECT_CINEMA:
				cinema = MOBLIMA.cinemaController.selectCinema(new ArrayList<>(avail));
				
				state = (cinema == null)
						? CreateState.SELECT_TIME
						: CreateState.SELECT_MOVIE;
				break;
				
			case SELECT_MOVIE:
				movie = MOBLIMA.movieController.selectMovie(6);
				if (movie != null) 
					result = new Showtime(day, movie, cinema.cloneCinema(), cineplex);
				
				state = (movie == null)
						? CreateState.SELECT_CINEMA
						: CreateState.FINISH;
				break;
				
			case FINISH:
				done = true;
			}
		return result;
	}
	
	private LocalDate getDateAfterToday() {
		boolean done = false;
		LocalDate date = null;
		String text;
		do {
			try {
				System.out.print("Enter date for new showtime (DD/MM/YYYY) or 'C' to cancel: ");
				if ((text = StringHandler.readString()).equals("C"))
					return null;
				
				date = LocalDate.parse(text, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				if (!date.isAfter(LocalDate.now())) {
					System.out.println("Date entered must be after today.");
				} else
					done = true;
			} catch (DateTimeParseException e) {
				System.out.println("Error. Invalid date format. Try again.");
			}
		} while (!done);
		
		return date;
	}
	
	/**
	 * Method to delete the showtime by removing from the showtimes list,
	 * and deleting it from the data folder.
	 * This method is called internally after admin confirms to delete showtime. 
	 * @param showtime the {@code Showtime} object to be deleted.
	 */
	private void delete(Showtime showtime) {
		showtimes.remove(showtime);
		FileController.delete("./data/showtime/" + showtime.getFilename());
	}
	public void deleteShowtime() {
		Showtime curr = selectShowtime(showtimes);
		
		if (curr == null)
			return;
		
		System.out.println(curr.toString());
		System.out.print("You are about to delete this showtime. Please confirm (Y/N): ");
		
		if (StringHandler.readString("Y", "N").equals("N"))
			return;
		
		delete(curr);
	}
	
	public List<Showtime> filterShowtimeByMovieAndCineplex(Movie movie, Cineplex cineplex) {		
		return showtimes
				.stream()
				.filter(s -> s.getMovie() == movie && s.getCineplex() == cineplex && !s.getCinema().isFull())
<<<<<<< HEAD
				.collect(Collectors.toList());
	}
	
	public List<Showtime> filterShowtimeByMovie(Movie movie) {		
		return showtimes
				.stream()
				.filter(s -> s.getMovie() == movie)
				.collect(Collectors.toList());
	}
	
	public List<Cineplex> filterCineplexByMovie(Movie movie) {
=======
				.collect(Collectors.toList());
	}
	
	public List<Showtime> filterShowtimeByMovie(Movie movie) {		
		return showtimes
				.stream()
				.filter(s -> s.getMovie() == movie)
				.collect(Collectors.toList());
	}
	
	public ArrayList<Cineplex> filterCineplexByMovie(Movie movie) {
>>>>>>> master
		HashSet<Cineplex> availableCineplexes = new HashSet<>();
		showtimes.stream()
			.filter(s -> s.getMovie() == movie)
			.forEach(s -> availableCineplexes.add(s.getCineplex()));
		
		return new ArrayList<>(availableCineplexes);
	}

<<<<<<< HEAD
=======

	
>>>>>>> master
}

