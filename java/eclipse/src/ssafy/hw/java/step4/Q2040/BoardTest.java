package ssafy.hw.step4.Q2040;

public class BoardTest {

	public static void main(String[] args) {
		User u1 = new User(0, "ssafy", "1234", "김싸피", "김싸피", "ssafy@ssafy.com");
		User u2 = new User(1, "hong", "123", "홍싸피", "ssafy.hong", "hong@ssafy.com");
		User u3 = new User(2, "samsic", "samsic", "김삼식", "삼식이", "kim@ssafy.com");
		User u4 = new User(3, "happy", "happy", "이싸피", "해피바이러스", "lee@ssafy.com");
		
		Article a1 = new Article(0, "공지사항", "게시글 내용", 0, 0);
		Article a2 = new Article(1, "코딩테스트란", "게시글 내용", 1, 0);
		Article a3 = new Article(2, "취뽀는 나에게", "게시글 내용", 2, 0);
		Article a4 = new Article(3, "Java 완전정복", "게시글 내용", 3, 0);
		
		Comment c1 = new Comment(0, 1, 5, "잘 보았습니다.");
		Comment c2 = new Comment(1, 1, 4, "좋은 글 입니다~~");
		
		System.out.println("User 출력");
		System.out.println("--------------------------------------------");
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u3);
		System.out.println(u4);
		System.out.println();
		
		System.out.println("게시글");
		System.out.println("--------------------------------------------");
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println();
		
		System.out.println("게시글 댓글 출력");
		System.out.println("--------------------------------------------");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println();
	}

}
