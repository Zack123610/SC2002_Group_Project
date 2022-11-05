package movie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import input.FileController;
import input.NumberHandler;
import input.StringHandler;
import main.IMovieController;
import main.MOBLIMA;

/**
 * The MovieController class implements the IMovieController interface.
 * @author Tan Say Hong
 *
 */
public class MovieController implements IMovieController {
	private List<Movie> movies;
	private Map<UUID, Movie> hm = new HashMap<>();
	
	public MovieController() {
		movies = FileController.read("./data/movie/");
		for (Movie movie : movies) 
			hm.put(movie.getID(), movie);
	}
	public void exit() {
		FileController.write(movies, "./data/movie/");
	}
	public Movie getMovieByID(UUID id) {
		return hm.containsKey(id) ? hm.get(id) : null;
	}
	
	/**
	 * Method used internally to display the list of movies.
	 * @param movies list of movies to display
	 */
	private void displayMovies(List<Movie> movies) {
		System.out.println("--- Displaying Movies ---");
		for (int i=0; i<movies.size(); i++) 
			System.out.printf("%d) %s\n", i+1, movies.get(i).toString());
	}
	public void displayAllMovies() {
		displayMovies(movies);
	}
	public void displayAllAvailableMovies() {
		List<Movie> temp = movies
				.stream()
				.filter(m -> !m.isEndofShowing())
				.collect(Collectors.toList());
		displayMovies(temp);
	}
	
	/**
	 * Method used internally to select a {@code Movie} object
	 * @param movies the list of movies to select from
	 * @return a {@code Movie} object if selection was successful, null otherwise.
	 */
	private Movie selectMovie(List<Movie> movies) {
		displayMovies(movies);
		if (movies.size() == 0) {
			System.out.println("No movies available.");
			return null;
		}
		
		System.out.print("Please select a movie (0 to cancel): ");
		int idx = NumberHandler.readInt(movies.size());
		return idx == 0 ? null : movies.get(idx-1);
	}

	public Movie selectMovie(int flag) {
		List<Movie> filteredMovies = movies
				.stream()
				.filter(m -> (flag & 4) != 0 || m.getShowStatus() != ShowStatus.COMINGSOON)
				.filter(m -> (flag & 2) != 0 || m.getShowStatus() != ShowStatus.PREVIEW || m.getShowStatus() != ShowStatus.NOWSHOWING)
				.filter(m -> (flag & 1) != 0 || !m.isEndofShowing())
				.collect(Collectors.toList());
		return selectMovie(filteredMovies);
	}
	
	public Movie searchMovie() {
		List<Movie> matchList = new ArrayList<>();
		System.out.println("Enter keywords:");
		String input = StringHandler.readString();
		Pattern pattern = Pattern.compile(input, Pattern.CASE_INSENSITIVE);
		
		for(Movie movie : movies){
			Matcher matcher = pattern.matcher(movie.getTitle());
			if(matcher.find())
				matchList.add(movie);
		}
		if(matchList.size() == 0){
			System.out.println("We could not find any matching movie");
			return null;
		}
		return selectMovie(matchList);
	}
	
