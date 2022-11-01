package customer;

import java.util.ArrayList;
import java.util.List;

import booking.Booking;


public class Customer {
	private String name, mobileNo, email;
	private List<Booking> bookings;
	
	public Customer() {
		bookings = new ArrayList<>();
	}
	
	public void displayParticulars() {
		System.out.println("Name  : " + name);
		System.out.println("Mobile: " + mobileNo);
		System.out.println("Email : " + email);
	}
	
	public String getName() { return name; }
	public String getMobileNo() { return mobileNo; }
	public String getEmail() { return email; }
	public List<Booking> getBookings() { return bookings; }

	public void setName(String name) { this.name = name; }
	public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }
	public void setEmail(String email) { this.email = email; }
	
	public void addBooking(Booking booking) { bookings.add(booking); }
}
