package cineplex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cineplex.cinema.AbstractCinema;
import cineplex.cinema.Cinema;
import cineplex.cinema.Seat;
import input.FileController;
import input.IntegerHandler;
import main.ICineplexController;
import main.MOBLIMA;
import movie.showtime.Showtime;

public class CineplexController implements ICineplexController {
	private List<Cineplex> cineplexes;
	private Map<UUID, Cineplex> hm = new HashMap<>();
	
	// Initialisation Code
	public CineplexController() {
		cineplexes = FileController.read("./data/cineplex/");
		for (Cineplex cineplex : cineplexes) 
			hm.put(cineplex.getID(), cineplex);
	}
	public void init() {
		for (Cineplex cineplex : cineplexes) {
			ArrayList<Showtime> temp = new ArrayList<>();
			for (Showtime showtime : cineplex.getShowTimes())
				temp.add(MOBLIMA.showtimeController.getShowtimeByID(showtime.getID()));
			cineplex.setShowTimes(temp);
		}
		System.out.println("Cineplex Controller initialised successfully!");
	}
	public void exit() {
		FileController.write(cineplexes, "./data/cineplex/");
		System.out.println("Cineplex Controller exited successfully!");
	}
	public Cineplex getCineplexByID(UUID id) {
		return hm.containsKey(id) ? hm.get(id) : null;
	}
	
	
	// Controller methods
	public void displayCineplex(ArrayList<Cineplex> list) {
		System.out.println("--- Display Cineplexes ---");
		for (int i=0; i<list.size(); i++)
			System.out.printf("%d) %s\n", i+1, list.get(i).getName());
	}
	
	public Cineplex selectCineplex(ArrayList<Cineplex> list) {
		displayCineplex(list);
		System.out.print("Enter Choice (0 to cancel): ");
		int choice = IntegerHandler.readInt(list.size());
		return choice == 0 ? null : list.get(choice - 1);
	}
}
