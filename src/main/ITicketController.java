package main;

import cineplex.cinema.Seat;
import customer.Age;
import movie.showtime.Showtime;
import movie.ticket.Ticket;

/**
 * ITicketController provides the interface required for managing the {@code Ticket} class.
 * It provides the method to create a new {@code Ticket} object as well as the method to ask
 * the user to select the {@code Age} of the seat owner when booking a ticket.
 * @author Tan Say Hong
 *
 */
public interface ITicketController {
	/**
	 * Creates a new {@code Ticket} object and displays the created ticket information
	 * @param age the age of the seat owner
	 * @param seat the selected seat
	 * @param showtime the selected showtime
	 * @return the created {@code Ticket} object
	 */
    public Ticket issueTicket(Age age, Seat seat, Showtime showtime);
    /**
     * Asks the user to select the age of the seat owner
     * @return the {@code Age} of the seat owner
     */
    public Age getAge();
}