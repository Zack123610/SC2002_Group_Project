package movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import input.Writable;
import movie.review.Review;


public class Movie extends Writable {

	private static final long serialVersionUID = 3685122323077146327L;
	private int ticketsSold = 0;
	private String title;
	private List<Genre> genres = new ArrayList<>();
	private ShowStatus showStatus;
	private LocalDate releaseDate;
	private String synopsis;
	private String director;
	private List<String> casts = new ArrayList<>();
	private MovieRating movieRating;
	private double totalRating = 0.0;
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
	
	//Getters
	public int getTicketsSold() { return ticketsSold; }
	public String getTitle() { return title; }
	public List<Genre> getGenres() { return genres; }
	public ShowStatus getShowStatus() { return showStatus; }
	public LocalDate getReleaseDate() { return releaseDate; }
	public String getSynopsis() { return synopsis; }
	public String getDirector() { return director; }
	public List<String> getCasts() { return casts; }
	public MovieRating getMovieRating() { return movieRating; }
	public List<Review> getReviews() { return reviews; }
	public double getOverallRating() { 
		return reviews.size() == 0 
			? 0.0 
			: totalRating / reviews.size();
	}
	
	public boolean isEndofShowing() { return showStatus == ShowStatus.ENDOFSHOWING; }
	
	//Setters
	public void setTitle(String title) { this.title = title; }
	public void setShowStatus(ShowStatus showStatus) { this.showStatus = showStatus; }
	public void setReleaseDate(LocalDate releaseDate) {this.releaseDate = releaseDate; }
	public void setSynopsis(String synopsis) { this.synopsis = synopsis; }
	public void setDirector(String director) { this.director = director; }
	public void setMovieRating(MovieRating movieRating) { this.movieRating = movieRating; }
	
	//Adders
	public void addTicketSold() { ticketsSold++; }
	public void addGenre(Genre genre) { genres.add(genre); }
	public void addCast(String cast) { casts.add(cast); }
	public void addReview(Review review) { 
		reviews.add(review);
		totalRating += review.getRating();
	}
	
	public void clearGenres() { genres = new ArrayList<>(); }
	public void clearCasts() { casts = new ArrayList<>(); }
}
