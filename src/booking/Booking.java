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

public class Booking implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1252654829873622291L;
	private String transactionID;
	private Showtime showtime;
	private double totalPrice = 0.0;
	private List<Ticket> tickets;
	private double discount = 0.0;
	private static Map<String, Double> discountCodes = new HashMap<>();{{
		discountCodes.put("D50", 0.5);
		discountCodes.put("D30", 0.3);}}
	
	public Booking() { }
	public Booking(String cinemaCode, Showtime showtime) {
		this.showtime = showtime;
		
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmm");
		transactionID = cinemaCode + dateFormat.format(date);
		tickets = new ArrayList<>();
	}
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

	public String getTID() { return transactionID; }



	public double getTotalPrice() { return totalPrice * 1.07; }


	public List<Ticket> getTickets() { return tickets; }


	

	public void addTicket(Ticket ticket) {  
		tickets.add(ticket); 
		totalPrice += ticket.calculateFinalPrice();
	}


	public void applyDiscount(double discount){
		this.discount = discount;
		totalPrice *= (1-discount);
	}


	public double getDiscountValue(String discount){
		return discountCodes.get(discount);
	}


	public boolean isDiscount(String discount){
		return discountCodes.containsKey(discount);
	}
}
