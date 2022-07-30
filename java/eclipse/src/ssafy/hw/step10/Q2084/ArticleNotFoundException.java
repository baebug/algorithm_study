package ssafy.hw.step10.Q2084;

public class ArticleNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ArticleNotFoundException(int articleId) {
		super(articleId + "번 ID의 게시글이 존재하지 않습니다.");
	}
}
