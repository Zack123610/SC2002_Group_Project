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

/**
 * The main driver class of the entire application.
 * @author Tan Say Hong
 *
 */
public class MOBLIMA {
	// Note: ToDo: Change them into interfaces after whole project done
	
	public static ICustomerController customerController = new CustomerController();
	public static AdminController adminController  = new AdminController();
	public static SettingsController settingsController = new SettingsController();
	public static BookingController bookingController = new BookingController();
	public static CineplexController cineplexController = new CineplexController();
	public static CinemaController cinemaController = new CinemaController();
	public static MovieController movieController = new MovieController();
	public static ReviewController reviewController = new ReviewController();
	public static ShowtimeController showtimeController = new ShowtimeController();
	public static TicketController ticketController = new TicketController();
	
	/**
	 * Initialises the required controllers.
	 */
	private static void initAll() {
		
		// adminController = new AdminController();
		// settingsController = new SettingsController();
		// bookingController = new BookingController();
		// cineplexController = new CineplexController();
		// cinemaController = new CinemaController();
		// movieController = new MovieController();
		// reviewController = new ReviewController();
		// showtimeController = new ShowtimeController();
		// ticketController = new TicketController();
	
		
		cineplexController.init();
		reviewController.init();
		movieController.init();
		showtimeController.init();
	}
	
	// Exits the required controllers
	private static void exitAll() {
		movieController.exit();
		reviewController.exit();
		showtimeController.exit();
		customerController.exit();
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
