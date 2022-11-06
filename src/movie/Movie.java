package movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import input.Writable;
import movie.review.Review;

/**
 * The {@code Movie} class is a Model class used to store movie data
 * It contains all the relevant attributes which a movie can have.
 * One {@code Movie} can have many {@code Review}
 * @author Tan Say Hong
 *
 */
public class Movie extends Writable {
	/**
	 * A static final UUID for serializing {@code Movie} objects
	 */
	private static final long serialVersionUID = 3685122323077146327L;
	/**
	 * The number of tickets sold for that movie, initialised to zero
	 */
	private int ticketsSold = 0;
	/**
	 * Movie title
	 */
	private String title;
	/**
	 * List of movie genres
	 */
	private List<Genre> genres = new ArrayList<>();
	/**
	 * Movie show status
	 */
	private ShowStatus showStatus;
	/**
	 * Movie release date 
	 */
	private LocalDate releaseDate;
	/**
	 * Movie synopsis
	 */
	private String synopsis;
	/**
	 * Movie director
	 */
	private String director;
	/**
	 * List of movie casts
	 */
	private List<String> casts = new ArrayList<>();
	/**
	 * Movie rating, based on IMDA
	 */
	private MovieRating movieRating;
	/**
	 * The overall review rating of the movie, 
	 * calculated by the sum of the review ratings divided by the number of reviews
	 */
	private double totalRating = 0.0;
	/**
	 * List of movie reviews
	 */
	private List<Review> reviews = new ArrayList<>();
	
	/**
	 * Used to display the short description (Movie title | Status)
	 */
	@Override
	public String toString() {
		return String.format("Title: %-30s | Show Status: %s", title, showStatus);
	}
	/**
	 * Displays the full information of the movie
	 */
	public void displayFullDetails() {
		System.out.printf("%s\n", toString());
		
		System.out.printf("Genres: %s\n", String.join(", ", genres.stream().map(Genre::toString)
								.collect(Collectors.joining(", "))));
		System.out.printf("Movie Rating: %s\n", movieRating);
		System.out.printf("Release Date: %s\n", releaseDate);
		System.out.printf("Synopsis: %s\n", synopsis);
		System.out.printf("Director: %s\n", director);
		System.out.printf("Cast: %s\n\n", String.join(", ", casts));
		
		System.out.print("Overall Review Rating: ");
		if (getOverallRating() == 0)
			System.out.println("NA");
		else
			System.out.printf("%.1f★\n", getOverallRating());
		
		if (reviews.size() > 0) {
			System.out.println("---------------------------");
			for (Review review : reviews)
				System.out.println(review.toString());
		}
		System.out.println();
	}
	
	/**
	 * Gets the number of tickets sold for that movie
	 * @return the number of tickets sold
	 */
	public int getTicketsSold() { return ticketsSold; }
	/**
	 * Gets the movie title
	 * @return the movie title
	 */
	public String getTitle() { return title; }
	/**
	 * Gets the list of movie genres
	 * @return a list of {@code Genre}
	 */
	public List<Genre> getGenres() { return genres; }
	/**
	 * Gets the movie show status
	 * @return the movie {@code ShowStatus}
	 */
	public ShowStatus getShowStatus() { return showStatus; }
	/**
	 * Gets the movie release date
	 * @return the release date as a {@code LocalDate}
	 */
	public LocalDate getReleaseDate() { return releaseDate; }
	/**
	 * Gets the movie synopsis
	 * @return the movie synopsis
	 */
	public String getSynopsis() { return synopsis; }
	/**
	 * Gets the movie director
	 * @return the movie director
	 */
	public String getDirector() { return director; }
	/**
	 * Gets the list of movie casts
	 * @return the list of movie casts
	 */
	public List<String> getCasts() { return casts; }
	/**
	 * Gets the movie rating
	 * @return the {@code MovieRating} of the movie
	 */
	public MovieRating getMovieRating() { return movieRating; }
	/**
	 * Gets the list of movie reviews
	 * @return a list of {@code Review}
	 */
	public List<Review> getReviews() { return reviews; }
	/**
	 * Calculates the overall review rating
	 * @return the overall review rating
	 */
	public double getOverallRating() { 
		return reviews.size() == 0 
			? 0.0 
			: totalRating / reviews.size();
	}
	
	/**
	 * Checks whether a movie has stopped showing
	 * @return {@code true} if the movie show status is End of Showing, {@code false} otherwise
	 */
	public boolean isEndofShowing() { return showStatus == ShowStatus.ENDOFSHOWING; }
	
	/**
	 * Sets the movie title
	 * @param title the title to set
	 */
	public void setTitle(String title) { this.title = title; }
	/**
	 * Sets the movie show status 
	 * @param showStatus the {@code ShowStatus} to set
	 */
	public void setShowStatus(ShowStatus showStatus) { this.showStatus = showStatus; }
	/**
	 * Sets the movie release date
	 * @param releaseDate the release date to set
	 */
	public void setReleaseDate(LocalDate releaseDate) {this.releaseDate = releaseDate; }
	/**
	 * Sets the movie synopsis
	 * @param synopsis the synopsis to set
	 */
	public void setSynopsis(String synopsis) { this.synopsis = synopsis; }
	/**
	 * Sets the movie director
	 * @param director the director to set
	 */
	public void setDirector(String director) { this.director = director; }
	/**
	 * Sets the movie rating
	 * @param movieRating the movie rating to set
	 */
	public void setMovieRating(MovieRating movieRating) { this.movieRating = movieRating; }
	
	/**
	 * Increments the number of tickets sold by 1
	 */
	public void addTicketSold() { ticketsSold++; }
	/**
	 * Adds a genre to the list of genres
	 * @param genre the {@code Genre} to add
	 */
	public void addGenre(Genre genre) { genres.add(genre); }
	/**
	 * Adds a cast to the list of casts
	 * @param cast the cast to add
	 */
	public void addCast(String cast) { casts.add(cast); }
	/**
	 * Adds a review to the list of reviews and increments the total rating of the movie
	 * @param review the {@code Review} to add
	 */
	public void addReview(Review review) { 
		reviews.add(review);
		totalRating += review.getRating();
	}
	
	/**
	 * Clears the list of movie genres
	 */
	public void clearGenres() { genres = new ArrayList<>(); }
	/**
	 * Clears the list of movie casts
	 */
	public void clearCasts() { casts = new ArrayList<>(); }
}
