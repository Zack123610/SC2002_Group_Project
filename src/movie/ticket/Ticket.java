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
	private static double basePrice = 10.00;
	private Seat seat;
	private Showtime showtime;
	private Booking booking;
	

	public Seat getSeat() { return seat; }
	public Showtime getShowtime() { return showtime; }
    public Booking getBooking() { return booking; }
    
    public void setBasePrice(double basePrice) { Ticket.basePrice = basePrice; }
	public void setSeat(Seat seat) { this.seat = seat; }
	public void setShowtime(Showtime showtime) { this.showtime = showtime; }
	public void setBooking(Booking booking) { this.booking = booking; }
	
	public double calculateFinalPrice() {
		double res = basePrice;
		
		for (IGetTicketAttribute genre : showtime.getMovie().getGenres())
			res *= genre.getMultiplier();
		
		for (IGetTicketAttribute attribute : Arrays.asList(
			booking.getAge(), showtime.getCinema(), showtime.getDay()
		))
			res *= attribute.getMultiplier();

		return res * 1.07;
	}
	
	public void displayTicketInfo() {
		System.out.println("Showtime: " + showtime.getDay().toString());
		System.out.println("Seat: " + seat.getSeatCode());
		System.out.printf("Price: $%.2f\n\n", calculateFinalPrice());
	}
}
