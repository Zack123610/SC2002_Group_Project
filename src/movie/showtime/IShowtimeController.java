package movie.showtime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cineplex.Cineplex;
import movie.Movie;

public interface IShowtimeController {
    public void init();

    public void exit();

    public Showtime getShowtimeByID(UUID id);

    public void displayShowtimes(List<Showtime> list);

    public Showtime selectShowtime(List<Showtime> list);

    public void updateShowtime();

    public Showtime createShowtime();

    public List<Showtime> filterShowtimeByMovieAndCineplex(Movie movie, Cineplex cineplex);

    public List<Showtime> filterShowtimeByMovie(Movie movie);

    public ArrayList<Cineplex> filterCineplexByMovie(Movie movie);

    public int getUniqueDates(ArrayList<Showtime> list);

}
