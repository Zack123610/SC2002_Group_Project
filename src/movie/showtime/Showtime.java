package movie.showtime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cineplex.Cineplex;
import cineplex.cinema.AbstractCinema;
import cineplex.cinema.Cinema;
import globals.Writable;
import input.FileController;
import movie.Movie;

public class Showtime extends Writable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 134314070495203459L;
	private Day day;
	private UUID movieID, cinemaID, cineplexID;
	private Movie movie;
	private AbstractCinema cinema;
	private Cineplex cineplex;
	
	public Showtime() { }
	public Showtime(Day day, Movie movie, Cinema cinema, Cineplex cineplex) {
		this.day = day;
		this.movie = movie;
		this.movieID = movie.getID();
		this.cinema = cinema;
		this.cinemaID = cinema.getID();
		this.cineplex = cineplex;
		this.cineplexID = cineplex.getID();
	}
	
	// Getters
	public Day getDay() { return day; }
	public UUID getMovieID() { return movieID; }
	public UUID getCinemaID() { return cinemaID; }
	public UUID getCineplexID() { return cineplexID; }
	public Movie getMovie() { return movie; }
	public AbstractCinema getCinema() { return cinema; }
	public Cineplex getCineplex() { return cineplex; }
	
	// Setters
	public void setDay(Day day) { this.day = day; }
	public void setMovieID(UUID movieID) { this.movieID = movieID; }
	public void setCinemaID(UUID cinemaID) { this.cinemaID = cinemaID; }
	public void setCineplexID(UUID cineplexID) { this.cineplexID = cineplexID; }
	public void setMovie(Movie movie) { this.movieID = movie.getID(); this.movie = movie; }
	public void setCinema(AbstractCinema cinema) { this.cinemaID = cinema.getID(); this.cinema = cinema; }
	public void setCineplex(Cineplex cineplex) { this.cineplex = cineplex; }
	
	
//	public static void main(String[] args) {
//		String filepath = System.getProperty("user.dir") + "\\data\\init\\showtimes\\";
//		Showtime showtime;
//		List<Showtime> toSer = new ArrayList<>();
//		
//		
//		try {			
//			File[] files = new File(filepath).listFiles();
//			
//			for (File file : files) {
//				FileReader frStream = new FileReader(file);
//				BufferedReader brStream = new BufferedReader(frStream);
//	
//				showtime = new Showtime();
//				
//				LocalDate date = LocalDate.parse(brStream.readLine());
//				LocalTime time = LocalTime.parse(brStream.readLine());
//				Day day = new Day(date, time);
//				showtime.setDay(day);
//				
//				showtime.setMovieID(UUID.fromString(brStream.readLine()));
//				showtime.setCineplexID(UUID.fromString(brStream.readLine()));
//				showtime.setCinemaID(UUID.fromString(brStream.readLine()));
//				
//				toSer.add(showtime);
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found");
//		} catch (IOException e) {
//			System.out.println("Error initializing stream");
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("An error has occured");
//		}
//		
//		for (var element: toSer) 
//			System.out.printf("Showtime: %-15s | ID: %s\n", element.day.toString(), element.getID().toString());
//	
//		FileController.write(toSer, System.getProperty("user.dir") + "\\data\\showtime\\");
//	}
}
