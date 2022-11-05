package cineplex;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cineplex.cinema.AbstractCinema;
<<<<<<< HEAD
import input.Writable;
=======
import cineplex.cinema.Cinema;
import globals.Writable;
>>>>>>> master
import movie.showtime.Showtime;


public class Cineplex extends Writable {

	private static final long serialVersionUID = -8543460754888135256L;
	private String name;
<<<<<<< HEAD
	private List<UUID> showTimeIDList;
	private List<Showtime> showTimes; 
	private List<AbstractCinema> cinemaList; 
=======
	private List<UUID> showTimeIDList; // For showTime IDs
	private List<Showtime> showTimes; // ArrayList for showTime
	private List<AbstractCinema> cinemaList;  // ArrayList for cinemas
>>>>>>> master
	
	public Cineplex() {}
	public Cineplex(String name) {
		this.name = name;
		showTimes = new ArrayList<>(); 
		showTimeIDList = new ArrayList<>(); 
		cinemaList = new ArrayList<>();
	}
	
	// Getters
	public String getName() { return name; }
	public List<UUID> getShowTimeIDList() { return showTimeIDList; }
	public List<Showtime> getShowTimes() { return showTimes; }
	public List<AbstractCinema> getCinemaList() { return cinemaList; }
	
	// Setters
	public void setShowTimes(List<Showtime> showTimes) { this.showTimes = showTimes; }
	public void setCinemaList(List<AbstractCinema> cinemaList) { this.cinemaList = cinemaList; }
	
	// Adders
	public void addShowTime(Showtime showTime) { showTimes.add(showTime); }
	public void addCinema(AbstractCinema cinema) {
		cinemaList.add(cinema);
	}
}
