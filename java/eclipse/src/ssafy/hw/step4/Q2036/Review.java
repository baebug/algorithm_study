package ssafy.hw.step4.Q2036;

public class Review {
	int reviewId;
	String pCode;
	String writer;
	String content;
	
	public Review() {}
	
	public Review(int reviewId, String pCode, String writer, String content) {
		super();
		this.reviewId = reviewId;
		this.pCode = pCode;
		this.writer = writer;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", pCode=" + pCode + ", writer=" + writer + ", content=" + content
				+ "]";
	}
	
}
