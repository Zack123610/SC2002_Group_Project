package admin;

import input.IntegerHandler;

public class SettingsController {
	
	// Initialisation Code
	public SettingsController() { }
	public void init() {
		System.out.println("Settings Controller initialised successfully!");
	}
	public void exit() {
		System.out.println("Settings Controller exited successfully!");
	}
	
	private void displaySystemMenu() {
		System.out.println(
				"======================= System Settings =======================\n" + 
				"1) Update Base Ticket prices\n" + 
				"2) Update Genre multiplier\n" + 
				"3) Update Age multiplier\n" + 
				"4) Update Holiday multiplier\n" + 
				"5) Update Platinum cinema multiplier\n" + 
				"6) Exit");
		System.out.print("Please select an option: ");
	}
	
	
	public void run() {
		boolean done = false;
		do {
			displaySystemMenu();
			
			switch (IntegerHandler.readInt(1, 6)) {
			case 1:
				break;

			case 2:
				break;
				
			case 3:
				break;
				
			case 4:
				break;
				
			case 5:
				break;
				
			case 6:
				System.out.println("Exiting System Settings ...");
				done = true;
			}
			
		} while (!done);
	}

	// Update ticket base price
	public void updateTicketPrice() {
		// call TicketController to change the base price of ticket
	}

	public void updateGenreMult() {
		// Choose genre to update
		// Request input for new multiplier
		// Update multiplier
	}

	public void updateAgeMult() {
		// Choose age group
		// Request input for new multiplier
		// Update multiplier
	}

	public void updateHolidayMult() {
		// Request input for new multiplier
		// Update multiplier
	}

	public void updatePlatCinemaMult() {
		// Request input for new multiplier
		// call CinemaController to update multipler || direct update multiplier
	}

}
