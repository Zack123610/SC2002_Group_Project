package booking;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import cineplex.Cineplex;
import cineplex.cinema.Cinema;
import cineplex.cinema.Seat;
import customer.Age;
import customer.Customer;
import input.StringHandler;
import main.MOBLIMA;
import movie.Movie;
import movie.showtime.Showtime;
import movie.ticket.Ticket;

public class BookingController {
	public BookingController() { }
	
	// Initialisation Code
	public void init() {
		System.out.println("Booking Controller initialised successfully!");
	}
	public void exit() {
		System.out.println("Booking Controller exited successfully!");
	}
	
	enum BookingState { SELECT_MOVIE, FILTER_CINEPLEX, SELECT_CINEPLEX, SELECT_SHOWTIME, SEAT_BOOKING, CONFIRMATION, FINISH }

	public void doBooking(Customer customer) {
		// Select movie -> filter by movie -> return cineplexes -> chooses cineplex -> filter by movie and cineplex-> return showtime
		//showtime -> cinema ->choose seat->return seat ->  + Age ->Ticket
		//Ticket add to booking obj -> repeat ->return booking
		boolean done = false;
		BookingState state = BookingState.SELECT_MOVIE;
		
		// Comment out for convenience, uncomment when done
//		if (customer.getName() == null) {
//			System.out.print("Enter Name: ");
//			customer.setName(StringHandler.readString());
//			customer.setMobileNo(getMobileWithValidation());
//			customer.setEmail(getEmailWithValidation());		
//		}
		
		customer.setName("ABC");
		customer.setMobileNo("99");
		customer.setEmail("a@a");
		customer.displayParticulars();
		
		Movie movie = null;
		Cineplex cineplex = null;
		Cinema cinema = null;
		Showtime showtime = null;
		Booking booking = null;
		ArrayList<Cineplex> cineplexList = null;
		
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
				booking = new Booking(
						cinema.getCinemaCode(), 
						customer.getName(), 
						customer.getMobileNo(), 
						customer.getEmail());
				state = BookingState.SEAT_BOOKING;
				
			case SEAT_BOOKING:
				Seat seat = MOBLIMA.cinemaController.bookSeat(cinema);
				
				if (seat == null) {
					break;
				}
				
				Age age = MOBLIMA.ticketController.getAge();
				Ticket ticket = MOBLIMA.ticketController.issueTicket(age, seat, showtime);
				
				System.out.print("Confirm seat booking? (Y/N) ");
				
				if (StringHandler.readString("Y", "N").equals("Y")) {
					System.out.println("Seat booking confirmed.");
					cinema.bookSeat(seat);
					booking.addTicket(ticket);
				} else {
					System.out.println("You have cancelled the seat booking");
					System.out.print("Do you wish to continue booking seats? (Y/N) ");
					state = StringHandler.readString("Y", "N").equals("Y") 
							? BookingState.SEAT_BOOKING 
							: BookingState.FINISH; 
					break;
				}
				
				System.out.print("Select another seat? (Y/N) ");
				state = StringHandler.readString("Y", "N").equals("Y") 
						? BookingState.SEAT_BOOKING 
						: BookingState.CONFIRMATION;
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
				
				System.out.println("Enter a Discount Code(Case Sensitive), N to skip:");
				String inputCode = StringHandler.readString();
				do{
					
					if(booking.isDiscount(inputCode)){
						double discount = booking.getDiscountValue(inputCode);
						booking.applyDiscount(discount);
						System.out.printf("%.0f%% Discount applied successfully!\nYour new Price: $%.2f\n",(100*discount), booking.getTotalPrice());
						break;
					}
					System.out.println("Invalid Code");
					System.out.println("Enter a Discount Code(Case Sensitive), N to skip:");
					inputCode = StringHandler.readString();

				}
				while(!inputCode.equals("N"));
				
				
				for (int i=0; i<booking.getTickets().size(); i++) {
					cinema.bookSeat(booking.getTickets().get(i).getSeat());
					movie.addTicketSold();
				}
				
				System.out.println("Booking successful.");
				customer.addBooking(booking);
				
			case FINISH:
				done = true;
				break;
			}
	}
	//If movie is provided
	public void doBooking(Customer customer, Movie movie) {
		
		boolean done = false;
		BookingState state = BookingState.FILTER_CINEPLEX;
		
		// Comment out for convenience, uncomment when done
//		if (customer.getName() == null) {
//			System.out.print("Enter Name: ");
//			customer.setName(StringHandler.readString());
//			customer.setMobileNo(getMobileWithValidation());
//			customer.setEmail(getEmailWithValidation());		
//		}
		
		customer.setName("ABC");
		customer.setMobileNo("99");
		customer.setEmail("a@a");
		customer.displayParticulars();
		

		Cineplex cineplex = null;
		Cinema cinema = null;
		Showtime showtime = null;
		Booking booking = null;
		ArrayList<Cineplex> cineplexList = null;
		
		while (!done)
			switch (state) {
			
				
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
				booking = new Booking(
						cinema.getCinemaCode(), 
						customer.getName(), 
						customer.getMobileNo(), 
						customer.getEmail());
				state = BookingState.SEAT_BOOKING;
				
			case SEAT_BOOKING:
				Seat seat = MOBLIMA.cinemaController.bookSeat(cinema);
				
				if (seat == null) {
					break;
				}
				
				Age age = MOBLIMA.ticketController.getAge();
				Ticket ticket = MOBLIMA.ticketController.issueTicket(age, seat, showtime);
				
				System.out.print("Confirm seat booking? (Y/N) ");
				
				if (StringHandler.readString("Y", "N").equals("Y")) {
					System.out.println("Seat booking confirmed.");
					cinema.bookSeat(seat);
					booking.addTicket(ticket);
				} else {
					System.out.println("You have cancelled the seat booking");
					System.out.print("Do you wish to continue booking seats? (Y/N) ");
					state = StringHandler.readString("Y", "N").equals("Y") 
							? BookingState.SEAT_BOOKING 
							: BookingState.FINISH; 
					break;
				}
				
				System.out.print("Select another seat? (Y/N) ");
				state = StringHandler.readString("Y", "N").equals("Y") 
						? BookingState.SEAT_BOOKING 
						: BookingState.CONFIRMATION;
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
				
				System.out.println("Enter a Discount Code(Case Sensitive), N to skip:");
				String inputCode = StringHandler.readString();
				do{
					
					if(booking.isDiscount(inputCode)){
						double discount = booking.getDiscountValue(inputCode);
						booking.applyDiscount(discount);
						System.out.printf("%.0f%% Discount applied successfully!\nYour new Price: $%.2f\n",(100*discount), booking.getTotalPrice());
						break;
					}
					System.out.println("Invalid Code");
					System.out.println("Enter a Discount Code(Case Sensitive), N to skip:");
					inputCode = StringHandler.readString();

				}
				while(!inputCode.equals("N"));
				
				
				for (int i=0; i<booking.getTickets().size(); i++) {
					cinema.bookSeat(booking.getTickets().get(i).getSeat());
					movie.addTicketSold();
				}
				
				System.out.println("Booking successful.");
				customer.addBooking(booking);
				
			case FINISH:
				done = true;
				break;
			}
	}
	
	private String getMobileWithValidation() {
		String text;
		Pattern pattern = Pattern.compile("[89]\\d{7}");
		
		System.out.print("Enter mobile: ");
		while (!pattern.matcher(text = StringHandler.readString()).matches()) {
			System.out.println("Invalid mobile number input. Try again");
			System.out.println("Enter mobile: ");
		}
		return text;
	}
	
	private String getEmailWithValidation() {
		String text;
		Pattern pattern = Pattern.compile("^(.+)@(\\S+)$");
		
		System.out.print("Enter email: ");
		while (!pattern.matcher(text = StringHandler.readString()).matches()) {
			System.out.println("Invalid email input. Try again");
			System.out.println("Enter email: ");
		}
		return text;
	}
}
