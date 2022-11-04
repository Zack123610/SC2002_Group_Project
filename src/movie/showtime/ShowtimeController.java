package movie.showtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import cineplex.Cineplex;
import input.FileController;
import input.IntegerHandler;
import input.StringHandler;
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
		System.out.println("Showtime Controller initialised successfully!");
	}
	public void exit() {
		FileController.write(showtimes, "./data/showtime/");
		System.out.println("Showtime Controller exited successfully!");
	}
	public Showtime getShowtimeByID(UUID id) {
		return hm.containsKey(id) ? hm.get(id) : null;
	}
	
	
	// Controller methods
	public void displayShowtimes(List<Showtime> list) {
		System.out.println("--- Display Showtimes ---");
		for (int i=0; i<list.size(); i++)
			System.out.printf("%d) %s\n", i+1, list.get(i).toString());
	}//add cineplex change the toString in showtime
	
	public Showtime selectShowtime(List<Showtime> list) {
		displayShowtimes(list);
		
		if (list.size() == 0) {
			System.out.println("No showtimes available.");
			return null;
		}
		
		System.out.print("Please select a showtime (0 to cancel): ");
		int idx = IntegerHandler.readInt(list.size());
		return idx == 0 ? null : list.get(idx-1);
	}
	
//	public Showtime selectShowtime() {
//		displayAllShowtimes();
//		
//		if (showtimes.size() == 0) {
//			System.out.println("No showtimes available.");
//			return null;
//		}
//		
//		System.out.print("Please select a showtime (0 to cancel): ");
//		int idx = IntegerHandler.readInt(showtimes.size());
//		return idx == 0 ? null : showtimes.get(idx-1);
//	}

	public void updateShowtime() {
		Showtime curr = selectShowtime(showtimes);
		
		if (curr == null)
			return;
		
		// ToDo: Add update code. Allow updating of movie only for now.
		System.out.println("To update showtime here");
	}
	
	public void createShowtime() {
		// ToDo: Add create code. 
		System.out.println("To create showtime here");
	}

	public void deleteShowtime() {
		Showtime curr = selectShowtime(showtimes);
		
		if (curr == null)
			return;
		
		System.out.println(curr.toString());
		System.out.print("You are about to delete this showtime. Please confirm (Y/N): ");
		
		if (StringHandler.readString("Y", "N").equals("N"))
			return;
		
		System.out.println("To delete showtime here");
		//showtimes.remove(curr);
		//FileController.delete("./data/showtime/" + curr.getFilename());
	}
	
	public List<Showtime> filterShowtimeByMovieAndCineplex(Movie movie, Cineplex cineplex) {
//		ArrayList<Showtime> arr = new ArrayList<>();
//		int i =1;
//		System.out.println("Available Showtimes");
//		for (Showtime showtime : showtimes) {
//			if (showtime.getMovie() == movie && showtime.getCineplex() == cineplex) {
//				System.out.println(i + ") " + showtime.getDay().toString());
//				arr.add(showtime);
//				i++;
//			}
//		}
		
		return showtimes
				.stream()
				.filter(s -> s.getMovie() == movie && s.getCineplex() == cineplex)
				.collect(Collectors.toList());
	}
	public List<Showtime> filterShowtimeByMovie(Movie movie) {
		//		ArrayList<Showtime> arr = new ArrayList<>();
		//		int i =1;
		//		System.out.println("Available Showtimes");
		//		for (Showtime showtime : showtimes) {
		//			if (showtime.getMovie() == movie && showtime.getCineplex() == cineplex) {
		//				System.out.println(i + ") " + showtime.getDay().toString());
		//				arr.add(showtime);
		//				i++;
		//			}
		//		}
		//remove cineplex parameter
				
				return showtimes
						.stream()
						.filter(s -> s.getMovie() == movie )
						.collect(Collectors.toList());
			}
	
	public ArrayList<Cineplex> filterCineplexByMovie(Movie movie) {
		
		HashSet<Cineplex> availableCineplexes = new HashSet<>();
		showtimes.stream()
		.filter(s -> s.getMovie() == movie)
		.forEach(s -> availableCineplexes.add(s.getCineplex()));
		
//		int i = 1;
//		ArrayList<Cineplex> list = new ArrayList<>();
//		System.out.println("Available Cineplexes: ");
//		HashMap <Cineplex, Boolean> hm = new HashMap<>();
//		for(Showtime showtime : showtimes){
//			if(showtime.getMovie() == movie){
//				Cineplex c = showtime.getCineplex();
//				if(!hm.containsKey(c)){
//					System.out.println(i + ") " + c.getName() );
//					list.add(c);
//					hm.put(c, true);
//					i++;
//				}
//			}
//		}
		
		return new ArrayList<>(availableCineplexes);
	}

	public int getUniqueDates(ArrayList<Showtime> list) {
		int size = 0;
		Day day = list.get(0).getDay();
		for (Showtime showtime : list) {
			if (showtime.getDay() != day) {
				day = showtime.getDay();
				size += 1;
			}
		}
		return size;
	}

}
