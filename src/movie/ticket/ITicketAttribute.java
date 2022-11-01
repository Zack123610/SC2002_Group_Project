package movie.ticket;

/**
 * This interface provides the {@code setMultiplier} method which allows the class or enum
 * that implements this interface to set its multiplier value.
 * @author Tan Say Hong
 *
 */
public interface ITicketAttribute extends IGetTicketAttribute {
	/**
	 * Sets the multiplier of the ticket attribute
	 * @param multiplier the multiplier value to set
	 */
	public void setMultiplier(double multiplier);
}
