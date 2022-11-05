package main;

import movie.Movie;

public interface ICustomerController {
    public void exit() ;
    public void run();
    public void displayMovieOptions();
    public void handleMovieOptions(Movie movie);
}


