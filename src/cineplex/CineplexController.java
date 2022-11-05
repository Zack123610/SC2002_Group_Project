package cineplex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import input.FileController;
import input.NumberHandler;
import main.ICineplexController;
import main.MOBLIMA;
import movie.showtime.Showtime;

/**
 * The CineplexController class provides implementation for the ICineplexController interface
 */
public class CineplexController implements ICineplexController {

	/**
	 * A list of {@code Cineplex}
	 */
	private List<Cineplex> cineplexes;

	/**
	 * A map of UUIDs and cineplexes
	 */
	private Map<UUID, Cineplex> hm = new HashMap<>();
	
	// Initialisation Code
	/**
	 * Contructor for CineplexController which calls {@code FileController} to read cineplex data files
	 * and creates a list of {@code Cineplex} and adds them to the map
	 */
	public CineplexController() {
		cineplexes = FileController.read("./data/cineplex/");
		for (Cineplex cineplex : cineplexes) 
			hm.put(cineplex.getID(), cineplex);
	}
	/**
	 * Initializes each {@code Cineplex} from the list by adding their showtime information.
	 * It is executed at the beginning of the program
	 */
	public void init() {
		for (Cineplex cineplex : cineplexes) {
			ArrayList<Showtime> temp = new ArrayList<>();
			for (Showtime showtime : cineplex.getShowTimes())
				temp.add(MOBLIMA.showtimeController.getShowtimeByID(showtime.getID()));
			cineplex.setShowTimes(temp);
		}
	}
	
	/**
	 * Calls {@code FileController} to write all {@code Cineplex} in the cineplex list back to the data files
	 */
	public void exit() {
		FileController.write(cineplexes, "./data/cineplex/");
	}

	/**
	 * Gets the {@code Cineplex} associated with a certain UUID
	 * @return a {@code Cineplex} if there is a match or {@code null} if there is none
	 */
	public Cineplex getCineplexByID(UUID id) {
		return hm.containsKey(id) ? hm.get(id) : null;
	}
	
	// Controller methods
	/**
	 * Displays all {@code Cineplex} in the list of cineplexes
	 */
	public void displayCineplex(List<Cineplex> list) {
		System.out.println("--- Display Cineplexes ---");
		for (int i=0; i<list.size(); i++)
			System.out.printf("%d) %s\n", i+1, list.get(i).getName());
	}
	
	/**
	 * Selects a {@code Cineplex} from the list ||||(IDK)
	 * @return a {@code Cineplex} that was selected
	 */
	public Cineplex selectCineplex() {
		return selectCineplex(cineplexes);
	}
	
	/**
	 * Displays the list of cineplexes and prompts the user to select {@code Cineplex} from the list
	 * @return a {@code Cineplex} that was selected 
	 */
	public Cineplex selectCineplex(List<Cineplex> list) {
		displayCineplex(list);
		System.out.print("Enter Choice (0 to cancel): ");
		int choice = NumberHandler.readInt(list.size());
		return choice == 0 ? null : list.get(choice - 1);
	}
}
