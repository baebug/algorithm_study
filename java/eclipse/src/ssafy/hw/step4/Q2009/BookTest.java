package ssafy.hw.step4.Q2009;

public class BookTest {

	public static void main(String[] args) {

		Book b1 = new Book();
		b1.isbn = "21424";
		b1.title = "Java Pro";
		b1.author = "김하나";
		b1.publisher = "jean.kr";
		b1.price = 15000;
		b1.desc = "Java 기본 문법";

		// "\t" 을 사용하여 toString 을 만드니 인스턴스의 title 길이가 짧을 경우 출력틀이 깨진다. 
		Book b2 = new Book("35355", "분석설계   ", "소나무", "jaen.kr", 30000, "SW 모델링");
		
		System.out.println("**********************도서목록**********************");
		System.out.println(b1);
		System.out.println(b2);
	}

}
