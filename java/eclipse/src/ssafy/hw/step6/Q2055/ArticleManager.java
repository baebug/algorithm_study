package ssafy.hw.step6.Q2055;

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
	
	public void updateArticle(Article article) {
		for (int i = 0; i < articleSize; i++) {
			if (articles[i].getArticleId() == article.getArticleId()) {
				articles[i] = article;
				return;
			}
		}
	}
	
	public Article[] getTextArticleList() {
		int cnt = 0;
		
		for (int i = 0; i < articleSize; i++) {
			if (!(articles[i] instanceof ImageArticle)) {
				cnt++;
			}
		}
		
		Article[] result = new Article[cnt];
		int idx = 0;
		
		for (int i = 0; i < articleSize; i++) {
			if (!(articles[i] instanceof ImageArticle)) {
				result[idx++] = articles[i];
			}
		}
		
		return result;
	}
	
	public ImageArticle[] getImageArticleList() {
		int cnt = 0;
		
		for (int i = 0; i < articleSize; i++) {
			if (articles[i] instanceof ImageArticle) {
				cnt++;
			}
		}
		
		ImageArticle[] result = new ImageArticle[cnt];
		int idx = 0;
		
		for (int i = 0; i < articleSize; i++) {
			if (articles[i] instanceof ImageArticle) {
				result[idx++] = (ImageArticle) articles[i];
			}
		}
		
		return result;
	}
	
	public double getImageSizeAvg() {
		ImageArticle[] tmp = this.getImageArticleList();
		double total = 0;
		
		for (ImageArticle i : tmp) {
			total += i.getWidth() * i.getHeight();
		}
		
		return total / tmp.length;
	}
	
	public Article[] search(int option, String keyword) {
		int cnt = 0;
		Article[] result;
		int idx;
		
		switch (option) {
			case 1 :
				for (int i = 0; i < articleSize; i++) {
					if (articles[i].getTitle().contains(keyword)) {
						cnt++;
					}
				}
				
				result = new Article[cnt];
				idx = 0;
				
				for (int i = 0; i < articleSize; i++) {
					if (articles[i].getTitle().contains(keyword)) {
						result[idx++] = articles[i];
					}
				}
				
				return result;
			case 2 :
				for (int i = 0; i < articleSize; i++) {
					if (articles[i].getContent().contains(keyword)) {
						cnt++;
					}
				}
				
				result = new Article[cnt];
				idx = 0;
				
				for (int i = 0; i < articleSize; i++) {
					if (articles[i].getContent().contains(keyword)) {
						result[idx++] = articles[i];
					}
				}
				
				return result;
			case 3 :
				// um 을 새로 만들기 때문에 userSize 가 0이 된다. -> 싱글톤 패턴으로 해서 같은 um 을 쓰도록 디자인 해야한다.
				UserManager um = UserManager.getUserManager();
				User user = um.getUser(keyword);
				
				for (int i = 0; i < articleSize; i++) {
					if (articles[i].getUserSeq() == user.getUserSeq()) {
						cnt++;
					}
				}
				
				result = new Article[cnt];
				idx = 0;
				
				for (int i = 0; i < articleSize; i++) {
					if (articles[i].getUserSeq() == user.getUserSeq()) {
						result[idx++] = articles[i];
					}
				}
				
				return result;
			default :
				return null;
		}
	}
	
}
