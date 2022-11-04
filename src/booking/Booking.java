package booking;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import movie.ticket.Ticket;

/**
 * This class contains all information contained in an individual booking
 * Including transactionID, name, mobile number, email, total price, a list of tickets and a map of discount codes
 */

public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;
	private String transactionID, name, mobileNo, email;
	private double totalPrice = 0.0;
	private List<Ticket> tickets;
	private static HashMap<String, Double> discountCodes = new HashMap<>();{{
		discountCodes.put("D50", 0.5);
		discountCodes.put("D30", 0.3);}}
	
	
	/** Empty constructor */
	public Booking() { }
	/**
	 * Allocates a {@code Booking} object and initialises it with the name, mobile number and email
	 * @param cinemaCode the unique code of the choosen cinema, used to generate transactionID
	 * @param name the name of the customer
	 * @param mobileNo the mobile number of the customer
	 * @param email the email of the customer
	 */
	public Booking(String cinemaCode, String name, String mobileNo, String email) {
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmm");
		transactionID = cinemaCode + dateFormat.format(date);
		tickets = new ArrayList<>();
	}
	/** This method displays the transaction ID and the information of each ticket in the booking */
	public void displayBookingInfo() {
		System.out.println("TransactionID: " + transactionID);
		System.out.println("--- Tickets Info ---");
		tickets.forEach(t -> t.displayTicketInfo());
		System.out.printf("Total price: $%.2f\n", getTotalPrice());
	}
	/**
	 * This method is to get the transactionID
	 * @return the transactionID
	 */
	public String getTID() { return transactionID; }

	/**
	 * This method is to get the name of the customer
	 * @return the name of the customer
	 */
	public String getName() { return name; }
	
	/**
	 * This method is to get the mobile number of the customer
	 * @return the mobile number of the customer
	 */
	public String getMobileNo() { return mobileNo; }

	/**
	 * This method is to get the email of the customer
	 * @return the email of the customer
	 */
	public String getEmail() { return email; }

	/**
	 * This method is to get the total prices of all the tickets in the booking multiplied by a service charge
	 * @return the total price of the booking
	 */
	public double getTotalPrice() { return totalPrice * 1.07; }

	/**
	 * This method is to get all tickets in the booking
	 * @return a list of tickets in the booking
	 */
	public List<Ticket> getTickets() { return tickets; }

	/** This method is to set the name of the customer  
	 *	@param name is the name of the customer
	 */
	public void setName(String name) { this.name = name; }

	/**
	 * This method is to set the mobile number of the customer
	 * @param mobileNo is the mobile number of the customer
	 */
	public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

	/**
	 * This method is to set the email of the customer
	 * @param email is the email of the customer
	 */
	public void setEmail(String email) { this.email = email; }
	
	/**
	 * This method is to add a ticket to the existing booking
	 * @param ticket is the ticket to be added
	 */
	public void addTicket(Ticket ticket) {  
		tickets.add(ticket); 
		totalPrice += ticket.calculateFinalPrice();
	}

	/**
	 * This method is to apply the discount to the final price of the booking
	 * @param discount is the discount to be applied
	 */
	public void applyDiscount(double discount){
		totalPrice *= (1-discount);
	}

	/**
	 * This method is to get the value of the discount 
	 * @param discount is the name of the discount
	 * @return the value of the discount associated
	 */
	public double getDiscountValue(String discount){
		return discountCodes.get(discount);
	}

	/**
	 * This method is to check if the input code is valid
	 * @param discount is the name of the inputted code
	 * @return true if it is a valid discount
	 */
	public boolean isDiscount(String discount){
		return discountCodes.containsKey(discount);
	}


}
