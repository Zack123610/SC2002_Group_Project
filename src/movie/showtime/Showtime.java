package movie.showtime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cineplex.Cineplex;
<<<<<<< HEAD
import cineplex.cinema.AbstractCinema;
import input.Writable;
=======
import cineplex.CineplexController;
import cineplex.cinema.AbstractCinema;
import globals.Writable;
import input.FileController;
>>>>>>> master
import movie.Movie;
import movie.MovieController;

public class Showtime extends Writable {

	private static final long serialVersionUID = 134314070495203459L;
	private Day day;
	private Movie movie;
	private AbstractCinema cinema;
	private Cineplex cineplex;
	
	public Showtime() { }
	public Showtime(Day day, Movie movie, AbstractCinema cinema, Cineplex cineplex) {
		this.day = day;
		this.movie = movie;
		this.cinema = cinema;
		this.cineplex = cineplex;
	}
	
	@Override
	public String toString() {
		return String.format("Showtime: %s | Cineplex: %s", day.toString(), cineplex.getName());
	}
	
	// Getters
	public Day getDay() { return day; }
	public Movie getMovie() { return movie; }
	public AbstractCinema getCinema() { return cinema; }
	public Cineplex getCineplex() { return cineplex; }
	
	// Setters
	public void setDay(Day day) { this.day = day; }
	public void setMovie(Movie movie) { this.movie = movie; }
	public void setCinema(AbstractCinema cinema) { this.cinema = cinema; }
	public void setCineplex(Cineplex cineplex) { this.cineplex = cineplex; }	
}
