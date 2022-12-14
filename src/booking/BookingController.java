package booking;

import java.util.List;

import cineplex.Cineplex;
import cineplex.cinema.AbstractCinema;
import cineplex.cinema.Seat;
import customer.Age;
import customer.Customer;
import input.StringHandler;
import main.IBookingController;
import main.MOBLIMA;
import movie.Movie;
import movie.showtime.Showtime;
import movie.ticket.Ticket;

/**
 * The booking controller class provides implementation for the IBookingController interface
 */
public class BookingController implements IBookingController {
	/**
	 * Empty Constructor
	 */
	public BookingController() { }
	
	/**
	 * Represents the different states of the booking process
	 */
	enum BookingState { SELECT_MOVIE, FILTER_CINEPLEX, SELECT_CINEPLEX, SELECT_SHOWTIME, SEAT_SELECTION, CONFIRMATION, FINISH }
	
	
	public void doBooking(Customer customer) {
		doBooking(customer, null);
	}
	
	public void doBooking(Customer customer, Movie movie) {
		boolean done = false;
		BookingState state = (movie == null) 
				? BookingState.SELECT_MOVIE
				: BookingState.FILTER_CINEPLEX;
		
		Cineplex cineplex = null;
		AbstractCinema cinema = null;
		Showtime showtime = null;
		Booking booking = null;
		List<Cineplex> cineplexList = null;
		
		while (!done)
			switch (state) {
			
			case SELECT_MOVIE:
				movie = MOBLIMA.movieController.selectMovie(2);
				if (movie == null)
					return;
				System.out.println("Your choice : \n" + movie.getTitle());
				state = BookingState.FILTER_CINEPLEX;
				
			case FILTER_CINEPLEX:
				cineplexList = MOBLIMA.showtimeController.filterCineplexByMovie(movie);
				if (cineplexList.size() == 0) {
					System.out.println("There are no cineplexes showing this movie. Going back...");
					state = BookingState.SELECT_MOVIE;
					break;
				}
				state = BookingState.SELECT_CINEPLEX;
				
			case SELECT_CINEPLEX:
				cineplex = MOBLIMA.cineplexController.selectCineplex(cineplexList);
				if (cineplex == null) {
					System.out.println("You have cancelled the selection. Going back...");
					state = BookingState.SELECT_MOVIE;
					break;
				}
				
				System.out.println("Your choice : \n" + cineplex.getName());
				state = BookingState.SELECT_SHOWTIME;
				
			case SELECT_SHOWTIME:
				List<Showtime> showtimeList = MOBLIMA.showtimeController.filterShowtimeByMovieAndCineplex(movie, cineplex);
				showtime = MOBLIMA.showtimeController.selectShowtime(showtimeList);
				
				if (showtime == null) {
					System.out.println("You have cancelled the selection. Going back...");
					state = BookingState.SELECT_CINEPLEX;
					break;
				}
				System.out.println("Your choice : \n" + showtime.getDay().toString());
				
				cinema = showtime.getCinema();
				System.out.println("Cinema : " + cinema.getCinemaCode());
				
				booking = new Booking(cinema.getCinemaCode(), showtime);
				state = BookingState.SEAT_SELECTION;
				
			case SEAT_SELECTION:
				if (cinema.isFull()) {
					System.out.println("There are no more available seats, proceeding to confirmation page ...");
					state = BookingState.CONFIRMATION;
					break;
				}
				Seat seat = MOBLIMA.cinemaController.bookSeat(cinema);
				
				if (seat == null) 
					break;
				
				Age age = MOBLIMA.ticketController.getAge();
				Ticket ticket = MOBLIMA.ticketController.issueTicket(age, seat, showtime);
				
				System.out.print("Confirm current seat selection? (Y/N) ");
				
				if (StringHandler.readString("Y", "N").equals("Y")) {
					System.out.println("Seat selection confirmed.");
					cinema.bookSeat(seat);
					booking.addTicket(ticket);
				} else {				
					System.out.println("You have cancelled the seat selection");
				}
				
				System.out.print("Select another seat? (Y/N) ");
				state = StringHandler.readString("Y", "N").equals("Y") 
						? BookingState.SEAT_SELECTION 
						: (booking.getTotalPrice() == 0) ? BookingState.FINISH : BookingState.CONFIRMATION;
				break;
				
			case CONFIRMATION:
				System.out.println();
				booking.displayBookingInfo();
				
				System.out.print("You are about to make a new booking. Please confirm: (Y/N) ");
				if (StringHandler.readString("Y", "N").equals("N")) {
					System.out.println("The booking was cancelled");
					
					for (int i=0; i<booking.getTickets().size(); i++) 
						cinema.clearSeat(booking.getTickets().get(i).getSeat());
					return;
				}
				
				while(true) {
					System.out.print("Enter a Discount Code (Case Sensitive), N to skip: ");
					String inputCode = StringHandler.readString();
					if(booking.isDiscount(inputCode)){
						double discount = booking.getDiscountValue(inputCode);
						booking.applyDiscount(discount);
						System.out.printf("%.0f%% Discount applied successfully!\nYour new Price: $%.2f\n", 100*discount, booking.getTotalPrice());
						break;
					}
					if(inputCode.equals("N")) {
						System.out.println("No Code entered");
						break;
					}
					else
						System.out.println("Invalid code");
				}
				
				
				for (int i=0; i<booking.getTickets().size(); i++) 
					movie.addTicketSold();
				
				System.out.println("Booking successful.");
				customer.addBooking(booking);
				
			case FINISH:
				done = true;
				break;
			}
	}
}
