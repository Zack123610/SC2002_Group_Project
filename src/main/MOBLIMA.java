package main;
import admin.*;
import booking.BookingController;
import cineplex.CineplexController;
import cineplex.cinema.CinemaController;
import customer.*;
import input.*;
import movie.MovieController;
import movie.review.ReviewController;
import movie.showtime.ShowtimeController;
import movie.ticket.TicketController;

public class MOBLIMA {
// Note: Change them into interfaces after whole project done
	
	public static CustomerController customerController;
	public static AdminController adminController;
	public static SettingsController settingsController;
	public static BookingController bookingController;
	public static CineplexController cineplexController;
	public static CinemaController cinemaController;
	public static MovieController movieController;
	public static ReviewController reviewController;
	public static ShowtimeController showtimeController;
	public static TicketController ticketController;
	
	// Initialise all controllers
	private static void initAll() {
		customerController = new CustomerController();
		adminController = new AdminController();
		settingsController = new SettingsController();
		bookingController = new BookingController();
		cineplexController = new CineplexController();
		cinemaController = new CinemaController();
		movieController = new MovieController();
		reviewController = new ReviewController();
		showtimeController = new ShowtimeController();
		ticketController = new TicketController();
	
		
		cineplexController.init();
		//cinemaController.init();
		reviewController.init();
		movieController.init();
		//ticketController.init();
		showtimeController.init();
		bookingController.init();
		settingsController.init();
	}
	
	// Exit all controllers
	private static void exitAll() {
		movieController.exit();
		reviewController.exit();
	}
	
	private static void displayMainMenu() {
		System.out.println(
				"======================= Welcome to MOBLIMA =======================\n" +
				"1) I am an admin\n" +
				"2) I am a customer\n" +
				"3) Exit");
		System.out.print("Please select an option: ");
	}
	
	public static void main(String[] args) {
		initAll();
		
		boolean done = false;
		do {
			displayMainMenu();
			
			switch (IntegerHandler.readInt(1, 3)) {
			case 1: 
				adminController.run();
				break;
				
			case 2:
				customerController.run();
				break;
				
			case 3:
				System.out.println("Quitting MOBLIMA application. Thank you for using!");
				done = true;
			}
			
		} while (!done);
		
		exitAll();
	}
}
