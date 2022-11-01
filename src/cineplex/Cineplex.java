package cineplex;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cineplex.cinema.Cinema;
import globals.Writable;
import movie.showtime.Showtime;


public class Cineplex extends Writable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8543460754888135256L;
	private String name;
	private List<UUID> showTimeIDList; // For showTime IDs
	private List<Showtime> showTimes; // ArrayList for showTime
	private List<Cinema> cinemaList;  // ArrayList for cinemas
	
	// Constructor
	public Cineplex() {}
	public Cineplex(String name) {
		this.name = name;
		showTimes = new ArrayList<>(); //edited
		showTimeIDList = new ArrayList<>(); //added
		cinemaList = new ArrayList<>();
	}
	
	// Methods
	public String getName() { return name; }
	public List<UUID> getShowTimeIDList() { return showTimeIDList; }
	public List<Showtime> getShowTimes() { return showTimes; }
	public List<Cinema> getCinemaList() { return cinemaList; }
	
	public void setShowTimes(List<Showtime> showTimes) { this.showTimes = showTimes; }
	public void setCinemaList(List<Cinema> cinemaList) { this.cinemaList = cinemaList; }
	
	public void addShowTime(Showtime showTime) { showTimes.add(showTime); }
	public void addCinema(Cinema cinema) {
		cinemaList.add(cinema);
	}
}
