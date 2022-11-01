package movie.ticket;

/**
 * A class or enum implements the {@code IGetTicketAttribute} interface to indicate that
 * it is an attribute of the {@code Ticket} class which will affect the calculation of the final ticket price.
 * @author Tan Say Hong
 *
 */
public interface IGetTicketAttribute {
	/**
	 * Gets the multiplier of the ticket attribute
	 * @return the multiplier value
	 */
	public double getMultiplier();
}
