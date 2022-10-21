package movie.showtime;

import cineplex.Cineplex;
import cineplex.cinema.Cinema;
import globals.Writable;
import movie.Movie;

@SuppressWarnings("serial")
public class Showtime extends Writable {
	private Day day;
	private Movie movie;
	private Cinema cinema;
	private Cineplex cineplex;
	
	
	public Day getDay() { return day; }
	public Movie getMovie() { return movie; }
	public Cinema getCinema() { return cinema; }
	public Cineplex getCineplex() { return cineplex; }
	
	public void setDay(Day day) { this.day = day; }
	public void setMovie(Movie movie) { this.movie = movie; }
	public void setCinema(Cinema cinema) { this.cinema = cinema; }
	public void setCineplex(Cineplex cineplex) { this.cineplex = cineplex; }
	
}
