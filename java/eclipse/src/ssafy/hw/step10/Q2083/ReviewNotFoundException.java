package ssafy.hw.step10.Q2083;

public class ReviewNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReviewNotFoundException() {
		super("리뷰가 존재하지 않습니다.");
	}
	
	public ReviewNotFoundException(int reviewId) {
		super(reviewId + "번 id의 리뷰가 존재하지 않습니다.");
	}
}
