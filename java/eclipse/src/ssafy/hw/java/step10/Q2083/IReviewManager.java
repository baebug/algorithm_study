package ssafy.hw.step10.Q2083;

import java.util.List;

public interface IReviewManager {
	void addReview(Review review);
	void removeReview(int reviewId);
	List<Review> getReviewList();
	Review searchByreviewId(int reviewId) throws ReviewNotFoundException;
	List<Review> getRestaurantReview(int resId);

	void saveData();
}
