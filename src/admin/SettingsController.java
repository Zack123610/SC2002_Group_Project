package admin;

import cineplex.cinema.PlatinumCinema;
import customer.Age;
import input.NumberHandler;
import main.ISettingsController;
import movie.Genre;
import movie.showtime.Holiday;
import movie.ticket.Ticket;

/**
 * The settings controller class provides implementation of the ISettingsController interface
 */
public class SettingsController implements ISettingsController {
	
	/** 
	 * This method displays the system setting menu
	 */
	private void displaySystemMenu() {
		System.out.println(
				"\n======================= System Settings =======================\n" + 
				"1) Update Base Ticket price\n" + 
				"2) Update Genre multiplier\n" + 
				"3) Update Age multiplier\n" + 
				"4) Update Holiday multiplier\n" + 
				"5) Update Platinum Cinema multiplier\n" + 
				"6) Exit");
		System.out.print("Please select an option: ");
	}
	

	public void run() {
		boolean done = false;
		
		do {
			displaySystemMenu();
			
			switch (NumberHandler.readInt(1, 6)) {
			case 1:
				System.out.printf("Current base ticket price is $%.2f\n", Ticket.getBasePrice());
				System.out.print("Enter new base ticket price: ");
				Ticket.setBasePrice(NumberHandler.readDouble());
				System.out.printf("New base ticket price is $%.2f\n", Ticket.getBasePrice());
				break;

			case 2:
				Genre[] genres = Genre.class.getEnumConstants();
				System.out.println("--- Display All Genres ---");
				for (int i=0; i<genres.length; i++)
					System.out.printf("%2d) %-15s | Multiplier: %.2f\n", i+1, genres[i], genres[i].getMultiplier());
				
				System.out.print("Please select a genre (0 to cancel): ");
				int idx = NumberHandler.readInt(genres.length);
				
				if (idx == 0)
					break;
				
				Genre genre = genres[idx-1];
				System.out.print("Enter new multiplier: ");
				genre.setMultiplier(NumberHandler.readDouble());
				System.out.printf("New multiplier for %s is %.2f\n", genre, genre.getMultiplier());
				break;
				
			case 3:
				System.out.println("Select age group: \n" +
								   "1) Senior Citizen\n" +
								   "2) Adult\n" +
								   "3) Child\n" +
								   "4) Back");
				
				Age curr = switch (NumberHandler.readInt(1, 4)) {
				case 1 -> Age.SENIOR;
				case 2 -> Age.ADULT;
				case 3 -> Age.CHILD;
				default -> null;
				};
				
				if (curr == null)
					break;
				
				System.out.printf("Current multiplier for %s is: %.2f\n", curr.toString(), curr.getMultiplier());
				System.out.print("Enter new multipler: ");
				curr.setMultiplier(NumberHandler.readDouble());
				System.out.printf("New multiplier for %s is: %.2f\n", curr.toString(), curr.getMultiplier());
				break;
				
			case 4:
				System.out.printf("Current holiday multiplier is: %.2f\n", Holiday.CHINESE_NEWYEAR1.getMultiplier());
				System.out.print("Enter new multipler: ");
				Holiday.CHINESE_NEWYEAR1.setMultiplier(NumberHandler.readDouble());
				System.out.printf("New holiday multiplier is: %.2f\n", Holiday.CHINESE_NEWYEAR1.getMultiplier());
				break;
				
			case 5:
				PlatinumCinema temp = new PlatinumCinema("XXX");
				System.out.printf("Current Platinum Cinema multiplier is: %.2f\n", temp.getMultiplier());
				System.out.print("Enter new multipler: ");
				temp.setMultiplier(NumberHandler.readDouble());
				System.out.printf("New Platinum Cinema multiplier is: %.2f\n", temp.getMultiplier());
				break;
				
			case 6:
				System.out.println("Exiting System Settings ...");
				done = true;
			}
			
		} while (!done);
	}
}
