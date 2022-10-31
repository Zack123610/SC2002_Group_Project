package movie.review;

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
//	private List<Review> reviews;
//	private Map<UUID, Review> hm = new HashMap<>();
	
	// Initialisation Code
	public ReviewController() {
//		reviews = FileController.read("./data/review/");
	}
	public void init() {
//		for (Review review : reviews) 
//			review.setMovie(MOBLIMA.movieController.getMovieByID(review.getMovie().getID()));
		System.out.println("Review Controller initialised successfully!");
	}
	public void exit() {
//		FileController.write(reviews, "./data/review/");
		System.out.println("Review Controller exited successfully!");
	}
//	public Review getReviewByID(UUID id) {
//		return hm.containsKey(id) ? hm.get(id) : null;
//	}
	

	
	
	
	
	
	

}
