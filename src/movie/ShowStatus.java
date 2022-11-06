package movie;

import java.io.Serializable;

/**
 * This Enum represents the different show statuses a movie can have 
 * @author Tan Say Hong
 *
 */
enum ShowStatus implements Serializable {
	COMINGSOON("Coming Soon"), 
	PREVIEW("Preview"),
	NOWSHOWING("Now Showing"), 
	ENDOFSHOWING("End of Showing");
	
	/**
	 * The display name of the show status
	 */
	private String name;
	
	/**
	 * Constructor to create a new {@code ShowStatus} enum
	 * @param name the display name of the show status
	 */
	ShowStatus(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the display name of the show status
	 */
	@Override
	public String toString() { return name; }
};
