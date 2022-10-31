package admin;

import input.IntegerHandler;
import input.StringHandler;
import main.MOBLIMA;


public class AdminController {
	private String password = "admin";
	
	private void displayAdminMenu() {
		System.out.println(
				"======================= Admin Menu =======================\n" + 
				"1) Configure movie settings\n" + 
				"2) Configure cinema showtimes\n" +
				"3) Configure system settings\n" +
				"4) List top 5 ranking movies\n" +
				"5) Change password\n" +
				"6) Exit");
		System.out.print("Please select an option: ");
	}
	
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
				System.out.print("Sort by ticket sales? (Y/N) ");
				MOBLIMA.movieController.listTopFive(StringHandler.readString("Y", "N").equals("Y"));
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
	
	// Simple login method
	private boolean login() {
		System.out.print("Enter password: ");
		boolean isValid = StringHandler.readString().equals(password);
		
		if (!isValid) 
			System.out.println("Wrong password. Exiting.");
		return isValid;
	}
	// Change password
	private void changePassword() {
		System.out.print("Enter new password: ");
		password = StringHandler.readString();
	}
	
	
	private void configureMovies() {
		boolean done = false;
		do {
			System.out.println("Configuring Movie Listing...\n" +
					   "1) Create new movie listing\n" + 
					   "2) Update movie listing\n" +
					   "3) Remove movie listing\n" +
					   "4) Back");
			System.out.print("Please select an option: ");
			
			switch (IntegerHandler.readInt(1, 4)) {
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
				done = true;
				break;
			}
		} while (!done);
	}
	
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
}
