package admin;

import input.IntegerHandler;
import input.StringHandler;
//import movie.MovieController;

// Note: Might want to consider splitting up all the different menu options
//       into separate classes


public class AdminController {
	private String password = "admin";
	
	
	private boolean login() {
		System.out.print("Enter password: ");
		boolean isValid = StringHandler.readString().equals(password);
		
		if (!isValid) 
			System.out.println("Wrong password. Exiting.");
		return isValid;
	}
	
	
	private void changePassword() {
		System.out.print("Enter new password: ");
		password = StringHandler.readString();
	}
	
	private void displayAdminMenu() {
		System.out.println(
				"======================= Admin Menu =======================\n" + 
				"1) Configure movie settings\n" + 
				"2) Create/Update/Remove cinema showtimes and the movies to be shown\n" +
				"3) Change password\n" +
				"4) Exit");
		System.out.print("Please select an option: ");
	}
	
	public void run() {
		if (!login())
			return;
		
		boolean done = false;
		do {
			displayAdminMenu();
			
			switch (IntegerHandler.readInt(1, 4)) {
			case 1:
				//MovieHandler.get().runAdmin();
				//movieHandler.runAdmin();
				break;

			case 2:
				break;
				
			case 3:
				changePassword();
				break;
				
			case 4:
				System.out.println("Exiting Admin Application ...");
				done = true;
			}
			
		} while (!done);
	}
}
