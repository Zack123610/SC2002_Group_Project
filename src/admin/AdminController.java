package admin;

import input.NumberHandler;
import input.StringHandler;
import main.IAdminController;
import main.MOBLIMA;

/**
 * The admin controller class provides the implementation of the IAdminController class.
 * @author Tan Say Hong
 *
 */
public class AdminController implements IAdminController {
	private String password = "admin";
	private byte top5Filter = 3;
	
	/**
	 * This method displays the admin menu.
	 */
	private void displayAdminMenu() {
		System.out.println(
				"======================= Admin Menu =======================\n" + 
				"1) Configure movie settings\n" + 
				"2) Configure showtimes\n" +
				"3) Configure system settings\n" +
				"4) Configure top 5 display settings\n" +
				"5) Change password\n" +
				"6) Exit");
		System.out.print("Please select an option: ");
	}
	
	public void run() {
		if (!login())
			return;
		
		boolean done = false;
		do {
			displayAdminMenu();
			
			switch (NumberHandler.readInt(1, 6)) {
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
	 * This method handles the login when a user chooses to log in as admin
	 * @return {@code true} if the user logs in using the correct password, {@code false} otherwise.
	 */
	private boolean login() {
		System.out.print("Enter password: ");
		boolean isValid = StringHandler.readString().equals(password);
		
		if (!isValid) 
			System.out.println("Wrong password. Exiting.");
		return isValid;
	}
	/**
	 * This method changes the password. Called when the admin selects the option to change password.
	 */
	private void changePassword() {
		System.out.print("Enter new password: ");
		password = StringHandler.readString();
		System.out.println("Password changed.");
	}
	
	/**
	 * This method displays the configure movie options. The admin can then choose to create, update, delete movie or delete movie review. 
	 * Called when admin selects the option to configure movie settings. 
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
			
			switch (NumberHandler.readInt(1, 5)) {
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
	 * This method displays the configure showtimes. The admin can then choose to create, update or remove a showtime.
	 * Called when admin selects the option to configure showtimes. 
	 */
	private void configureShowtimes() {
		boolean done = false;
		do {
			System.out.println("Configuring Showtimes...\n" +
					   "1) Create new showtime\n" + 
					   "2) Update existing showtime\n" +
					   "3) Remove existing showtime\n" +
					   "4) Back");
			System.out.print("Please select an option: ");
			
			switch (NumberHandler.readInt(1, 4)) {
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
	public byte getTopFiveFilter() { return top5Filter; }
	/**
	 * This method manages the settings to configure top 5 listings. 
	 * At least one type of display will be active at all times.
	 */
	private void configureTop5() {
		int flag;
		
		do {
			System.out.println("--- Current Top 5 Display Status ---");
			System.out.println("Display by Ticket Sales  : " + ((top5Filter & 2) != 0 ? "Active" : "Disabled"));
			System.out.println("Display by Overall Rating: " + ((top5Filter & 1) != 0 ? "Active" : "Disabled"));
			
			System.out.println();
			System.out.print("Select 2 to toggle sales, 1 to toggle rating, 0 to exit: ");
			flag = NumberHandler.readInt(2);
			
			if (flag == 0)
				break;
			
			top5Filter = (byte) ((top5Filter ^ flag) == 0
					? 3 ^ top5Filter
					: top5Filter ^ flag);
		} while (true);
	}
}
