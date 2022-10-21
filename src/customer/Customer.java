package customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import booking.Booking;


@SuppressWarnings("serial")
public class Customer implements Serializable {
	private String name, mobileNo, email;
	private List<Booking> bookings;
	
	public Customer() {
		bookings = new ArrayList<>();
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
