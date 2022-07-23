package ssafy.hw.step5.Q2047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoardTest {

	public static void main(String[] args) throws IOException {
		
		UserManager um = new UserManager();
		ArticleManager am = new ArticleManager();
		CommentManager cm = new CommentManager();
		
		um.signup(new User(0, "ssafy", "1234", "김싸피", "김싸피", "ssafy@ssafy.com"));
		um.signup(new User(1, "hong", "123", "홍싸피", "ssafy.hong", "hong@ssafy.com"));
		um.signup(new User(2, "samsic", "samsic", "김삼식", "삼식이", "kim@ssafy.com"));
		um.signup(new User(3, "happy", "happy", "이싸피", "해피바이러스", "lee@ssafy.com"));
		um.signup(new User(4, "good", "good", "따싸피", "따봉맨", "good@ssafy.com"));
		um.signup(new User(5, "song", "song", "송싸피", "프린스송", "song@ssafy.com"));
		
		am.addArticle(new Article(0, "공지사항", "게시글 내용", 0));
		am.addArticle(new Article(1, "코딩테스트란", "게시글 내용", 1));
		am.addArticle(new Article(2, "취뽀는 나에게", "게시글 내용", 2));
		am.addArticle(new Article(3, "Java 완전정복", "게시글 내용", 3));
		
		cm.addComment(new Comment(0, 1, 5, "잘 보았습니다."));
		cm.addComment(new Comment(1, 1, 4, "좋은 글 입니다~~"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("------------------------------");
		System.out.println("게시판 접속");
		System.out.println("------------------------------");
		System.out.println("작업을 선택하세요.");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("0. 종료");
		System.out.println("------------------------------");
		
		int command = -1;
		
		command = Integer.parseInt(br.readLine());
		
		if (command == 1) {
			System.out.println("ID 입력 :");
			String id = br.readLine();
			System.out.println("PASSWORD 입력 :");
			String pw = br.readLine();

			um.login(id, pw);
			
		} else if (command == 2) {
			// 회원가입 절차가 진행된다. userCount 로 id 값 넣어주고 등등..
			// 일단 기능이 없으니 return
			System.out.println("ID 입력 :");
			String id = br.readLine();
			System.out.println("PASSWORD 입력 :");
			String pw = br.readLine();
			System.out.println("이름 입력 :");
			String name = br.readLine();
			System.out.println("별명 입력 :");
			String nick = br.readLine();
			System.out.println("메일주소 입력 :");
			String mail = br.readLine();
			
			um.signup(new User(randomNumber(), id, pw, name, nick, mail));
			
			return;
		} else {
			if (command == 0) {
				return;
			} else {
				System.out.println("input Error!");
				return;				
			}
		}
		
		User user = um.getLoginUser();
		if (user == null) {
			return;
		}
		
		// 로그인 성공
		System.out.println("------------------------------");
		System.out.println("로그인 성공");
		System.out.println(user.getNickName() + "님 환영합니다.");
		System.out.println("------------------------------");
		System.out.println("게시글 목록");
		for(Article a : am.getArticleList()) {
			System.out.println(a.getArticleId() + " " + a.getTitle());
		}
		System.out.println("------------------------------");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 선택");
		System.out.println("3. 로그아웃");
		System.out.println("0. 종료");
		System.out.println("------------------------------");
		
		command = Integer.parseInt(br.readLine());
		
		if (command == 1) {
			// 게시글 작성
			return;
		} else if (command == 2) {
			System.out.println("게시글 선택 :");
			
			Article a = am.getArticle(Integer.parseInt(br.readLine()));
			Comment[] cms = cm.getCommentList(a.getArticleId());
			System.out.println("------------------------------");
			System.out.println("제목 : " + a.getTitle());
			System.out.println("작성자 : " + um.getUser(a.getUserSeq()).getNickName());
			System.out.println("조회수 : " + a.getViewCnt());
			System.out.println("작성일 : " + a.getRegDate());
			System.out.println("내용 : " + a.getContent());
			a.setViewCnt(a.getViewCnt() + 1);
			System.out.println("------------------------------");
			System.out.println("총 댓글의 수 : " + cms.length);
			for(Comment c : cms) {
				System.out.println(c.getCommentId() + ". " + c.getContent() + " 작성자 : " + um.getUser(c.getUserSeq()).getNickName());
			}
			System.out.println("------------------------------");
			System.out.println("1. 게시글 삭제");
			System.out.println("2. 댓글 작성");
			System.out.println("3. 댓글 삭제");
			System.out.println("0. 종료");
			System.out.println("------------------------------");
		} else if (command == 3) {
			um.logout();
			return;
		} else {
			return;
		}
		
	}
	
	static int randomNumber() {
		return (int) (Math.random() * 100000);
	}

}
