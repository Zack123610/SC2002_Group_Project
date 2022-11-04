package admin;

import input.IntegerHandler;
import input.StringHandler;
import main.MOBLIMA;

/**
 * This class contains the methods used by the admin
 */
public class AdminController implements IAdminController{
	/** Default system password */
	private String password = "admin";
	
	/**
	 * This method displays the UI for the admin
	 */
	private void displayAdminMenu() {
		System.out.println(
				"======================= Admin Menu =======================\n" + 
				"1) Configure movie settings\n" + 
				"2) Configure cinema showtimes\n" +
				"3) Configure system settings\n" +
				"4) Configure top 5 display settings\n" +
				"5) Change password\n" +
				"6) Exit");
		System.out.print("Please select an option: ");
	}

	/** Gets the users selection and runs the necessary function */
	public void run() {
//		Comment out for convenience, uncomment when done
//		if (!login())
//			return;
		
		boolean done = false;
		do {
			displayAdminMenu();
			
			switch (IntegerHandler.readInt(1, 6)) {
			case 1:
				configureMovies();
				break;

			case 2:
				configureShowtimes();
				break;
				
			case 3:
				MOBLIMA.settingsController.run();
				break;
				
			case 4:
				configureTop5();
				break;
				
			case 5:
				changePassword();
				break;
				
			case 6:
				System.out.println("Exiting Admin Application ...");
				done = true;
			}
			
		} while (!done);
	}
	
	/**
	 * This method prompts user to enter a password
	 * @return true if the password matches
	 */
	private boolean login() {
		System.out.print("Enter password: ");
		boolean isValid = StringHandler.readString().equals(password);
		
		if (!isValid) 
			System.out.println("Wrong password. Exiting.");
		return isValid;
	}
	/** This method changes the password */
	private void changePassword() {
		System.out.print("Enter new password: ");
		password = StringHandler.readString();
	}
	
	
	/** 
	 * This method is called when admin configures movie settings
	 * The admin can choose to create, update, remove a movie listing or delete a review
	 */
	private void configureMovies() {
		boolean done = false;
		do {
			System.out.println(
					   "Configuring Movie Listing...\n" +
					   "1) Create new movie listing\n" + 
					   "2) Update movie listing\n" +
					   "3) Remove movie listing\n" +
					   "4) Delete review\n" +
					   "5) Back");
			System.out.print("Please select an option: ");
			
			switch (IntegerHandler.readInt(1, 5)) {
			case 1:
				MOBLIMA.movieController.createMovie();
				break;

			case 2:
				MOBLIMA.movieController.updateMovie();
				break;
				
			case 3:
				MOBLIMA.movieController.deleteMovie();
				break;
				
			case 4:
				MOBLIMA.reviewController.deleteReview();
				break;
				
			case 5:
				done = true;
				break;
			}
		} while (!done);
	}
	/** 
	 * This method is called when admin configures showtimes
	 * The admin can choose to create, update or remove a showtime
	 */
	private void configureShowtimes() {
		boolean done = false;
		do {
			System.out.println("Configuring Cinema Showtimes...\n" +
					   "1) Create new showtime\n" + 
					   "2) Update existing showtime\n" +
					   "3) Remove existing showtime\n" +
					   "4) Back");
			System.out.print("Please select an option: ");
			
			switch (IntegerHandler.readInt(1, 4)) {
			case 1:
				MOBLIMA.showtimeController.createShowtime();
				break;

			case 2:
				MOBLIMA.showtimeController.updateShowtime();
				break;
				
			case 3:
				MOBLIMA.showtimeController.deleteShowtime();
				break;
				
			case 4:
				done = true;
				break;
			}
		} while (!done);
	}
	/** 
	 * This method is called when admin configures the top 5 movies
	 * The admin can choose to either display the movies in the order or ticket sales or ratings
	 */
	private void configureTop5() {
		byte num = MOBLIMA.movieController.getTopFiveFilter();
		int flag;
		
		do {
			System.out.println("--- Current Top 5 Display Status ---");
			System.out.println("Display by Ticket Sales  : " + ((num & 2) != 0 ? "Active" : "Disabled"));
			System.out.println("Display by Overall Rating: " + ((num & 1) != 0 ? "Active" : "Disabled"));
			
			System.out.println();
			System.out.print("Select 2 to toggle sales, 1 to toggle rating, 0 to exit: ");
			flag = IntegerHandler.readInt(2);
			
			if (flag == 0)
				break;
			
			if ((num ^ flag) == 0)
				System.out.println("Unable to toggle. One display must be active at all times.");
			else
				num ^= flag;
		} while (true);
		
		MOBLIMA.movieController.setTopFiveFilter(num);
	}
}
