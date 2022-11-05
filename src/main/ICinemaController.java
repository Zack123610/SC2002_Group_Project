package main;

import cineplex.cinema.AbstractCinema;
import cineplex.cinema.Seat;

public interface ICinemaController {
    public Seat bookSeat(AbstractCinema cinema);

}
