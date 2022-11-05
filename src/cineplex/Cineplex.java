package cineplex;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cineplex.cinema.AbstractCinema;
import input.Writable;
import movie.showtime.Showtime;

/**
 * The cineplex class contains information regarding a cineplex
 */
public class Cineplex extends Writable {

	private static final long serialVersionUID = -8543460754888135256L;

	/**
	 * The name of the cineplex
	 */
	private String name;

	/**
	 * A list of showtime Ids
	 */
	private List<UUID> showTimeIDList;

	/**
	 * A list of all showtimes of the cineplex 
	 */
	private List<Showtime> showTimes; 

	/**
	 * A list of cinemas of the cineplex
	 */
	private List<AbstractCinema> cinemaList; 
	
	/**
	 * Empty constructor for {@code Cineplex}
	 */
	public Cineplex() {}

	/**
	 * Constructor for {@code Cineplex} which creates a {@code Cineplex} with a name
	 * @param name is the name of the cineplex
	 */
	public Cineplex(String name) {
		this.name = name;
		showTimes = new ArrayList<>(); 
		showTimeIDList = new ArrayList<>(); 
		cinemaList = new ArrayList<>();
	}
	
	// Getters
	/**
	 * Gets the name cineplex
	 * @return
	 */
	public String getName() { return name; }

	/**
	 * Gets the list of showtime ids of the cineplex
	 * @return a list of showtime ids
	 */
	public List<UUID> getShowTimeIDList() { return showTimeIDList; }
	
	/**
	 * Gets a list of showtimes of the cineplex
	 * @return a list of {@code Showtime}
	 */
	public List<Showtime> getShowTimes() { return showTimes; }

	/**
	 * Gets a list of cinemas of the cineplex
	 * @return a list of {@code AbstractCinema}
	 */
	public List<AbstractCinema> getCinemaList() { return cinemaList; }
	
	// Setters
	/**
	 * Sets the list of showtimes of the cineplex
	 * @param showTimes is a list of {@code Showtime} to be set
	 */
	public void setShowTimes(List<Showtime> showTimes) { this.showTimes = showTimes; }

	/**
	 * Sets a list of cinemas of the cineplex
	 * @param cinemaList is a list of {@code AbstractCinema} to be set
	 */
	public void setCinemaList(List<AbstractCinema> cinemaList) { this.cinemaList = cinemaList; }
	
	// Adders
	/**
	 * Adds a showtime to the showtime list of the cineplex 
	 * @param showTime is a {@code Showtime} to be added
	 */
	public void addShowTime(Showtime showTime) { showTimes.add(showTime); }

	/**
	 * Adds a cinema to the list of cinemas of the cineplex
	 * @param cinema is a {@code AbstractCinema} to be added
	 */
	public void addCinema(AbstractCinema cinema) {
		cinemaList.add(cinema);
	}
}
