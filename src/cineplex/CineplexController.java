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
	}
	public void exit() {
		FileController.write(cineplexes, "./data/cineplex/");
	}
	public Cineplex getCineplexByID(UUID id) {
		return hm.containsKey(id) ? hm.get(id) : null;
	}
	
	
	// Controller methods
	public void displayCineplex(List<Cineplex> list) {
		System.out.println("--- Display Cineplexes ---");
		for (int i=0; i<list.size(); i++)
			System.out.printf("%d) %s\n", i+1, list.get(i).getName());
	}
	
	public Cineplex selectCineplex() {
		return selectCineplex(cineplexes);
	}
	
	public Cineplex selectCineplex(List<Cineplex> list) {
		displayCineplex(list);
		System.out.print("Enter Choice (0 to cancel): ");
		int choice = NumberHandler.readInt(list.size());
		return choice == 0 ? null : list.get(choice - 1);
	}
}
