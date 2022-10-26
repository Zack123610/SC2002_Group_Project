package cineplex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import input.FileController;
import main.MOBLIMA;
import movie.showtime.Showtime;

public class CineplexController {
	private List<Cineplex> cineplexes;
	private Map<UUID, Cineplex> hm = new HashMap<>();
	
	public CineplexController() {
		cineplexes = FileController.read(System.getProperty("user.dir") + "\\data\\cineplex\\");
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
		FileController.write(cineplexes, System.getProperty("user.dir") + "\\data\\cineplex\\");
		System.out.println("Cineplex Controller exited successfully!");
	}
	
	public Cineplex getCineplexByID(UUID id) {
		return hm.containsKey(id) ? hm.get(id) : null;
	}
	
//	public static void main(String[] args) {
//		CineplexController cineplexController = new CineplexController();
//		System.out.println("SUCCESS");
//	}
	
}
