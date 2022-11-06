package movie.ticket;

import java.util.Arrays;

import cineplex.cinema.Seat;
import customer.Age;
import input.Writable;
import movie.showtime.Showtime;

/**
 * The {@code Ticket} class is a model class used to store ticket data when a customer does a booking.
 * One {@code Ticket} is associated to one {@code Seat} and associated with the chosen {@code Showtime}.   
 * @author Tan Say Hong
 *
 */
public class Ticket extends Writable {
	/**
	 * A static final UUID for serializing {@code Ticket} objects
	 */
	private static final long serialVersionUID = -2094192433542790502L;
	/**
	 * Base price that will be shared across all ticket classes
	 */
	private static double basePrice = 10.00;
	/**
	 * The final price calculated for that particular ticket object
	 */
	private double finalPrice = 0.0;
	/**
	 * The age of seat owner
	 */
	private Age age;
	/**
	 * The seat object associated with the ticket
	 */
	private Seat seat;
	/**
	 * The showtime object associated with the ticket
	 */
	private Showtime showtime;
	/**
	 * Constructor to create a new {@code Ticket} object based on the age, seat and showtime
	 * @param age the age of the seat owner
	 * @param seat the seat object
	 * @param showtime the showtime object
	 */
	public Ticket(Age age, Seat seat, Showtime showtime){
		this.age = age;
		this.seat = seat;
		this.showtime = showtime;
		this.finalPrice = calculateFinalPrice();
	}
	/**
	 * Gets the base price of the {@code Ticket}
	 * @return the base price
	 */
	public static double getBasePrice() { return basePrice; }
	/**
	 * Gets the seat of the {@code Ticket}
	 * @return the {@code Seat} object
	 */
	public Seat getSeat() { return seat; }
	/**
	 * Gets the showtime of the {@code Ticket}
	 * @return the {@code Showtime} object
	 */
	public Showtime getShowtime() { return showtime; }
	/**
	 * Gets the age of the {@code Ticket}
	 * @return the {@code Age} enum
	 */
    public Age getAge() { return age; }
    
    /**
     * Sets the base price of the {@code Ticket}
     * @param basePrice the base price to set
     */
    public static void setBasePrice(double basePrice) { Ticket.basePrice = basePrice; }
    /**
     * Sets the seat of the {@code Ticket}
     * @param seat the {@code Seat} to set
     */
	public void setSeat(Seat seat) { this.seat = seat; }
	/**
	 * Sets the showtime of the {@code Ticket}
	 * @param showtime the {@code Showtime} to set
	 */
	public void setShowtime(Showtime showtime) { this.showtime = showtime; }
	/**
	 * Sets the age of the {@code Ticket}
	 * @param age the {@code Age} to set
	 */
	public void setAge(Age age) { this.age = age; }
	
	/**
	 * Calculates the final price of a ticket object. If the final price is already calculated,
	 * then simply return the price. Or else, calculate the price of that ticket. We do this so that if we change the base ticket
	 * price afterwards, the tickets bought in the past should not change.
	 * @return the price of the ticket
	 */
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
	
	/**
	 * Prints the ticket information to the console.
	 */
	public void displayTicketInfo() {
		System.out.printf("Seat: %s --- $%.2f\n", seat.getSeatCode(), calculateFinalPrice());
	}
}
