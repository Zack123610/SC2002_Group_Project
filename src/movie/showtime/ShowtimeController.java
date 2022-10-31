package movie.showtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import input.FileController;
import main.MOBLIMA;
import movie.Movie;
import cineplex.Cineplex;
import cineplex.cinema.Cinema;


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

	public ArrayList<Showtime> filter(Movie movie, Cineplex cineplex) {
		ArrayList<Showtime> arr = new ArrayList<>();
		int i =1;
		System.out.println("Available Showtimes");
		for (Showtime showtime : showtimes) {
			if (showtime.getMovie() == movie && showtime.getCineplex() == cineplex) {
				System.out.println(i + ") " + showtime.getDay().toString());
				arr.add(showtime);
				i++;
			}
		}
		return arr;
	}
	public ArrayList<Cineplex> filterCineplexByMovie(Movie movie){
		int i =1;
		ArrayList<Cineplex> list = new ArrayList<>();
		System.out.println("Available Cineplexes: ");
		HashMap <Cineplex, Boolean> hm = new HashMap<>();
		for(Showtime showtime : showtimes){
			if(showtime.getMovie() == movie){
				Cineplex c = showtime.getCineplex();
				if(!hm.containsKey(c)){
					System.out.println(i + ") " + c.getName() );
					list.add(c);
					hm.put(c, true);
					i++;
				}
			}
		}
		System.out.println("done filtering");
		return list;
	}
	public Showtime selectShowtime(ArrayList<Showtime>list){
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		return list.get(choice-1);
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
	public Cinema getCinema(Showtime showtime){
		return showtime.getCinema();
	}


}
