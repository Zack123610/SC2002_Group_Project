package movie.review;

import input.Writable;

/**
 * The {@code Review} class is a Model class used to store movie reviews.
 * One {@code Movie} can have many {@code Review}
 * @author Tan Say Hong
 *
 */
public class Review extends Writable {
	/**
	 * A static final UUID for serializing {@code Review} objects
	 */
	private static final long serialVersionUID = 5785020867407651793L;
	/**
	 * The review rating (1-5)
	 */
	private int rating;
	/**
	 * The review description
	 */
	private String description;
	
	/**
	 * Empty constructor
	 */
	public Review() { }
	/**
	 * Constructor to create a new {@code Review} object based on the rating and description provided
	 * @param rating the review rating
	 * @param description the review description
	 */
	public Review(int rating, String description) {
		this.rating = rating;
		this.description = description;
	}
	
	/**
	 * Returns a string of the {@code Review} object, for e.g.
	 * <p>
	 * 5★</br>
	 * The movie was great!
	 * </p>
	 */
	@Override
	public String toString() {
		return String.format("%d★\n%s", rating, description);
	}
	
	/**
	 * Gets the description of the {@code Review}
	 * @return the description
	 */
	public String getDescription() { return description; }
	/**
	 * Gets the rating of the {@code Review}
	 * @return the rating, from 1 to 5
	 */
	public int getRating() { return rating; }
	
	/**
	 * Sets the description of the {@code Review}
	 * @param description the description to set
	 */
	public void setDescription(String description) { this.description = description; }
	/**
	 * Sets the rating of the {@code Review}
	 * @param rating the rating to set
	 */
	public void setRating(int rating) { this.rating = rating; }
}
