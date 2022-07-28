package ssafy.hw.step9.Q2077;

public class ArticleIdDuplicateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ArticleIdDuplicateException() {
		super("게시글을 등록할 수 없습니다.");
	}
}
