package main;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> master
import java.util.List;
import java.util.UUID;

import cineplex.Cineplex;
import movie.Movie;
import movie.showtime.Showtime;

public interface IShowtimeController {
<<<<<<< HEAD
		public void init();
		public void exit();
		public Showtime getShowtimeByID(UUID id);
		
		
		public void displayShowtimes(List<Showtime> list);
		public Showtime selectShowtime(List<Showtime> list);
		public void updateShowtime();
		public void createShowtime();
		public void deleteShowtime();
		
		public List<Showtime> filterShowtimeByMovieAndCineplex(Movie movie, Cineplex cineplex);
		public List<Showtime> filterShowtimeByMovie(Movie movie);		
		public List<Cineplex> filterCineplexByMovie(Movie movie);
=======
    public void init();

    public void exit();

    public Showtime getShowtimeByID(UUID id);

    public void displayShowtimes(List<Showtime> list);

    public Showtime selectShowtime(List<Showtime> list);

    public void updateShowtime();

    public void createShowtime();

    public void deleteShowtime();

    public List<Showtime> filterShowtimeByMovieAndCineplex(Movie movie, Cineplex cineplex);

    public List<Showtime> filterShowtimeByMovie(Movie movie);

    public ArrayList<Cineplex> filterCineplexByMovie(Movie movie);


>>>>>>> master
}
