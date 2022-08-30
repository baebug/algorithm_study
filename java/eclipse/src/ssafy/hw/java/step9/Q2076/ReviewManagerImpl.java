package ssafy.hw.step9.Q2076;

import java.util.ArrayList;
import java.util.List;

public class ReviewManagerImpl implements IReviewManager {
	private List<Review> reviews = new ArrayList<>();
	
	public ReviewManagerImpl() {}
	
	@Override
	public void addReview(Review review) {
		reviews.add(review);
	}

	@Override
	public void removeReview(int reviewId) {
		reviews.removeIf(r -> r.getReviewId() == reviewId);
	}

	@Override
	public List<Review> getReviewList() {
		return reviews;
	}

	@Override
	public Review searchByreviewId(int reviewId) throws ReviewNotFoundException {
		for (Review r : reviews) {
			if (r.getReviewId() == reviewId) {
				return r;
			}
		}

		throw new ReviewNotFoundException(reviewId);
	}

	@Override
	public List<Review> getRestaurantReview(int resId) {
		List<Review> tmpList = new ArrayList<>();
		
		for (Review r : reviews) {
			if (r.getResId() == resId) {
				tmpList.add(r);
			}
		}
		
		return tmpList;
	}

}
