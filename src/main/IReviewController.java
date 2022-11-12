package main;

/**
 * IReviewController provides the interface required for managing the {@code Review} class. 
 * It provides methods to create and delete review, which other controllers can call.
 * @author Tan Say Hong
 *
 */
public interface IReviewController {
	/**
	 * Method to write a review. The user first selects a movie. They then enter their rating
	 * followed by the description.
	 */
    public void writeReview();
    /**
	 * Method to delete a review. Callable via admin.
	 * The admin first selects a movie, then selects a review to delete.
	 * A confirmation check is included before deleting the {@code Review} object.
	 */
    public void deleteReview();
}