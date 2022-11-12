package movie;

import movie.ticket.ITicketAttribute;

/**
 * This enum represents the common genres a movie can have
 * @author Tan Say Hong
 *
 */
public enum Genre implements ITicketAttribute {
	THREED("3D"),
	ACTION("Action"),
	ADVENTURE("Adventure"),
	ANIME("Anime"),
	BLOCKBUSTER("Blockbuster"),
	COMEDY("Comedy"),
	DRAMA("Drama"),
	FANTASY("Fantasy"),
	HORROR("Horror"),
	MYSTERY("Mystery"),
	ROMANCE("Romance"),
	THRILLER("Thriller"),
	SCI_FI("Sci-Fi");

	/**
	 * The display name of the genre
	 */
	private String name;
	/**
	 * The multiplier which affects the ticket price.
	 * By default, all the genres have a multiplier of 1.0.
	 * The multiplier can be changed by the admin via the admin settings
	 */
	private double multipler;
	
	/**
	 * Constructor to create a new {@code Genre} enum
	 * @param name the display name of the genre
	 */
	Genre(String name) {
		this.name = name;
		this.multipler = 1.0;
	}

	/**
	 * Returns the display name of the genre
	 */
	@Override
	public String toString() { return name; }
	/**
	 * Gets the genre multiplier
	 */
	@Override
	public double getMultiplier() { return multipler; }
	/**
	 * Sets the genre multiplier 
	 */
	@Override
	public void setMultiplier(double multiplier) { this.multipler = multiplier; }
}
