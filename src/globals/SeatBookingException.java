package globals;

//Throw this error when error encountered during seat booking
@SuppressWarnings("serial")
public class SeatBookingException extends Exception {
	public SeatBookingException() {
		super("An error has occured while booking.");
	}
	
	public SeatBookingException(String message) {
		super(message);
	}	
}
