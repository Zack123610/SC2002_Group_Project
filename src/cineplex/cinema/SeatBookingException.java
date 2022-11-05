package cineplex.cinema;

/**
 * This error is thrown when an error is encountered during seat booking
 * @author Tan Say Hong
 *
 */
public class SeatBookingException extends Exception {
	private static final long serialVersionUID = -889065723823846474L;

	public SeatBookingException() {
		super("An error has occured while booking.");
	}
	
	public SeatBookingException(String message) {
		super(message);
	}	
}
