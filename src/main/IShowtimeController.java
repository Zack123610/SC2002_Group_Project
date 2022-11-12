package main;

import java.util.List;
import java.util.UUID;

import cineplex.Cineplex;
import movie.Movie;
import movie.showtime.Showtime;

/**
 * IShowtimeController provides the interface required for managing the {@code Showtime} class.
 * It provides create, select, update, delete and display methods which other controllers can call.
 * It also provides helper methods to filter the showtimes based on certain conditions, namely:
 * <ul>
 * <li> Filtering showtimes based on the movie and cineplex provided </li>
 * <li> Filtering showtimes based on the movie provided </li>
 * <li> Filtering the cineplexes of the showtimes based on the movie provided </li>
 * </ul>
 * @author Tan Say Hong
 *
 */
public interface IShowtimeController {
	/**
	 * Initializes each {@code Showtime} from the list by adding their movie and cineplex information.
	 * It is executed at the beginning of the program
	 */
	public void init();
	/**
	 * Write all {@code Showtime} in the showtimes list back to the data files
	 */
	public void exit();
	/**
	 * Gets the {@code Showtime} object based on the input UUID
	 * @param id the UUID to search for
	 * @return the corresponding {@code Showtime} object if it exists, {@code null} otherwise
	 */
	public Showtime getShowtimeByID(UUID id);
	
	/**
	 * Displays the list of showtimes information to console. 
	 * @param list the list of showtimes to be displayed
	 */
	public void displayShowtimes(List<Showtime> list);
	/**
	 * This method asks the user to select from a list of movies. 
	 * @param list the list of showtimes to choose from
	 * @return a {@code Showtime} object if selection was successful, 
	 * {@code null} if user cancels or there are no showtimes to choose from.
	 */
	public Showtime selectShowtime(List<Showtime> list);
	/**
	 * Method to update a showtime's information. Callable via admin.
	 */
	public void updateShowtime();
	/**
	 * Method to create a new showtime. Callable via admin.
	 * A confirmation check is included before creating a new {@code Showtime}
	 */
	public void createShowtime();
	/**
	 * Method to delete a new showtime. Callable via admin.
	 * A confirmation check is included before deleting the {@code Showtime}
	 * Once confirmed, the corresponding data will be deleted from the data files if it exists
	 */
	public void deleteShowtime();
	
	/**
	 * Filters and returns the list of showtimes with matching movie title and cineplex location
	 * @param movie the movie to filter the showtimes
	 * @param cineplex the cineplex to filter the showtimes
	 * @return a list of {@code Showtime} with matching movie title and cineplex location
	 */
	public List<Showtime> filterShowtimeByMovieAndCineplex(Movie movie, Cineplex cineplex);
	/**
	 * Filters and returns the list of showtimes with matching movie title only
	 * @param movie the movie to filter the showtimes
	 * @return a list of {@code Showtime} with matching movie title
	 */
	public List<Showtime> filterShowtimeByMovie(Movie movie);	
	/**
	 * Filters and returns the list of cineplexes whose showtime matches the movie title
	 * @param movie the movie to filter the showtimes
	 * @return a list of {@code Cineplex}, whose {@code Showtime} matches the movie title
	 */
	public List<Cineplex> filterCineplexByMovie(Movie movie);
}
