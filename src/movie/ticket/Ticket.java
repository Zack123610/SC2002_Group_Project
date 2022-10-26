package movie.ticket;

import java.util.Arrays;

import booking.Booking;
import cineplex.cinema.Seat;
import globals.Writable;
import movie.showtime.Showtime;


public class Ticket extends Writable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2094192433542790502L;
	// basePrice: Base price that will be shared across all ticket classes
	private static double basePrice = 10.00;
	// finalPrice: The final price calculated for that ticket object
	private double finalPrice = 0.0;
	private Seat seat;
	private Showtime showtime;
	private Booking booking;
	

	public Seat getSeat() { return seat; }
	public Showtime getShowtime() { return showtime; }
    public Booking getBooking() { return booking; }
    
    public static void setBasePrice(double basePrice) { Ticket.basePrice = basePrice; }
	public void setSeat(Seat seat) { this.seat = seat; }
	public void setShowtime(Showtime showtime) { this.showtime = showtime; }
	public void setBooking(Booking booking) { this.booking = booking; }
	
	public double calculateFinalPrice() {
		if (finalPrice > 0.0)
			return finalPrice;
		
		finalPrice = basePrice;
		
		for (IGetTicketAttribute genre : showtime.getMovie().getGenres())
			finalPrice *= genre.getMultiplier();
		
		for (IGetTicketAttribute attribute : Arrays.asList(
			booking.getAge(), showtime.getCinema(), showtime.getDay()
		))
			finalPrice *= attribute.getMultiplier();

		return finalPrice;
	}
	
	public void displayTicketInfo() {
		System.out.println("Showtime: " + showtime.getDay().toString());
		System.out.println("Seat: " + seat.getSeatCode());
		System.out.printf("Price: $%.2f\n\n", calculateFinalPrice());
	}
}
