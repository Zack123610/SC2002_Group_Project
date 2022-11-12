package main;

import java.util.List;
import java.util.UUID;

import cineplex.Cineplex;

/**
 * The ICineplexController provider interface for the CineplexController
 */
public interface ICineplexController {

	/**
	 * Initializes each {@code Cineplex} from the list by adding their showtime information.
	 * It is executed at the beginning of the program
	 */
    public void init();

    /**
	 * Calls {@code FileController} to write all {@code Cineplex} in the cineplex list back to the data files
	 */
    public void exit();

    /**
	 * Gets the {@code Cineplex} associated with a certain UUID
	 * @return a {@code Cineplex} if there is a match or {@code null} if there is none
	 */
    public Cineplex getCineplexByID(UUID id);
    
    /**
	 * Displays all {@code Cineplex} in the list of cineplexes
	 */
    public void displayCineplex(List<Cineplex> list);

    /**
	 * Selects a {@code Cineplex} from a list of all cineplexes
	 * @return a {@code Cineplex} that was selected
	 */
    public Cineplex selectCineplex();

	/**
	 * Displays the list of cineplexes and prompts the user to select {@code Cineplex} from the list
	 * @return a {@code Cineplex} that was selected 
	 */
    public Cineplex selectCineplex(List<Cineplex>list);
}