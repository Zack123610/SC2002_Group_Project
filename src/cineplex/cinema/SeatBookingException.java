package cineplex.cinema;

/**
 * This error is thrown when an error is encountered during seat booking
 * @author Tan Say Hong
 *
 */
public class SeatBookingException extends Exception {
	private static final long serialVersionUID = -889065723823846474L;

	/**
	 * Passes a default seat booking error message to the exception class
	 */
	public SeatBookingException() {
		super("An error has occured while booking.");
	}
	
	/**
	 * Passes a specified error message to the exception class
	 * @param message is the message to be passsed
	 */
	public SeatBookingException(String message) {
		super(message);
	}	
}
