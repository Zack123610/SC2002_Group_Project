package cineplex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import cineplex.cinema.Cinema;
import input.FileController;
import main.MOBLIMA;
import movie.Movie;
import movie.showtime.Showtime;

public class CineplexController {
	private List<Cineplex> cineplexes;
	private Map<UUID, Cineplex> hm = new HashMap<>();

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

	public void test() {
		for (Cineplex cineplex : cineplexes)
			for (Cinema cinema : cineplex.getCinemaList())
				cinema.displaySeatingLayout();
	}

	public Cineplex getCineplexByID(UUID id) {
		return hm.containsKey(id) ? hm.get(id) : null;
	}

	public Cineplex selectCineplex(ArrayList<Cineplex> list){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Choice: ");
		int choice = sc.nextInt();
		Cineplex c = list.get(choice -1 );
		return c;
	}

	// public static void main(String[] args) {
	// CineplexController cineplexController = new CineplexController();
	// System.out.println("SUCCESS");
	// }

}
