package main;

import java.util.UUID;

import movie.Movie;

/**
 * IMovieController provides the interface required for managing the Movie class.
 * It provides create, select, update and delete methods which other controllers can call.
 * It also provides the method to list top 5 movie rankings, and the methods required by
 * the admin to configure which top 5 rankings are displayable for the customer.
 * @author Tan Say Hong
 *
 */
public interface IMovieController {
	public void init();
	public void exit();
	public Movie getMovieByID(UUID id);
	/**
	 * Method to display all the movies available in the system. Callable via admin.
	 */
	public void displayAllMovies();
	/**
	 * Method to display all the available movies. 
	 * Available movies are those without "End of Showing" show status.
	 * This method is called when a customer chooses to display all available movies.
	 */
	public void displayAllAvailableMovies();

	/**
	 * This method asks the user to select from a list of movies. 
	 * The flag specifies the filter based on the show status. 
	 * <pre>
	 * 1XX -> Sets the flag for movies with coming soon
	 * X1X -> Sets the flag for movies with preview or now showing
	 * XX1 -> Sets the flag for movies with end of showing
	 * </pre>
	 * @param flag a 3-bit flag used to determine the type of filter to apply
	 * @return a {@code Movie} object if selection was successful, {@code null} otherwise.
	 */
	public Movie selectMovie(int flag);
	
	/**
	 * This method asks for user to input a text, then filters a list
	 * of movies with matching movie title. The user is then
	 * prompted to select a movie from the available list. 
	 * @return a {@code Movie} object if selection was successful, 
	 * {@code null} if user cancels or no matching movies found.
	 */
	public Movie searchMovie();
	
	/**
	 * Method to update a movie's attributes. Callable via admin.
	 */
	public void updateMovie();
	
	/**
	 * Method to create a new movie. Callable via admin.
	 * A confirmation check is included before creating a new {@code Movie}
	 */
	public void createMovie();

	/**
	 * Method to delete a new movie. Callable via admin.
	 * The deletion is a soft delete by setting its show status to End of Showing.
	 * A confirmation check is included before deleting the {@code Movie} object.
	 */
	public void deleteMovie();
	
	/**
	 * Gets the filter flag used to display the top 5 movies. Callable via admin -> settings.
	 * @return the filter flag 
	 */
	public byte getTopFiveFilter();
	/**
	 * Sets the filter flag used to display the top 5 movies. Callable via admin -> settings.
	 * @param num the filter flag
	 */
	public void setTopFiveFilter(byte num);
	/**
	 * Method to display the top 5 movies. A 2-bit flag is used which determines
	 * whether to sort by ticket sales, by overall ratings, or both.
	 * This method is called when the customer chooses to display the top 5 rankings.
	 * <pre>
	 * 1X -> Displays top 5 movies by tickets sold
	 * X1 -> Displays top 5 movies by overall rating
	 * </pre>
	 */
	public void listTopFive();
}
