package ssafy.hw.step10.Q2084;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ArticleManagerImpl implements IArticleManager {
	private List<Article> articles = new ArrayList<>();
	private Map<Integer, List<Comment>> comments = new HashMap<>();
	
	private static IArticleManager articleManager = new ArticleManagerImpl();
	
	private ArticleManagerImpl() {
		this.loadArticleData();
		this.loadCommentData();
	}
	
	public static IArticleManager getInstance() {
		return articleManager;
	}
	
	public List<Article> getArticleList() {
		return articles;
	}
	
	public Article getArticle(int articleId) throws ArticleNotFoundException {
		for (Article a : articles) {
			if (a.getArticleId() == articleId) {
				return a;
			}
		}

		throw new ArticleNotFoundException(articleId);
	}
	
	// 로그인 시만 가능
	public void addArticle(Article article) throws ArticleIdDuplicateException {
		int articleId = article.getArticleId();
		
		for(Article a : articles) {
			if (a.getArticleId() == articleId) {
				throw new ArticleIdDuplicateException();
			}
		}
		
		articles.add(article);
		saveArticleData();
	}
	
	// 게시글이 삭제되면 해당 게시글의 댓글 또한 전부 삭제한다.
	public void removeArticle(int articleId) {
		List<Comment> cml = comments.getOrDefault(articleId, new ArrayList<Comment>());
		cml.clear();
		
		articles.removeIf(a -> a.getArticleId() == articleId);
		
		saveArticleData();
	}
	
	public void updateArticle(Article article) {
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getArticleId() == article.getArticleId()) {
				articles.set(i, article);
				saveArticleData();
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
		
		saveCommentData();
	}

	@Override
	public void removeComment(int articleId, int commentId) throws CommentNotFoundException {
		List<Comment> cml = comments.getOrDefault(articleId, new ArrayList<Comment>());
		
		Iterator<Comment> iter = cml.iterator();
		
		while (iter.hasNext()) {
			Comment c = (Comment) iter.next();
			if (c.getCommentId() == commentId) {
				iter.remove();
				saveCommentData();
				return;
			}
		}
		
		throw new CommentNotFoundException();
		
	}

	@Override
	public List<Comment> getCommentList(int articleId) {
		return comments.getOrDefault(articleId, new ArrayList<Comment>());
	}
	
	private void loadArticleData() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try {
			articles = gson.fromJson(new FileReader("data/article.json"), new TypeToken<List<Article>>() {}.getType());
		} catch (Exception e) {
			System.out.println("파일 불러오기 실패");
			e.printStackTrace();
		}
	}
	
	private void loadCommentData() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try {
			comments = gson.fromJson(new FileReader("data/comment.json"), new TypeToken<Map<Integer, List<Comment>>>() {}.getType());
		} catch (Exception e) {
			System.out.println("파일 불러오기 실패");
			e.printStackTrace();
		}
	}
	
	public void saveArticleData() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Path file = Paths.get("data" + File.separator + "article.json");
		
		try {
			Files.write(file, gson.toJson(articles).getBytes());
		} catch (Exception e) {
			System.out.println("파일 저장 실패");
			e.printStackTrace();
		}
	}
	
	public void saveCommentData() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Path file = Paths.get("data" + File.separator + "comment.json");
		
		try {
			Files.write(file, gson.toJson(comments).getBytes());
		} catch (Exception e) {
			System.out.println("파일 저장 실패");
			e.printStackTrace();
		}
	}
}
