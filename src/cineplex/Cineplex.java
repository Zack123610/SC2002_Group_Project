package cineplex;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import cineplex.cinema.Cinema;
import globals.Writable;
import input.FileController;
import movie.Movie;
import movie.MovieController;
import movie.showtime.Day;
import movie.showtime.Showtime;


public class Cineplex extends Writable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8543460754888135256L;
	private String name;
	private List<UUID> showTimeIDList; // For showTime IDs
	private List<Showtime> showTimes; // ArrayList for showTime
	
	// To store the cinema codes of the cinemas under this cineplex
	// Used during create showtime to check which available cinemas are available
	private List<String> cinemaCodes; 
	
	// Constructor
	public Cineplex() {}
	public Cineplex(String name) {
		this.name = name;
		showTimes = new ArrayList<>(); //edited
		showTimeIDList = new ArrayList<>(); //added
		cinemaCodes = new ArrayList<>();
	}
	
	// Methods
	public String getName() { return name; }
	public List<UUID> getShowTimeIDList() { return showTimeIDList; }
	public List<Showtime> getShowTimes() { return showTimes; }
	public List<String> getCinemaCodes() { return cinemaCodes; }
	
	public void setShowTimes(List<Showtime> showTimes) { this.showTimes = showTimes; }
	public void setCinemaCodes(List<String> cinemaCodes) { this.cinemaCodes = cinemaCodes; }
	
	public void addShowTime(Showtime showTime) {
		showTimes.add(showTime);
	}
	public void addCinemaCode(String code) {
		cinemaCodes.add(code);
	}
	
//	public static void main(String[] args) {
//		// Create new preload data for cineplex and showtimes
//		
//		MovieController mc = new MovieController();
//		Movie BlackAdam = mc.getMoviebyID(UUID.fromString("423dcfc9-eec2-4994-b4ba-d67377cf3627"));
//		
//		ArrayList<String> cinemaCodes;
//		
//		Cineplex DE = new Cineplex("Downtown East");
//		cinemaCodes = new ArrayList<>();
//		cinemaCodes.add("DE1");
//		cinemaCodes.add("DE2");
//		cinemaCodes.add("DE3");
//		DE.setCinemaCodes(cinemaCodes);
//		
//		Cineplex JM = new Cineplex("JEM");
//		cinemaCodes = new ArrayList<>();
//		cinemaCodes.add("JM1");
//		cinemaCodes.add("JM2");
//		cinemaCodes.add("JM3");
//		JM.setCinemaCodes(cinemaCodes);
//		
//		Cineplex WM = new Cineplex("West Mall");
//		cinemaCodes = new ArrayList<>();
//		cinemaCodes.add("WE1");
//		cinemaCodes.add("WE2");
//		cinemaCodes.add("WE3");
//		WM.setCinemaCodes(cinemaCodes);
//		
//		// Day, Movie, Cinema, Cineplex;
//		Showtime BA1 = new Showtime(
//				new Day(LocalDate.parse("2022-10-29"), LocalTime.parse("18:30")), 
//				BlackAdam,
//				new Cinema("WM1"), WM);
//		
//		Showtime BA2 = new Showtime(
//				new Day(LocalDate.parse("2022-10-29"), LocalTime.parse("20:30")), 
//				BlackAdam,
//				new Cinema("WM1"), WM);
//		
//		Showtime BA3 = new Showtime(
//				new Day(LocalDate.parse("2022-10-28"), LocalTime.parse("18:30")), 
//				BlackAdam,
//				new Cinema("JM1"), JM);
//		
//		Showtime BA4 = new Showtime(
//				new Day(LocalDate.parse("2022-10-28"), LocalTime.parse("18:30")), 
//				BlackAdam,
//				new Cinema("JM3"), JM);
//		
//		Showtime BA5 = new Showtime(
//				new Day(LocalDate.parse("2022-10-29"), LocalTime.parse("18:30")), 
//				BlackAdam,
//				new Cinema("DE2"), DE);
//		
//		Showtime BA6 = new Showtime(
//				new Day(LocalDate.parse("2022-10-24"), LocalTime.parse("18:30")), 
//				BlackAdam,
//				new Cinema("DE2"), DE);
//		
//		List<Showtime> showtimes;
//		
//		showtimes = new ArrayList<>();
//		showtimes.add(BA1);
//		showtimes.add(BA2);
//		WM.setShowTimes(showtimes);
//		
//		showtimes = new ArrayList<>();
//		showtimes.add(BA3);
//		showtimes.add(BA4);
//		JM.setShowTimes(showtimes);
//		
//		showtimes = new ArrayList<>();
//		showtimes.add(BA5);
//		showtimes.add(BA6);
//		DE.setShowTimes(showtimes);
//	
//		// Serialise cineplexes
//		List<Cineplex> cineplexes = Arrays.asList(WM, JM, DE);
//		for (var element: cineplexes)
//			System.out.printf("Name: %-15s | ID: %s\n", element.name, element.getID().toString());
//		FileController.write(cineplexes, "./data/cineplex/");
//		System.out.println();
//		
//		// Serialise showtimes
//		showtimes = Arrays.asList(BA1, BA2, BA3, BA4, BA5, BA6);
//		for (var element: showtimes)
//			System.out.printf("Name: %-15s | ID: %s\n", element.toString(), element.getID().toString());
//		FileController.write(showtimes, "./data/showtime/");
//	}
}
