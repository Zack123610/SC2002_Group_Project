package customer;

import input.IntegerHandler;
import input.StringHandler;
import main.MOBLIMA;
import movie.Movie;

public class CustomerController {
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
				System.out.print("Sort by ticket sales? (Y/N) ");
				MOBLIMA.movieController.listTopFive(StringHandler.readString("Y", "N").equals("Y"));
				break;

			case 3:
				Movie movie = MOBLIMA.movieController.selectMovie(false);
				movie.displayFullDetails();
				break;
				
			case 4:
				MOBLIMA.reviewController.writeReview();
				break;
				
			case 5:
				break;
				
			case 6:
				break;
				
			case 7:
				System.out.println("Exiting Admin Application ...");
				done = true;
			}
			
		} while (!done);
	}
}
