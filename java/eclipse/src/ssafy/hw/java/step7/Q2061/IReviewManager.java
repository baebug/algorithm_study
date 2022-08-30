package ssafy.hw.step7.Q2061;

public interface IReviewManager {
	void addReview(Review review);
	void removeReview(Review review);
	Review[] getReviewList();
	Review searchByreviewId(int reviewId);
	Review[] getRestaurantReview(int resId);
	
}
