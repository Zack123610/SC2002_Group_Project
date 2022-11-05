package main;

import java.util.List;

import cineplex.cinema.AbstractCinema;
import cineplex.cinema.Seat;

public interface ICinemaController {
	public Seat bookSeat(AbstractCinema cinema);
	public void displayCineplex(List<AbstractCinema> list);
	public AbstractCinema selectCinema(List<AbstractCinema> list);
}
