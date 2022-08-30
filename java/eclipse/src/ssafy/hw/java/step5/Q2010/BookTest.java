package ssafy.hw.step5.Q2010;

public class BookTest {

	public static void main(String[] args) {
		
		Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		Book b2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
		Book b3 = new Book("35355", "분석설계   ", "소나무", "jaen.kr", 30000, "SW 모델링");
		
		BookManager bm = new BookManager();
		
		bm.add(b1);
		bm.add(b2);
		bm.add(b3);
		
		System.out.println("**********************도서목록**********************");
		for(Book b : bm.getList()) {
			System.out.println(b);
		}
		System.out.println("**********************도서조회:21424**********************");
		System.out.println(bm.searchByIsbn("21424"));
		System.out.println("**********************도서삭제:21424**********************");
		bm.remove("21424");
		System.out.println("**********************도서목록**********************");
		for(Book b : bm.getList()) {
			System.out.println(b);
		}
		
		
		
	}

}
