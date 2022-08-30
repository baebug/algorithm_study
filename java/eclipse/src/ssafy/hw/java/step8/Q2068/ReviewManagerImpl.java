package ssafy.hw.step8.Q2068;

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
	public Review searchByreviewId(int reviewId) {
		for (Review r : reviews) {
			if (r.getReviewId() == reviewId) {
				return r;
			}
		}
		return null;
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
