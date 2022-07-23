package ssafy.hw.step4.Q2040;

import java.util.Date;

public class Comment {
	int commentId;
	int articleId;
	int userSeq;
	String content;
	Date regDate;
	
	public Comment() {}

	public Comment(int commentId, int articleId, int userSeq, String content) {
		super();
		this.commentId = commentId;
		this.articleId = articleId;
		this.userSeq = userSeq;
		this.content = content;
		this.regDate = new Date();
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", articleId=" + articleId + ", userSeq=" + userSeq + ", content="
				+ content + ", regDate=" + regDate + "]";
	}

}
