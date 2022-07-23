package ssafy.hw.step5.Q2047;

import java.util.Arrays;

public class ArticleManager {
	private final int MAX_ARTICLE_SIZE = 1000;
	private final Article[] articles = new Article[MAX_ARTICLE_SIZE];
	private int articleSize = 0;
	
	public Article[] getArticleList() {
		return Arrays.copyOfRange(articles, 0, articleSize);
	}
	
	public Article getArticle(int articleId) {
		for (int i = 0; i < articleSize; i++) {
			if (articles[i].getArticleId() == articleId) {
				return articles[i];
			}
		}
		
		System.out.println("존재하지 않는 게시글입니다.");
		return null;
	}
	
	// 로그인 시만 가능
	public void addArticle(Article article) {
		if (articleSize < MAX_ARTICLE_SIZE) {
			articles[articleSize++] = article;
		} else {
			System.out.println("더이상 게시글을 작성할 수 없습니다.");
		}
	}
	
	// 게시글이 삭제되면 해당 게시글의 댓글 또한 전부 삭제한다.
	public void removeArticle(int articleId) {
		for (int i = 0; i < articleSize; i++) {
			if (articles[i].getArticleId() == articleId) {
				articles[i] = articles[articleSize - 1];
				articles[articleSize - 1] = null;
				articleSize--;
				return;
			}
		}
		
		System.out.println("존재하지 않는 게시글입니다.");
	}
	
}
