package booking;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import cineplex.Cineplex;
import cineplex.cinema.Cinema;
import cineplex.cinema.Seat;
import customer.Age;
import main.MOBLIMA;
import movie.Movie;
import movie.showtime.Day;
import movie.showtime.Showtime;
import movie.ticket.Ticket;

public class BookingController {
	public BookingController() {
		init();

	}

	public void init() {
		System.out.println("Booking Controller initialised successfully!");

	}

	public void exit() {
		System.out.println("Booking Controller exited successfully!");
	}

	public Booking doBooking() {
		// Select movie -> filter by movie -> return cineplexes -> chooses cineplex -> filter by movie and cineplex-> return showtime
		//showtime -> cinema ->choose seat->return seat ->  + Age ->Ticket
		//Ticket add to booking obj -> repeat ->return booking
		int flag = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
		String name = sc.nextLine();
		System.out.println("Enter Mobile");
		String mobile = sc.nextLine();
		System.out.println("Enter email");
		String email = sc.nextLine();
		

		ArrayList<Movie> movieList = MOBLIMA.movieController.displayMovies();
		Movie movie = MOBLIMA.movieController.selectMovie(movieList);
		System.out.println("Your choice : \n" + movie.getTitle());
			
		ArrayList<Cineplex> cineplexList = MOBLIMA.showtimeController.filterCineplexByMovie(movie);
		Cineplex cineplex = MOBLIMA.cineplexController.selectCineplex(cineplexList);
		System.out.println("Your choice : \n" + cineplex.getName());
			
		ArrayList<Showtime> showtimeList = MOBLIMA.showtimeController.filter(movie, cineplex);
		Showtime showtime = MOBLIMA.showtimeController.selectShowtime(showtimeList);
		System.out.println("Your choice : \n" + showtime.getDay().toString());
		
		Cinema cinema = MOBLIMA.showtimeController.getCinema(showtime);
		System.out.println("Cinema : " + cinema.getCinemaCode());
		Booking booking = new Booking(cinema.getCinemaCode());
		booking.setName(name);
		booking.setEmail(email);
		booking.setMobileNo(mobile);


		while (flag == 0) {
			Seat seat = MOBLIMA.cinemaController.selectSeat(cinema);
			Age age = MOBLIMA.ticketController.getAge();
			Ticket ticket = MOBLIMA.ticketController.issueTicket(age, seat, showtime);
			booking.addTicket(ticket);
			movie.addTicketSold();
			System.out.println("Make another booking? Y/N");
			
			char makeAnother = sc.next().charAt(0);
			if(makeAnother == 'Y'){
				flag = 0;
			}
			else{
				flag =1;
			}
			
		}
		System.out.println();
		booking.displayBookingInfo();
		return booking;
	}
			

	
}
