package movie.review;

import java.util.List;

import input.FileController;
import main.MOBLIMA;

public class ReviewController {
	private List<Review> reviews;
	
	public ReviewController() {
		reviews = FileController.read(System.getProperty("user.dir") + "\\data\\review\\");
	}
	
	public void init() {
		for (Review review : reviews) 
			MOBLIMA.movieController.getMoviebyID(review.getMovieID()).addReview(review);
		System.out.println("Review Controller initialised successfully!");
	}
	
	public void exit() {
		FileController.write(reviews, System.getProperty("user.dir") + "\\data\\review\\");
		System.out.println("Review Controller exited successfully!");
	}
}