	public void updateMovie() {
		Movie curr = selectMovie(7);
		
		if (curr == null)
			return;

		boolean done = false;
	
		while (!done) {
			System.out.println("----- Current Movie Information ------");
			curr.displayFullDetails();
			
			System.out.println(
					"Update Movie Listing...  \n" +
                    "1) Edit Title            \n" +
                    "2) Edit Genres           \n" +
                    "3) Edit Director	      \n" +
                    "4) Edit Casts            \n" +
                    "5) Edit Synopsis         \n" +
                    "6) Edit Movie Rating     \n" +
                    "7) Edit Showing Status   \n" +
                    "8) Edit Release Date     \n" +
                    "0) Back");
			System.out.print("Please select an option: ");
			
			switch (NumberHandler.readInt(8)) {
			case 0:
				done = true;
				break;
			
			case 1:
				addTitleToMovie(curr);
				break;
				
			case 2:
				curr.clearGenres();
				addGenresToMovie(curr);
				break;
				
			case 3:
				System.out.print("Enter new director name: ");
				curr.setDirector(StringHandler.readString());
				break;
				
			case 4:
				curr.clearCasts();
				addCastsToMovie(curr);
				break;
				
			case 5:
				System.out.print("Enter new synopsis: ");
				curr.setSynopsis(StringHandler.readString());
				break;
				
			case 6:
				addMovieRatingToMovie(curr);
				break;
				
			case 7:
				addShowStatusToMovie(curr);
				break;
				
			case 8:
				addReleaseDateToMovie(curr);
				break;
			}
		}
	}
	/**
	 * This method sets the title of the movie. A duplication check is enforced such that no two movies
	 * have the same title. Called when updating or creating a movie.
	 * @param movie the {@code Movie} to set the new title.
	 */
	private void addTitleToMovie(Movie movie) {
		while (true) {			
			System.out.print("Enter new title: ");
			String title = StringHandler.readString();
			if (movies.stream().anyMatch(m -> m.getTitle().equals(title)))
				System.out.println(title + " already exists. Please choose another title.");
			else {
				movie.setTitle(title);
				return;
			}
		}
	}
	/**
	 * This method adds a specified number of genres to the movie. Called when updating or creating a movie.
	 * @param movie the {@code Movie} to add the genres into.
	 */
	private void addGenresToMovie(Movie movie) {
		List<Genre> availGenres = new ArrayList<>(Arrays.asList(Genre.values()));
		
		System.out.print("Enter number of new genres to add: ");
		for (int i=0, num = NumberHandler.readInt(), idx; i<num; i++) {
			if (availGenres.size() == 0) {
				System.out.println("No more available genres to add. Exiting ");
				break;
			}
			
			System.out.println("--- Available Genres ---");
			
			for (int j=0; j<availGenres.size(); j++)
				System.out.printf("%d) %s\n", j+1, availGenres.get(j));
			
			System.out.print("Select an option: ");
			idx = NumberHandler.readInt(1, availGenres.size()) - 1;
			movie.addGenre(availGenres.remove(idx));
		}
	}
	/**
	 * This method adds a specified number of casts to the movie. Called when updating or creating a movie.
	 * @param movie the {@code Movie} to add cast into.
	 */
	private void addCastsToMovie(Movie movie) {
		System.out.print("Enter number of new cast to add: ");
		for (int i=0, num = NumberHandler.readInt(); i<num; i++) {
			System.out.printf("Enter name of cast member %d: \n", i+1);
			movie.addCast(StringHandler.readString());
		}
	}
	/**
	 * This method sets the {@code MovieRating} attribute of a movie. Called when updating or creating a movie.
	 * @param movie the {@code Movie} to set the movie rating.
	 */
	private void addMovieRatingToMovie(Movie movie) {
		MovieRating[] movieRatings = MovieRating.class.getEnumConstants();

		for (int i=0; i<movieRatings.length; i++)
			System.out.printf("%d) %s\n", i+1, movieRatings[i]);
		System.out.print("Please select a movie rating: ");
		movie.setMovieRating(movieRatings[NumberHandler.readInt(1, movieRatings.length) - 1]);
	}
	/**
	 * This method sets the {@code ShowStatus} attribute of a movie. Called when updating or creating a movie.
	 * @param movie the {@code Movie} to set the show status.
	 */
	private void addShowStatusToMovie(Movie movie) {
		ShowStatus[] showStatus = ShowStatus.class.getEnumConstants();
		
		for (int i=0; i<showStatus.length; i++)
			System.out.printf("%d) %s\n", i+1, showStatus[i]);
		System.out.print("Please select a show status: ");
		movie.setShowStatus(showStatus[NumberHandler.readInt(1, showStatus.length) - 1]);
	}
	/**
	 * This method sets the {@code releaseDate} attribute of a movie. Called when updating or creating a movie.
	 * A validation check is included to ensure the input follows the specified format (DD/MM/YYYY)
	 * @param movie the {@code Movie} to set the show status.
	 */
	private void addReleaseDateToMovie(Movie movie) {
		boolean done = false;
		
		do {
			try {
				System.out.print("Enter new release date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(StringHandler.readString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				movie.setReleaseDate(date);
				done = true;
			} catch (DateTimeParseException e) {
				System.out.println("Error. Invalid date format. Try again.");
			}
		} while (!done);
	}
	
	public void createMovie() { 
		Movie movie = new Movie();
		System.out.println("Creating new movie...");
		
		// Set title
		addTitleToMovie(movie);
		
		// Add genres
		addGenresToMovie(movie);
		
		// Set director
		System.out.print("Enter director: ");
		movie.setDirector(StringHandler.readString());
		
		// Add casts
		addCastsToMovie(movie);
		
		// Set synopsis
		System.out.print("Enter synopsis: ");
		movie.setSynopsis(StringHandler.readString());
		
		// Add movie rating
		addMovieRatingToMovie(movie);
			
		// Add show status
		addShowStatusToMovie(movie);
		
		// Add release date
		addReleaseDateToMovie(movie);
		
		// Confirmation check
		System.out.println("----- Current Movie Information ------");
		movie.displayFullDetails();
		
		System.out.print("You are about to create a new movie listing. Please confirm (Y/N): ");
		if (StringHandler.readString("Y", "N").equals("N")) {
			System.out.println("Movie not created.");
			return;
		}
		
		System.out.println("New movie listing successfully created");
		movies.add(movie);
	}

	public void deleteMovie() {
		Movie curr = selectMovie(7);
		
		if (curr == null)
			return;
		
		System.out.println(curr.toString());
		System.out.print("You are about to remove this movie listing. Please confirm (Y/N): ");
		
		if (StringHandler.readString("Y", "N").equals("N"))
			return;
		
		System.out.println("Movie listing removed");
		curr.setShowStatus(ShowStatus.ENDOFSHOWING);
	}

	public void listTopFive() {		
		byte top5Filter = MOBLIMA.adminController.getTopFiveFilter();
		Movie[] temp = new Movie[movies.size()];
		movies.toArray(temp);
		
		if ((top5Filter & 2) != 0) {
			System.out.println("\n--- Displaying top 5 movies by tickets sold --- ");
			Arrays.sort(temp, (a, b) -> b.getTicketsSold() - a.getTicketsSold());
			
			for (int i=0; i<Math.min(5, temp.length); i++)
				System.out.printf("%d) %-30s | Tickets sold: %d\n", i+1, temp[i].getTitle(), temp[i].getTicketsSold());	
		} 
		
		if ((top5Filter & 1) != 0) {
			System.out.println("\n--- Displaying top 5 movies by overall rating --- ");
			Arrays.sort(temp, (a, b) -> b.getOverallRating() >= a.getOverallRating() ? 1 : -1);
			
			for (int i=0; i<Math.min(5, temp.length); i++)
				System.out.printf("%d) %-30s | Rating: %.2f\n", i+1, temp[i].getTitle(), temp[i].getOverallRating());			
		}
		System.out.println();
	}
}
