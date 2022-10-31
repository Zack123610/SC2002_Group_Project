package movie.showtime;

import cineplex.Cineplex;
import cineplex.cinema.Cinema;
import globals.Writable;
import movie.Movie;

public class Showtime extends Writable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 134314070495203459L;
	private Day day;
	private Movie movie;
	private Cinema cinema;
	private Cineplex cineplex;

	public Showtime() {
	}

	public Showtime(Day day, Movie movie, Cinema cinema, Cineplex cineplex) {
		this.day = day;
		this.movie = movie;
		this.cinema = cinema;
		this.cineplex = cineplex;
	}

	// Getters
	public Day getDay() {
		return day;
	}

	public Movie getMovie() {
		return movie;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public Cineplex getCineplex() {
		return cineplex;
	}

	// Setters
	public void setDay(Day day) {
		this.day = day;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public void setCineplex(Cineplex cineplex) {
		this.cineplex = cineplex;
	}
}
