package booking;

import customer.Customer;
import movie.Movie;

public interface IBookingController {
    public void init();

    public void exit();

    enum BookingState {
    };

    public void doBooking(Customer customer, Movie movie);
}