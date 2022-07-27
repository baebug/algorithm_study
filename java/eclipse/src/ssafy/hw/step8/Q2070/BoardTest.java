package ssafy.hw.step8.Q2070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoardTest {

	static IUserManager um = UserManagerImpl.getInstance();
	static IArticleManager am = ArticleManagerImpl.getInstance();
	
	public static void main(String[] args) throws IOException {
		
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
		am.addArticle(new Article(4, "Python 완전정복", "게시글 내용", 3));
		am.addArticle(new ImageArticle(5, "Image 잘찍는법 완전정복", "게시글 내용", 3, "image1", 200, 100));
		am.addArticle(new ImageArticle(6, "클린코드 작성법", "게시글 내용", 3, "image2", 100, 100));
		
		am.addComment(new Comment(0, 1, 5, "잘 보았습니다."));
		am.addComment(new Comment(1, 1, 4, "좋은 글 입니다~~"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int command = -1;
		
		while (command != 0) {
			System.out.println("------------------------------");
			System.out.println("게시판 접속");
			System.out.println("------------------------------");
			System.out.println("작업을 선택하세요.");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 검색");
			System.out.println("4. 일반 게시글 모아보기");
			System.out.println("5. 이미지 게시글 모아보기");
			System.out.println("0. 종료");
			System.out.println("------------------------------");
			command = Integer.parseInt(br.readLine());
			
			if (command == 3) {
				System.out.println("------------------------------");
				System.out.println("검색 옵션");
				System.out.println("1. 제목검색");
				System.out.println("2. 내용검색");
				System.out.println("3. 작성자 검색");
				
				int option = Integer.parseInt(br.readLine());
				System.out.println("내용 입력");
				String keyword = br.readLine();
				
				for(Article a : am.search(option, keyword)) {
					if (a instanceof ImageArticle) {
						System.out.println("이미지 게시글 : " + a.getTitle());
					} else {
						System.out.println("텍스트 게시글 : " + a.getTitle());
					}
					System.out.println();
				}
			} else if (command == 4) {
				System.out.println("------------------------------");
				System.out.println("일반 게시글 모아보기");
				for(Article a : am.getTextArticleList()) {
					System.out.println(a.getTitle());
				}
			} else if (command == 5) {
				System.out.println("이미지 게시글 모아보기");
				for(ImageArticle a : am.getImageArticleList()) {
					System.out.println(a.getTitle());
				}
				System.out.println();
				System.out.println("전체 이미지의 평균 크기 : " + am.getImageSizeAvg());
			}
			
		}
		
	}
	
	static int randomNumber() {
		return (int) (Math.random() * 100000);
	}

}
