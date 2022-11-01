package movie;

import java.time.LocalDate;
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
	public void ShowallMovie()
	{
		int indx = 0;
		for(Movie movie : movies)
		{
			indx++;
			System.out.println("Movie index = " + indx);
			movie.displayFullDetails();
		}
	}
	public Movie selectMovie()
	{
		int index = 0;
		Scanner sc = new Scanner(System.in);
		ShowallMovie();
		System.out.println("Enter which movie to select: ,Starting from index 1");
		index = sc.nextInt();
		index -=1;
		return movies.get(index);
	}
	public void addMovie(String title)
	{
		Movie temp = new Movie();
		temp.setTitle(title);
		movies.add(temp);
		System.out.println("Movie successfully added!");
	}
	public void removeMovie(String title)
	{
		for(Movie m : movies)
		{
			if (m.getTitle() == title)
			{
				m.displayFullDetails();
				movies.remove(m);
				System.out.println("Displayed Movie Successfully removed !");
			}
		}
	}
	public void updateMovie(String title)
	{
		Scanner sc = new Scanner(System.in);
		for(Movie movie : movies)
			if(movie.getTitle() == title)
			{
				System.out.println("Updating Movie...\nEnter 1 for changing title\n"+
									"Enter 2 for changing ShowStatus\nEnter 3 for changing ReleaseDate\n"+
									"Enter 4 for changing Synopsis\nEnter 5 for changing Director\n"+
									"Enter 6 for changing MovieRating\nEnter 7 for adding genre\n Enter 8 for adding Cast\n");
				int choice = 0;
				do
				{
					choice = sc.nextInt();
					switch(choice)
					{
						case 1:
						{
							System.out.println("Enter new title :");
							String newTitle = sc.next();
							movie.setTitle(newTitle);
							System.out.println("Movie title updated : " + movie.getTitle());
							break;
						}
						case 2:
						{
							System.out.println("Enter 1 for Coming soon\nEnter 2 for now Showing\n Enter 3 for End of show\n");
							int state = sc.nextInt();
							if(state == 1)
								movie.setShowStatus(ShowStatus.COMINGSOON);
							else if(state == 2)
								movie.setShowStatus(ShowStatus.NOWSHOWING);
							else if(state == 3)
								movie.setShowStatus(ShowStatus.ENDOFSHOWING);
							System.out.println("Movie ShowStatus Updated : " + movie.getShowStatus());
							break;
						}
						case 3:
						{
							System.out.println("Enter the new date: YYYY MM DD");
							int year = sc.nextInt(), month = sc.nextInt(),day = sc.nextInt();
							movie.setReleaseDate(LocalDate.of(year, month, day));
							System.out.println("Movie release date updated : " + movie.getReleaseDate());
							break;
						}
						case 4:
						{
							System.out.println("Enter the new Synopsis");
							movie.setSynopsis(sc.next());
							System.out.println("Movie Synopsis updated : " + movie.getSynopsis());
							break;
						}
						case 5:
						{
							System.out.println("Enter the new Director : ");
							movie.setDirector(sc.next());
							System.out.println("Movie Director updated : "+ movie.getDirector());
							break;
						}
						case 6:
						{
							System.out.println("Enter 1 for G\nEnter 2 for PG\nEnter 3 for PG13\nEnter 4 for NC16\nEnter 5 for M18\nEnter 6 for R21\nEnter 7 for To be announced\n");
							int c = sc.nextInt();
							if(c == 1) movie.setMovieRating(MovieRating.G);
							else if(c == 2) movie.setMovieRating(MovieRating.PG);
							else if(c == 3) movie.setMovieRating(MovieRating.PG13);
							else if(c == 4) movie.setMovieRating(MovieRating.NC16);
							else if(c == 5) movie.setMovieRating(MovieRating.M18);
							else if(c == 6) movie.setMovieRating(MovieRating.R21);
							else if(c == 7)	movie.setMovieRating(MovieRating.TBA);
							System.out.println("Movie Rating updated." + movie.getMovieRating());
							break;
						}
						case 7:
						{
							System.out.println("Enter 1 for 3D\nEnter 2 for Action\nEnter 3 for Adventure\nEnter 4 for Anime\nEnter 5 for Block Busters\n"+
							"Enter 6 for Fantasy\nEnter 7 for Horror\nEnter 8 for SCI-Fi\n");
							int c = sc.nextInt();
							if(c == 1) movie.addGenre(Genre.THREED);
							else if(c == 2) movie.addGenre(Genre.ACTION);
							else if(c == 3) movie.addGenre(Genre.ADVENTURE);
							else if(c == 4) movie.addGenre(Genre.ANIME);
							else if(c == 5) movie.addGenre(Genre.BLOCKBUSTER);
							else if(c == 6) movie.addGenre(Genre.FANTASY);
							else if(c == 7) movie.addGenre(Genre.HORROR);
							else if(c == 8) movie.addGenre(Genre.SCI_FI);
							System.out.println("Genre added successfully.");
							break;
						}
						case 8:
						{
							System.out.println("Enter name of cast: ");
							movie.addCast(sc.next());
							System.out.println("Movie cast added successfully");
							break;
						}
						default: 
							break;
					}
				}while(choice <9);
				break;
			}
	}
}
