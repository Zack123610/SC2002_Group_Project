package showtime;

import cineplex.cinema.Cinema;
import globals.Writable;
import movie.Movie;

@SuppressWarnings("serial")
public class Showtime extends Writable {
	private Day day;
	private Movie movie;
	public Cinema cinema;
	
	
	public Day getDay() { return day; }
	public Movie getMovie() { return movie; }
	public Cinema getCinema() { return cinema; }
	
	public void setDay(Day day) { this.day = day; }
	public void setMovie(Movie movie) { this.movie = movie; }
	public void setCinema(Cinema cinema) { this.cinema = cinema; }
	public void addshowtime(Day day, Movie movie, Cinema cinema)
	{
		this.setDay(day);
		this.setMovie(movie);
		this.setCinema(cinema);
	}
}
