package main;

import java.util.List;

import cineplex.cinema.AbstractCinema;
import cineplex.cinema.Seat;

/**
 * The ICinemaController provides the interface for CinemaController.
 */
public interface ICinemaController {

	/**
	 * Books a seat in a cinema based on user selection
	 * @param cinema is the cinema selected
	 * @return a {@code Seat} object
	 */
	public Seat bookSeat(AbstractCinema cinema);

	/**
	 * Displays all Cinemas in a list
	 * @param list is a list of {@code AbstractCinema}
	 */
	public void displayCineplex(List<AbstractCinema> list);

	/**
	 * Displays a list of {@code AbstractCinema} and prompts the user to select one
	 * @param list is a list of {@code AbstractCinema}
	 * @return a cinema selected
	 */
	public AbstractCinema selectCinema(List<AbstractCinema> list);
}
