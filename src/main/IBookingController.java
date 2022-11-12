package main;

import customer.Customer;
import movie.Movie;

/**
 * The IBookingController provides the interface for BookingController. 
 */
public interface IBookingController {

    /**
	 * This method calls the overload method doBooking which does a booking if there is no movie selected beforehand
	 * @param customer is the customer 
	 */
    public void doBooking(Customer customer);

    /**
	 * This method overloads the doBooking method if there is a movie specified. It handles the entire booking process,
	 * and adds a booking object to the customer
	 * @param customer is the customer
	 * @param movie is the movie, the default is null if no movie is selected beforehand
	 */
    public void doBooking(Customer customer, Movie movie);
}