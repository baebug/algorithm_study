package ssafy.hw.step8.Q2070;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticleManagerImpl implements IArticleManager {
	private List<Article> articles = new ArrayList<>();
	private Map<Integer, List<Comment>> comments = new HashMap<>();
	
	private static IArticleManager articleManager = new ArticleManagerImpl();
	
	private ArticleManagerImpl() {}
	
	public static IArticleManager getInstance() {
		return articleManager;
	}
	
	public List<Article> getArticleList() {
		return articles;
	}
	
	public Article getArticle(int articleId) {
		for (Article a : articles) {
			if (a.getArticleId() == articleId) {
				return a;
			}
		}
		
		System.out.println("존재하지 않는 게시글입니다.");
		return null;
	}
	
	// 로그인 시만 가능
	public void addArticle(Article article) {
		articles.add(article);
	}
	
	// 게시글이 삭제되면 해당 게시글의 댓글 또한 전부 삭제한다.
	public void removeArticle(int articleId) {
		List<Comment> cml = comments.getOrDefault(articleId, new ArrayList<Comment>());
		cml.clear();
		
		articles.removeIf(a -> a.getArticleId() == articleId);
		
		System.out.println("존재하지 않는 게시글입니다.");
	}
	
	public void updateArticle(Article article) {
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getArticleId() == article.getArticleId()) {
				articles.set(i, article);
				return;
			}
		}
		
		System.out.println("존재하지 않는 게시글입니다.");
	}
	
	public List<Article> getTextArticleList() {
		List<Article> tmpList = new ArrayList<>();
		
		for (Article a : articles) {
			if (!(a instanceof ImageArticle)) {
				tmpList.add(a);
			}
		}
		
		return tmpList;
	}
	
	public List<ImageArticle> getImageArticleList() {
		List<ImageArticle> tmpList = new ArrayList<>();
		
		for (Article a : articles) {
			if (a instanceof ImageArticle) {
				tmpList.add((ImageArticle) a);
			}
		}
		
		return tmpList;
	}
	
	public double getImageSizeAvg() {
		List<ImageArticle> tmp = this.getImageArticleList();
		double total = 0;
		
		for (ImageArticle i : tmp) {
			total += i.getWidth() * i.getHeight();
		}
		
		return total / tmp.size();
	}
	
	public List<Article> search(int option, String keyword) {
		List<Article> tmpList = new ArrayList<>();
		
		switch (option) {
			case 1 :
				for (Article a : articles) {
					if (a.getTitle().contains(keyword)) {
						tmpList.add(a);
					}
				}
				
				return tmpList;
			case 2 :
				for (Article a : articles) {
					if (a.getContent().contains(keyword)) {
						tmpList.add(a);
					}
				}
				
				return tmpList;
			case 3 :
				// um 을 새로 만들기 때문에 userSize 가 0이 된다. -> 싱글톤 패턴으로 해서 같은 um 을 쓰도록 디자인 해야한다.
				IUserManager um = UserManagerImpl.getInstance();
				User user = um.getUser(keyword);
				
				for (Article a : articles) {
					if (a.getUserSeq() == user.getUserSeq()) {
						tmpList.add(a);
					}
				}
				
				return tmpList;
			default :
				return null;
		}
	}

	@Override
	public void addComment(Comment comment) {
		List<Comment> cml = comments.getOrDefault(comment.getArticleId(), new ArrayList<Comment>());
		cml.add(comment);
	}

	@Override
	public void removeComment(int articleId, int commentId) {
		List<Comment> cml = comments.getOrDefault(articleId, new ArrayList<Comment>());
		cml.removeIf(e -> e.getCommentId() == commentId);
	}

	@Override
	public List<Comment> getCommentList(int articleId) {
		return comments.getOrDefault(articleId, new ArrayList<Comment>());
	}
	
}
