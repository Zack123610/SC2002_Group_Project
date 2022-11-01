package customer;

import java.util.List;

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
				"7) Search Movie\n" +
				"8) Quit");
		System.out.print("Please select an option: ");
	}
	
	public void run() {
		boolean done = false;
		boolean bookingFlag = false;
		Movie selected=null;
		do {
			int choice ;
			if(bookingFlag == true){
				choice = 5;
			}
			else{
				displayCustomerMenu();
				choice =IntegerHandler.readInt(1, 8);
			}
			switch (choice) {
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
				if(bookingFlag == true){
					MOBLIMA.bookingController.doBooking(customer, selected);
				}
				else{
					MOBLIMA.bookingController.doBooking(customer);
				}
				bookingFlag = false;
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
			//search movie->return movie->
				selected = MOBLIMA.movieController.searchMovie();
				if(selected!=null){
					bookingFlag = MOBLIMA.movieController.movieOptions(selected);
				}
				break;
				
				
				
			case 8:
				System.out.println("Exiting Admin Application ...");
				done = true;
			}
			
		} while (!done);
	}
}
