package customer;

import java.util.ArrayList;
import java.util.List;

import booking.Booking;
import input.Writable;

/**
 * The customer class contains information of a customer
 */
public class Customer extends Writable {

	/**
	 * A static final UUID of Customer
	 */
	private static final long serialVersionUID = -8733239562031385172L;

	/**
	 * The name of the customer
	 */
	private String name;

	/**
	 * The mobile number of the customer
	 */
	private String mobileNo;

	/**
	 * The email of the customer
	 */
	private String email;

	/**
	 * A list of {@code Booking} made by the customer
	 */
	private List<Booking> bookings;
	
	/**
	 * Empty constructor for {@code Customer} which creates an empty booking list
	 */
	public Customer() { 
		bookings = new ArrayList<>();
	}

	/**
	 * Constructor for {@code Customer}, with name, mobile number and email
	 * @param name is the name of the customer
	 * @param mobile is the mobile number of the customer
	 * @param email is the email of the customer
	 */
	public Customer(String name, String mobile, String email) {
		this();
		this.name = name;
		this.mobileNo = mobile;
		this.email = email;
	}
	
	/**
	 * Displays the name, mobile number and email of the customer
	 */
	public void displayParticulars() {
		System.out.println("Name  : " + name);
		System.out.println("Mobile: " + mobileNo);
		System.out.println("Email : " + email);
	}
	
	/**
	 * Gets the name of the customer
	 * @return the name of the customer
	 */
	public String getName() { return name; }

	/**
	 * Gets the mobile number of the customer
	 * @return the mobile number of the customer
	 */
	public String getMobileNo() { return mobileNo; }

	/**
	 * Gets the email of the customer
	 * @return the email of the customer
	 */
	public String getEmail() { return email; }

	/**
	 * Gets the list of movie bookings of the customer
	 * @return the list of {@code Booking}
	 */
	public List<Booking> getBookings() { return bookings; }

	/**
	 * Sets the name of the customer
	 * @param name is the name of the customer
	 */
	public void setName(String name) { this.name = name; }

	/**
	 * Sets the mobile number of the customer
	 * @param mobileNo is the mobile number of the customer
	 */
	public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

	/**
	 * Sets the email of the customer
	 * @param email is the email of the customer
	 */
	public void setEmail(String email) { this.email = email; }
	
	/**
	 * Adds a {@code Booking} to the list of customer's bookings
	 * @param booking is a {@code Booking} to be added
	 */
	public void addBooking(Booking booking) { bookings.add(booking); }
}
