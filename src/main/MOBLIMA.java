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
	public static ICustomerController customerController = new CustomerController();
	public static IAdminController adminController       = new AdminController();
	public static ISettingsController settingsController = new SettingsController();
	public static IBookingController bookingController   = new BookingController();
	public static ICineplexController cineplexController = new CineplexController();
	public static ICinemaController cinemaController     = new CinemaController();
	public static IMovieController movieController       = new MovieController();
	public static IReviewController reviewController     = new ReviewController();
	public static IShowtimeController showtimeController = new ShowtimeController();
	public static ITicketController ticketController     = new TicketController();
	
	/**
	 * Initialises the required controllers.
	 */
	private static void initAll() {
		cineplexController.init();
		showtimeController.init();
	}
	
	/**
	 * Exits all required controllers
	 */
	private static void exitAll() {
		movieController.exit();
		showtimeController.exit();
		customerController.exit();
	}
	
	/**
	 * Displays the main menu
	 */
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
			
			switch (NumberHandler.readInt(1, 3)) {
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
