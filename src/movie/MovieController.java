package movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Scanner;

import input.FileController;

public class MovieController {
	private List<Movie> movies;
	private Map<UUID, Movie> hm = new HashMap<>();
	
	// Initialisation Code
	public MovieController() {
		movies = FileController.read("./data/movie/");
		for (Movie movie : movies) 
			hm.put(movie.getID(), movie);
	}
	public void init() {
		System.out.println("Movie Controller initialised successfully!");
	}
	public void exit() {
		FileController.write(movies, "./data/movie/");
		System.out.println("Movie Controller exited successfully!");
	}	
	public Movie getMovieByID(UUID id) {
		return hm.containsKey(id) ? hm.get(id) : null;
	}
	public Movie selectMovie()
	{
		int index = 0;
		Scanner sc = new Scanner(System.in);
		for(Movie movie : movies)
			movie.displayFullDetails();
		System.out.println("Enter which movie to select: ,Starting from index 1");
		index = sc.nextInt();
		index -=1;
		return movies.get(index);
	}
	
}
