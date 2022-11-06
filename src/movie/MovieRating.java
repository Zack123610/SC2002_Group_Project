package movie;

import java.io.Serializable;

/**
 * This enum represents the different classifications ratings a movie can have.
 * This information is retrived from the Info-communications Media Development Authority of Singapore (IMDA)
 * @author Tan Say Hong
 *
 */
public enum MovieRating implements Serializable {
	G("G"),
	PG("PG"),
	PG13("PG13"),
	NC16("NC16"),
	M18("M18"),
	R21("R21"),
	TBA("To Be Announced");

	/**
	 * The display name of the movie rating
	 */
	private String name;
	
	/**
	 * Constructor to create a new {@code MovieRating} enum
	 * @param name the display name
	 */
	MovieRating(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the display name of the movie rating
	 */
	@Override
	public String toString() { return name; }
}
