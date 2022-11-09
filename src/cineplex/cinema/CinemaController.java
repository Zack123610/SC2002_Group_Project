package cineplex.cinema;

import java.util.List;

import input.NumberHandler;
import input.StringHandler;
import main.ICinemaController;

/**
 * The CinemaController class provides implementation of the ICinemaController interface
 */
public class CinemaController implements ICinemaController {
	
	/**
	 * Books a seat in a cinema based on user selection
	 * @param cinema is the cinema selected
	 * @return a {@code Seat} object
	 */
	public Seat bookSeat(AbstractCinema cinema){
		cinema.displaySeatingLayout();
		System.out.println("Select Seat (row col)");
		
		System.out.print("Enter row number: ");
		char row = StringHandler.readCharacter();
		
		System.out.print("Enter col number: ");
		int col = NumberHandler.readInt();
		return cinema.selectSeat(row, col-1);
	}
	
	/**
	 * Displays all Cinemas
	 * @param list is a list of {@code AbstractCinema}
	 */
	public void displayCineplex(List<AbstractCinema> list) {
		System.out.println("--- Display Cinemas ---");
		for (int i=0; i<list.size(); i++)
			System.out.printf("%d) %s\n", i+1, list.get(i).getCinemaCode());
	}
	
	/**
	 * Displays a list of {@code AbstractCinema} and prompts the user to select one
	 * @param list is a list of {@code AbstractCinema}
	 * @return a cinema selected
	 */
	public AbstractCinema selectCinema(List<AbstractCinema> list) {
		list.sort((a,b) -> a.getCinemaCode().compareTo(b.getCinemaCode()));
		displayCineplex(list);
		System.out.print("Enter Choice (0 to cancel): ");
		int choice = NumberHandler.readInt(list.size());
		return choice == 0 ? null : list.get(choice - 1);
	}
}
