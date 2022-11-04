package main;

import customer.Customer;
import movie.Movie;

public interface IBookingController {
    public void doBooking(Customer customer);
    public void doBooking(Customer customer, Movie movie);
}