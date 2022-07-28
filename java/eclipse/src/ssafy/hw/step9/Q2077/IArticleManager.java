package ssafy.hw.step9.Q2077;

import java.util.List;

public interface IArticleManager {
	List<Article> getArticleList();
	Article getArticle(int articleId) throws ArticleNotFoundException;
	void addArticle(Article article) throws ArticleIdDuplicateException;
	void removeArticle(int articleId);
	void updateArticle(Article article);
	List<Article> getTextArticleList();
	List<ImageArticle> getImageArticleList();
	double getImageSizeAvg();
	List<Article> search(int option, String keyword);
	void addComment(Comment comment);
	void removeComment(int articleId, int commentId) throws CommentNotFoundException;
	List<Comment> getCommentList(int articleId);
}
