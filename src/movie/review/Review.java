package movie.review;

import input.Writable;


public class Review extends Writable {

	private static final long serialVersionUID = 5785020867407651793L;
	private int rating;
	private String description;
	
	public Review() { }
	public Review(int rating, String description) {
		this.rating = rating;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return String.format("%d★\n%s", rating, description);
	}
	
	public String getDescription() { return description; }
	public int getRating() { return rating; }
	
	public void setDescription(String description) { this.description = description; }
	public void setRating(int rating) { this.rating = rating; }
}
