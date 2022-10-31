package movie.ticket;

import java.util.Arrays;

import cineplex.cinema.Seat;
import customer.Age;
import globals.Writable;
import movie.showtime.Showtime;


public class Ticket extends Writable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2094192433542790502L;
	// basePrice: Base price that will be shared across all ticket classes
	private static double basePrice = 10.00;
	// finalPrice: The final price calculated for that particular ticket object
	private double finalPrice = 0.0;
	private Age age;
	private Seat seat;
	private Showtime showtime;
	

	public Seat getSeat() { return seat; }
	public Showtime getShowtime() { return showtime; }
    public Age getAge() { return age; }
    
    public static void setBasePrice(double basePrice) { Ticket.basePrice = basePrice; }
	public void setSeat(Seat seat) { this.seat = seat; }
	public void setShowtime(Showtime showtime) { this.showtime = showtime; }
	public void setAge(Age age) { this.age = age; }
	
	// If that particular ticket object already calculated its ticket price, then return its price
	// Or else, calculate the price of that ticket. We do this so that if we change the base ticket
	// price afterwards, the tickets bought in the past should not change.
	public Ticket(Age age, Seat seat, Showtime showtime){
		this.age = age;
		this.seat = seat;
		this.showtime = showtime;
		this.finalPrice = calculateFinalPrice();
	}
	public double calculateFinalPrice() {
		if (finalPrice > 0.0)
			return finalPrice;
		
		finalPrice = basePrice;
		
		for (IGetTicketAttribute genre : showtime.getMovie().getGenres())
			finalPrice *= genre.getMultiplier();
		
		for (IGetTicketAttribute attribute : Arrays.asList(
			age, showtime.getCinema(), showtime.getDay()
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
