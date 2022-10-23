package movie.ticket;

import booking.Booking;
import cineplex.cinema.Seat;
import customer.Customer;
import globals.Writable;
import showtime.Showtime;


@SuppressWarnings("serial")
public class Ticket extends Writable {
	private static double basePrice = 10.00;
	public Seat seat;
	private Showtime showtime;
	private Customer customer;
	private Booking booking;
	

	public Seat getSeat() { return seat; }
	public Showtime getShowtime() { return showtime; }
    public Customer getCustomer() { return customer; }
    public Booking getBooking() { return booking; }
    
    public void setBasePrice(double basePrice) { Ticket.basePrice = basePrice; }
	public void setSeat(Seat seat) { this.seat = seat; }
	public void setShowtime(Showtime showtime) { this.showtime = showtime; }
	public void setCustomer(Customer customer) { this.customer = customer; }
	public void setBooking(Booking booking) { this.booking = booking; }
	
	public double calculateFinalPrice() {
		double res = basePrice;
		
		for (ITicketAttribute genre : showtime.getMovie().getGenres())
			res *= genre.getMultiplier();
		
		for (ITicketAttribute attribute : new ITicketAttribute[] {
			booking.getAge(), showtime.getCinema(), showtime.getDay()
		})
			res *= attribute.getMultiplier();

		return res;
	}
	
	public void printTicketInfo() {
		
	}
}
