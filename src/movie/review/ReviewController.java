package movie.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import input.FileController;
import input.IntegerHandler;
import input.StringHandler;
import main.MOBLIMA;
import movie.Movie;

public class ReviewController {
	private List<Review> reviews;
	private Map<UUID, Review> hm = new HashMap<>();
	
	// Initialisation Code
	public ReviewController() {
		reviews = FileController.read("./data/review/");
	}
	public void init() {
		for (Review review : reviews) 
			review.setMovie(MOBLIMA.movieController.getMovieByID(review.getMovie().getID()));
		System.out.println("Review Controller initialised successfully!");
	}
	public void exit() {
		FileController.write(reviews, "./data/review/");
		System.out.println("Review Controller exited successfully!");
	}
	public Review getReviewByID(UUID id) {
		return hm.containsKey(id) ? hm.get(id) : null;
	}
	
	// Creates a new review
	public void createReview(){
		Movie movie = null;
		// Calls movie controller to help select a movie

		//ArrayList<Movie> movieList = MOBLIMA.movieController.displayMovies();
		//movie = MOBLIMA.movieController.selectMovie(movieList);

		// Request user input rating
		System.out.println("Rate the movie! [1-5 stars]");
		int rating = IntegerHandler.readInt(1, 5);

		// Request user input description
		System.out.println("What do you think of the movie?");
		String description = StringHandler.readString();

		// Create Review object
		Review r = new Review(movie, rating, description);

		// Add Review object into reviews
		reviews.add(r);
	}

	public double calculateRating(List<Review> reviews){
		double rating = 0;

		for(Review r : reviews){
			rating += r.getRating();
		}

		return rating/reviews.size();
	}

	// Displays a list of reviews associated with the movie specified
	public void getReviewsByMovie(Movie movie){
		// filter reviews by movie
		ArrayList<Review> r = new ArrayList<Review>(); 
		for(Review review : reviews){
			if(review.getMovie() == movie){
				r.add(review);
			}
		}

		// display reviews
		if(r.size() == 0){ 
			System.out.println("There are no reviews for this movie!");
		}
		else{
			System.out.println("Overall rating: " + (r.size() == 1 ? "NA" : String.format("%.1f",calculateRating(r))));
			for(Review review: r){
				System.out.print(review);
			}
		}	
	}
	
	
	

}
