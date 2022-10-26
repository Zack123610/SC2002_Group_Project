package movie.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import input.FileController;
import main.MOBLIMA;

public class ReviewController {
	private List<Review> reviews;
	private Map<UUID, Review> hm = new HashMap<>();
	
	public ReviewController() {
		reviews = FileController.read("./data/review/");
	}
	
	public void init() {
		for (Review review : reviews) {
			UUID movieID = review.getMovie().getID();
			review.setMovie(MOBLIMA.movieController.getMovieByID(movieID));
			review.getMovie().addReview(review);
		}
		System.out.println("Review Controller initialised successfully!");
	}
	
	public void exit() {
		FileController.write(reviews, "./data/review/");
		System.out.println("Review Controller exited successfully!");
	}
	
	public Review getReviewByID(UUID id) {
		return hm.containsKey(id) ? hm.get(id) : null;
	}
}
