package customer;

import movie.Movie;

public interface ICustomerController {
    public void exit() ;
    public void run();
    public void displayMovieOptions(Movie movie);
    public void handleMovieOptions(Movie movie);
}


