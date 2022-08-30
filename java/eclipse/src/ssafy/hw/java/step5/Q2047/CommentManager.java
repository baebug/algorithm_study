package ssafy.hw.step5.Q2047;

import java.util.Arrays;

public class CommentManager {

	private final int MAX_COMMENT_SIZE = 1000;
	private Comment[] comments = new Comment[MAX_COMMENT_SIZE];
	private int commentSize = 0;
	
	public void addComment(Comment comment) {
		if (commentSize < MAX_COMMENT_SIZE) {
			comments[commentSize++] = comment;
		} else {
			System.out.println("더 이상 댓글을 작성할 수 없습니다.");
		}
	}
	
	public void removeComment(int commentId) {
		for (int i = 0; i < commentSize; i++) {
			if (comments[i].getCommentId() == commentId) {
				comments[i] = comments[commentSize - 1];
				comments[commentSize - 1] = null;
				commentSize--;
				return;
			}
		}
		
		System.out.println("존재하지 않는 댓글입니다.");
	}
	
	public void removeArticle1(int articleId) {
		Comment[] tmp = new Comment[MAX_COMMENT_SIZE];
		int idx = 0;
		
		for (int i = 0; i < commentSize; i++) {
			if (comments[i].getArticleId() != articleId) {
				tmp[idx++] = comments[i];
			}
		}
		
		commentSize = idx;
		comments = tmp;
	}
	
	public void removeArticle2(int articleId) {
		int idx = 0;
		
		while (idx < commentSize) {
			if (comments[idx].getArticleId() == articleId) {
				this.removeComment(idx);
				commentSize--;
			} else {
				idx++;
			}
		}
	}
	
	public Comment[] getCommentList(int articleId) {
		return Arrays.copyOfRange(comments, 0, commentSize);
	}
}
