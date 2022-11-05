package customer;

import java.util.ArrayList;
import java.util.List;

import booking.Booking;
import input.Writable;


public class Customer extends Writable {

	private static final long serialVersionUID = -8733239562031385172L;
	private String name, mobileNo, email;
	private List<Booking> bookings;
	
	public Customer() { 
		bookings = new ArrayList<>();
	}
	public Customer(String name, String mobile, String email) {
		this();
		this.name = name;
		this.mobileNo = mobile;
		this.email = email;
	}
	
	public void displayParticulars() {
		System.out.println("Name  : " + name);
		System.out.println("Mobile: " + mobileNo);
		System.out.println("Email : " + email);
	}
	
	// Getetrs
	public String getName() { return name; }
	public String getMobileNo() { return mobileNo; }
	public String getEmail() { return email; }
	public List<Booking> getBookings() { return bookings; }

	// Setters
	public void setName(String name) { this.name = name; }
	public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }
	public void setEmail(String email) { this.email = email; }
	
	// Adders
	public void addBooking(Booking booking) { bookings.add(booking); }
}
