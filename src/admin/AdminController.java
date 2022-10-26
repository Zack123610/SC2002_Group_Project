package admin;

import input.IntegerHandler;
import input.StringHandler;
import main.MOBLIMA;


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
				"2) Configure cinema showtimes\n" +
				"3) Configure system settings\n" +
				"4) List top 5 ranking movies\n" +
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
			
			switch (IntegerHandler.readInt(1, 6)) {
			case 1:
				break;

			case 2:
				break;
				
			case 3:
				MOBLIMA.settingsController.run();
				break;
				
			case 4:
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
}
