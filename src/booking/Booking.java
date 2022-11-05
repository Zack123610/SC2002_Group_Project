package booking;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import movie.showtime.Showtime;
import movie.ticket.Ticket;

/**
 * The booking class contains all information contained in a booking
 */
public class Booking implements Serializable {

	/** 
	 * A static final UUID for booking objects
	 */
	private static final long serialVersionUID = 1252654829873622291L;

	/**
	 * The unique transaction ID of the booking
	 */
	private String transactionID;

	/**
	 * The movie showtime of the booking
	 */
	private Showtime showtime;

	/**
	 * The total price of all tickets in the booking
	 */
	private double totalPrice = 0.0;

	/** A list of tickets contained in the booking */
	private List<Ticket> tickets;

	/**
	 * The total discount percentage applied 
	 */
	private double discount = 0.0;

	/**
	 * A map of all codes with their values
	 */
	private static Map<String, Double> discountCodes = new HashMap<>();{{
		discountCodes.put("D50", 0.5);
		discountCodes.put("D30", 0.3);}}
	
	/**
	 * Empty constructor
	 */
	public Booking() { }

	/**
	 * Creates a new booking with the cinema code and the showtime 
	 * @param cinemaCode the unique code of the cinema
	 * @param showtime the selected movie showtime
	 */
	public Booking(String cinemaCode, Showtime showtime) {
		this.showtime = showtime;
		
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmm");
		transactionID = cinemaCode + dateFormat.format(date);
		tickets = new ArrayList<>();
	}
	
	/**
	 * Displays the booking information
	 */
	public void displayBookingInfo() {
		System.out.println("----------------------------");
		System.out.println("TransactionID: " + transactionID);
		System.out.println(showtime.toString());
		System.out.println(showtime.getMovie().toString());
		System.out.println("--- Tickets Info ---");
		tickets.forEach(t -> t.displayTicketInfo());
		if (discount > 0.0)
			System.out.printf("%.0f%% Discount applied!\n", 100*discount);
		System.out.printf("Total price (incl. GST): $%.2f\n", getTotalPrice());
		System.out.println("----------------------------");
	}

	/**
	 * Gets the transaction ID
	 * @return the tranction ID
	 */
	public String getTID() { return transactionID; }

	/**
	 * Gets the movie showtime
	 * @return the showtime object
	 */
	public Showtime getShowtime() { return showtime; }

	/**
	 * Gets the total price of the booking * 1.07
	 * @return the total price of the booking * 1.07
	 */
	public double getTotalPrice() { return totalPrice * 1.07; }

	/**
	 * Gets all the tickets in the booking
	 * @return a list of tickets
	 */
	public List<Ticket> getTickets() { return tickets; }
	
	/**
	 * Sets the showtime of the booking
	 * @param showtime is the selected showtime
	 */
	public void setShowtime(Showtime showtime) { this.showtime = showtime; }
	
	/**
	 * Adds a ticket to the current list of tickets in the booking
	 * @param ticket is the ticket to be added
	 */
	public void addTicket(Ticket ticket) {  
		tickets.add(ticket); 
		totalPrice += ticket.calculateFinalPrice();
	}
	
	/**
	 * Applies a discount to the total price
	 * @param discount is the value of the discount to be added
	 */
	public void applyDiscount(double discount) {
		this.discount = discount;
		totalPrice *= (1-discount);
	}

	/**
	 * Gets the value of a valid discount code
	 * @param discount is the code entered by the user
	 * @return the value associated with the code
	 */
	public double getDiscountValue(String discount) {
		return discountCodes.get(discount);
	}

	/**
	 * Checks whether the discount code entered is valid
	 * @param discount is the code entered
	 * @return	{@code true} if it is valid, {@code false} otherwise
	 */
	public boolean isDiscount(String discount) {
		return discountCodes.containsKey(discount);
	}
}
