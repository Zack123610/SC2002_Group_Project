package customer;

import booking.Booking;
import input.IntegerHandler;
import input.StringHandler;
import main.MOBLIMA;
import movie.Movie;

public class CustomerController {
	private Customer customer = new Customer();
	
	private void displayCustomerMenu() {
		System.out.println(
				"======================= Customer Menu =======================\n" + 
				"1) List all available movies\n" + 
				"2) List top 5 ranking movies\n" +
				"3) View single movie details\n" +
				"4) Leave a movie review\n" +
				"5) Make a booking\n" +
				"6) View booking history\n" +
				"7) Exit");
		System.out.print("Please select an option: ");
	}
	
	public void run() {
		boolean done = false;
		do {
			displayCustomerMenu();
			
			switch (IntegerHandler.readInt(1, 7)) {
			case 1:
				MOBLIMA.movieController.displayAllAvailableMovies();
				break;
				
			case 2:
				MOBLIMA.movieController.listTopFive();
				break;

			case 3:
				Movie movie = MOBLIMA.movieController.selectMovie(6);
				if (movie != null)
					movie.displayFullDetails();
				break;
				
			case 4:
				MOBLIMA.reviewController.writeReview();
				break;
				
			case 5:
				MOBLIMA.bookingController.doBooking(customer);
				break;
				
			case 6:
				customer.displayParticulars();
				System.out.println("--- View Booking History ---");
				if (customer.getBookings().size() == 0) {
					System.out.println("Booking history is empty");
					break;
				}
				customer.getBookings().forEach(Booking::displayBookingInfo);
				break;
				
			case 7:
				System.out.println("Exiting Admin Application ...");
				done = true;
			}
			
		} while (!done);
	}
}
