package ssafy.hw.step7.Q2062;

public interface IArticleManager {
	Article[] getArticleList();
	Article getArticle(int articleId);
	void addArticle(Article article);
	void removeArticle(int articleId);
	void updateArticle(Article article);
	Article[] getTextArticleList();
	ImageArticle[] getImageArticleList();
	double getImageSizeAvg();
	Article[] search(int option, String keyword);
	void addComment(Comment comment);
	void removeComment(int commentId);
	Comment[] getCommentList(int articleId);
}
