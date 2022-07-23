package ssafy.hw.step4.Q2040;

import java.util.Date;

public class Article {
	int articleId;
	String title;
	String content;
	int userSeq;
	int viewCnt;
	Date regDate;
	
	public Article() {}

	public Article(int articleId, String title, String content, int userSeq, int viewCnt) {
		super();
		this.articleId = articleId;
		this.title = title;
		this.content = content;
		this.userSeq = userSeq;
		this.viewCnt = viewCnt;
		this.regDate = new Date();
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", title=" + title + ", content=" + content + ", userSeq=" + userSeq
				+ ", viewCnt=" + viewCnt + ", regDate=" + regDate + "]";
	}
	
}
