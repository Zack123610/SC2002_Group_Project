package movie.review;

import java.util.UUID;

import globals.Writable;

@SuppressWarnings("serial")
public class Review extends Writable {
	private UUID movieID;
	private String description;
	private int rating;
	
	
	public UUID getMovieID() {
		return movieID;
	}
	
	@Override
	public String toString() {
		return String.format("%d★\n%s", rating, description);
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
