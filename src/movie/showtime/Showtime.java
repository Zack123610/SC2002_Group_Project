package movie.showtime;

import cineplex.Cineplex;
import cineplex.cinema.AbstractCinema;
import input.Writable;
import movie.Movie;

/**
 * The {@code Showtime} class is a model class used to store showtime data.
 * One {@code Showtime} object is associated with the {@code Day} of the showtime,
 * the {@code Movie} which will be played at that showtime, the {@code AbstractCinema} which
 * the movie will be played in and the {@code Cineplex} where the showtime is at
 * @author Tan Say Hong
 *
 */
public class Showtime extends Writable {
	/**
	 * A static final UUID for serializing {@code Showtime} objects
	 */
	private static final long serialVersionUID = 134314070495203459L;
	/**
	 * The day of the showtime
	 */
	private Day day;
	/**
	 * The movie to be played
	 */
	private Movie movie;
	/**
	 * The cinema which the movie will be played in
	 */
	private AbstractCinema cinema;
	/**
	 * The cineplex where the showtime is at
	 */
	private Cineplex cineplex;
	
	/**
	 * Empty constructor
	 */
	public Showtime() { }
	/**
	 * Constructor to create a new {@code Showtime} object based on the day, movie, cinema and cineplex provided 
	 * @param day the day of the showtime
	 * @param movie the movie to be played
	 * @param cinema the cinema which the movie will be played in
	 * @param cineplex the cineplex where the showtime is at
	 */
	public Showtime(Day day, Movie movie, AbstractCinema cinema, Cineplex cineplex) {
		this.day = day;
		this.movie = movie;
		this.cinema = cinema;
		this.cineplex = cineplex;
	}
	
	/**
	 * Returns a string of the {@code Showtime} object, for e.g.
	 * <p>
	 * Showtime: 2022-11-16 00:00 | Cineplex: Jem
	 * </p>
	 */
	@Override
	public String toString() {
		return String.format("Showtime: %s | Cineplex: %s", day.toString(), cineplex.getName());
	}
	
	/**
	 * Gets the day of the {@code Showtime}
	 * @return the {@code Day} object
	 */
	public Day getDay() { return day; }
	/**
	 * Gets the movie of the {@code Showtime}
	 * @return the {@code Movie} object
	 */
	public Movie getMovie() { return movie; }
	/**
	 * Gets the cinema of the {@code Showtime}
	 * @return the {@code AbstractCinema} object
	 */
	public AbstractCinema getCinema() { return cinema; }
	/**
	 * Gets the cineplex of the {@code Showtime}
	 * @return the {@code Cineplex} object
	 */
	public Cineplex getCineplex() { return cineplex; }
	
	/**
	 * Sets the day of the {@code Showtime}
	 * @param day the {@code Day} to set
	 */
	public void setDay(Day day) { this.day = day; }
	/**
	 * Sets the movie of the {@code Showtime}
	 * @param movie the {@code Movie} to set
	 */
	public void setMovie(Movie movie) { this.movie = movie; }
	/**
	 * Sets the cinema of the {@code Showtime}
	 * @param cinema the {@code AbstractCinema} to set
	 */
	public void setCinema(AbstractCinema cinema) { this.cinema = cinema; }
	/**
	 * Sets the cineplex of the {@code Showtime}
	 * @param cineplex the {@code Cineplex} to set
	 */
	public void setCineplex(Cineplex cineplex) { this.cineplex = cineplex; }	
}
