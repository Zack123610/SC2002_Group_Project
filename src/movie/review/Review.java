package movie.review;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import globals.Writable;
import input.FileController;
import movie.Movie;
import movie.MovieController;


public class Review extends Writable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5785020867407651793L;
	private Movie movie;
	private int rating;
	private String description;
	
	public Review() { }
	public Review(Movie movie, int rating, String description) {
		this.movie = movie;
		this.rating = rating;
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return String.format("%d★\n%s", rating, description);
	}
	
	public Movie getMovie() { return movie; }
	public String getDescription() { return description; }
	public int getRating() { return rating; }
	
	public void setMovie(Movie movie) { this.movie = movie; }
	public void setDescription(String description) { this.description = description; }
	public void setRating(int rating) { this.rating = rating; }
	
	
//	public static void main(String[] args) {
//		String filepath = "./data/init/reviews/";
//		MovieController mc = new MovieController();
//		Movie movie;
//		String description;
//		int rating;
//		List<Review> toSer = new ArrayList<>();
//		
//		try {
//			File[] files = new File(filepath).listFiles();
//			
//			for (File file : files) {
//				FileReader frStream = new FileReader(file);
//				BufferedReader brStream = new BufferedReader(frStream);
//	
//				movie = mc.getMovieByID(UUID.fromString(brStream.readLine()));
//				rating = Integer.parseInt(brStream.readLine());
//				description = brStream.readLine().replace("|", "\n") + "\n";
//				
//				toSer.add(new Review(movie, rating, description));
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found");
//		} catch (IOException e) {
//			System.out.println("Error initializing stream");
//			e.printStackTrace();
//		} catch (Exception e) {
//			System.out.println("An error has occured");
//		}
//		
//		for (var element: toSer) {
//			System.out.println("ID: " + element.getID());
//			System.out.println(element.toString());
//		}
//		
//		FileController.write(toSer, "./data/review/");
//	}
}
