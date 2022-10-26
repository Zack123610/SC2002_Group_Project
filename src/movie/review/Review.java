package movie.review;

import globals.Writable;
import movie.Movie;


public class Review extends Writable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5785020867407651793L;
	private Movie movie;
	private int rating;
	private String description;
	
	public Review() { }
	public Review(Movie movie, int rating, String description) {
		this.movie = movie;
		this.rating = rating;
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return String.format("%d★\n%s", rating, description);
	}
	
	public Movie getMovie() { return movie; }
	public String getDescription() { return description; }
	public int getRating() { return rating; }
	
	public void setMovie(Movie movie) { this.movie = movie; }
	public void setDescription(String description) { this.description = description; }
	public void setRating(int rating) { this.rating = rating; }
}
