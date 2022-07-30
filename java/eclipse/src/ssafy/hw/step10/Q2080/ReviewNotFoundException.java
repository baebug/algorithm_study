package ssafy.hw.step10.Q2080;

public class ReviewNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReviewNotFoundException(String pCode) {
		super(pCode + " 상품의 리뷰가 존재하지 않습니다.");
	}
}
