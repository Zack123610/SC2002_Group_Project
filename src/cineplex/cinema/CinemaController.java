package cineplex.cinema;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import input.FileController;

public class CinemaController {
	private List<AbstractCinema> cinemas;
	private Map<UUID, AbstractCinema> hm = new HashMap<>();
	
	public CinemaController() {
		cinemas = FileController.read(System.getProperty("user.dir") + "\\data\\cinema\\");
		for (AbstractCinema cinema : cinemas)
			hm.put(cinema.getID(), cinema);
	}
	
	public void init() {
		System.out.println("Cinema Controller initialised successfully!");
	}
	
	public void exit() {
		FileController.write(cinemas, System.getProperty("user.dir") + "\\data\\cinema\\");
		System.out.println("Cinema Controller exited successfully!");
	}
	
	public AbstractCinema getCinemabyID(UUID id) {
		return hm.containsKey(id) ? hm.get(id) : null;
	}
	
	
	
//	public static void main(String[] args) {
//		CinemaController test = new CinemaController();
//		
//		test.cinemas.get(0).displaySeatingLayout();
//		test.cinemas.get(0).bookSeat('A', 0);
//		test.cinemas.get(0).displaySeatingLayout();
//		FileController.write(test.cinemas, System.getProperty("user.dir") + "\\data\\cinema\\");
//	}
	
}
