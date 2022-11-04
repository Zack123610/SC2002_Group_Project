package movie;

import java.util.UUID;

public interface IMovieController {
    public void init();

    public void exit();

    public Movie getMovieByID(UUID id);

    public void displayAllMovies() ;

    public void displayAllAvailableMovies();

    public Movie selectMovie(int flag);

    public void updateMovie();

    public void createMovie();

    public void deleteMovie();

    public byte getTopFiveFilter();

    public void setTopFiveFilter(byte num);

    public void listTopFive();
    
    public Movie searchMovie();

}
