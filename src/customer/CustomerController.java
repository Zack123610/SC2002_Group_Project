package customer;

import input.IntegerHandler;

public class CustomerController {
	private void displayCustomerMenu() {
		System.out.println(
				"======================= Customer Menu =======================\n" + 
				"1) List all available movies\n" + 
				"2) View single movie details\n" +
				"3) Make a booking\n" +
				"4) View booking history\n" +
				"5) List top 5 ranking movies\n" +
				"6) Exit");
		System.out.print("Please select an option: ");
	}
	
	public void run() {
		boolean done = false;
		do {
			displayCustomerMenu();
			
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
				System.out.println("Exiting Admin Application ...");
				done = true;
			}
			
		} while (!done);
	}
}
