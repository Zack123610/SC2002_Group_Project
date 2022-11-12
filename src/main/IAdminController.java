package main;

/**
 * The IAdminController provides the interface for the admin controller.
 * @author Tan Say Hong
 *
 */
public interface IAdminController {
	/**
	 * This method runs the admin controller class.
	 */
	public void run();
	/**
	 * Gets the filter flag used to display the top 5 movies. 
	 * The filter flag is a 2-bit flag which determines whether to sort by ticket sales, by overall ratings, or both.
	 * This method is called when the customer chooses to display the top 5 rankings.
	 * <pre>
	 * 1X -> Displays top 5 movies by tickets sold
	 * X1 -> Displays top 5 movies by overall rating
	 * </pre>
	 * @return the filter flag 
	 */
	public byte getTopFiveFilter();
}
