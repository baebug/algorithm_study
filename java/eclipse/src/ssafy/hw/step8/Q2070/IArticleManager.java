package ssafy.hw.step8.Q2070;

import java.util.List;

public interface IArticleManager {
	List<Article> getArticleList();
	Article getArticle(int articleId);
	void addArticle(Article article);
	void removeArticle(int articleId);
	void updateArticle(Article article);
	List<Article> getTextArticleList();
	List<ImageArticle> getImageArticleList();
	double getImageSizeAvg();
	List<Article> search(int option, String keyword);
	void addComment(Comment comment);
	void removeComment(int articleId, int commentId);
	List<Comment> getCommentList(int articleId);
}
