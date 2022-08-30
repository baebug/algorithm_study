package ssafy.hw.step7.Q2061;

import java.util.Arrays;

public class ReviewManagerImpl implements IReviewManager {
	private final int MAX_REVIEW_SIZE = 1000;
	private Review[] reviews = new Review[MAX_REVIEW_SIZE];
	private int reviewSize = 0;
	
	private static IReviewManager reviewManager = new ReviewManagerImpl();
	
	private ReviewManagerImpl() {}
	
	public static IReviewManager getInstance() {
		return reviewManager;
	}

	@Override
	public void addReview(Review review) {
		if (this.reviewSize < MAX_REVIEW_SIZE) {
			reviews[reviewSize++] = review;
		}
	}

	@Override
	public void removeReview(Review review) {
		int reviewId = review.getReviewId();
		
		for (int i = 0; i < this.reviewSize; i++) {
			if (reviews[i].getReviewId() == reviewId) {
				reviews[i] = reviews[this.reviewSize - 1];
				reviews[this.reviewSize - 1] = null;
				this.reviewSize--;
				return;
			}
		}
	}

	@Override
	public Review[] getReviewList() {
		return Arrays.copyOfRange(reviews, 0, reviewSize);
	}

	@Override
	public Review searchByreviewId(int reviewId) {
		for (int i = 0; i < reviewSize; i++) {
			if (reviews[i].getReviewId() == reviewId) {
				return reviews[i];
			}
		}
		return null;
	}

	@Override
	public Review[] getRestaurantReview(int resId) {
		int cnt = 0;
		
		for (int i = 0; i < this.reviewSize; i++) {
			if (reviews[i].getResId() == resId) {
				cnt++;
			}
		}
		
		Review[] tmpList = new Review[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.reviewSize; i++) {
			if (reviews[i].getResId() == resId) {
				tmpList[idx] = reviews[i];
				idx++;
			}
		}
		return tmpList;
	}

}
