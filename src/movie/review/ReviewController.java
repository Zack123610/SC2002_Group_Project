package movie.review;

import java.util.List;

import input.IntegerHandler;
import input.StringHandler;
import main.IReviewController;
import main.MOBLIMA;
import movie.Movie;

public class ReviewController implements IReviewController{
	
	// Initialisation Code
	public ReviewController() { }
	public void init() {
		System.out.println("Review Controller initialised successfully!");
	}
	public void exit() {
		System.out.println("Review Controller exited successfully!");
	}
	
	// Controller methods
	public void writeReview() {
		Movie movie = MOBLIMA.movieController.selectMovie(3);
		
		if (movie == null)
			return;
		
		System.out.print("Enter a rating (1-5): ");
		int rating = IntegerHandler.readInt(1, 5);
		
		System.out.println("Enter description: ");
		String description = StringHandler.readString();
		
		movie.addReview(new Review(rating, description));
		System.out.println("New review successfully added.\n");
	}
	
	public void deleteReview() {
		Movie movie = MOBLIMA.movieController.selectMovie(7);
		
		if (movie == null)
			return;
		
		List<Review> reviews = movie.getReviews();
		if (reviews.size() == 0) {
			System.out.println("There are no reviews for this movie.");
			return;
		}
		
		int cnt = 0;
		for (Review review : reviews) 
			System.out.println(++cnt + ") " + review.toString());
		
		System.out.print("Please select a review (0 to cancel): ");
		int idx = IntegerHandler.readInt(reviews.size());

		if (idx == 0)
			return;
		
		Review review = reviews.get(idx-1);
		System.out.println(review.toString());
		System.out.print("You are about to delete this review. Please confirm (Y/N): ");
		
		if (StringHandler.readString("Y", "N").equals("N"))
			return;

		movie.getReviews().remove(review);
		System.out.println("Review successfully removed.\n");
	}
}
