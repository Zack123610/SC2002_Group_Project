package booking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import movie.ticket.Ticket;

public class Booking {
	private String transactionID, name, mobileNo, email;
	private double totalPrice = 0.0;
	private List<Ticket> tickets;
	private static HashMap<String, Double> discountCodes = new HashMap<>();{{
		discountCodes.put("D50", 0.5);
		discountCodes.put("D30", 0.3);}}
	
	
	
	public Booking() { }
	public Booking(String cinemaCode, String name, String mobileNo, String email) {
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmm");
		transactionID = cinemaCode + dateFormat.format(date);
		tickets = new ArrayList<>();
	}
	
	public void displayBookingInfo() {
		System.out.println("TransactionID: " + transactionID);
		System.out.println("--- Tickets Info ---");
		tickets.forEach(t -> t.displayTicketInfo());
		System.out.printf("Total price: $%.2f\n", getTotalPrice());
	}

	public String getTID() { return transactionID; }
	public String getName() { return name; }
	public String getMobileNo() { return mobileNo; }
	public String getEmail() { return email; }
	public double getTotalPrice() { return totalPrice * 1.07; }
	public List<Ticket> getTickets() { return tickets; }

	public void setName(String name) { this.name = name; }
	public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }
	public void setEmail(String email) { this.email = email; }
	
	public void addTicket(Ticket ticket) {  
		tickets.add(ticket); 
		totalPrice += ticket.calculateFinalPrice();
	}
	public void applyDiscount(double discount){
		totalPrice *= (1-discount);
	}
	// public void showPrice(double discount){
	// 	System.out.println(totalPrice * (1-discount));
	// }
	public double getDiscountValue(String discount){
		return discountCodes.get(discount);
	}
	public boolean isDiscount(String discount){
		return discountCodes.containsKey(discount);
	}


}
