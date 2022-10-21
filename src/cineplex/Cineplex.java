package cineplex;

import java.util.ArrayList;
import java.util.List;

import cineplex.cinema.Cinema;
import globals.Writable;


@SuppressWarnings("serial")
public class Cineplex extends Writable {
	private String name;
	private List<Cinema> cinemas;
	
	public Cineplex(String name) {
		this.name = name;
		cinemas = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addCinema(Cinema cinema) {
		cinemas.add(cinema);
	}
}
