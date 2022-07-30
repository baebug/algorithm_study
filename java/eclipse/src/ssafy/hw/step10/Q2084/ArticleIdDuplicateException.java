package ssafy.hw.step10.Q2084;

public class ArticleIdDuplicateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ArticleIdDuplicateException() {
		super("게시글을 등록할 수 없습니다.");
	}
}
