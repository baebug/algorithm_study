package ssafy.hw.step5.Q2044;

public class MovieTest {

	public static void main(String[] args) {
		
		Movie m1 = new Movie();
		m1.setTitle("진짜영화");
		
		Movie m2 = new Movie("가짜영화");
		
		System.out.println(m1);	// 진짜영화 
		System.out.println(m2);	// 가짜영화 
		
		MovieManager mm = new MovieManager();
		
		mm.add(m1);
		mm.add(m2);
		
		for(Movie m : mm.getList()) {
			System.out.println(m);	// 진짜영화 가짜영화 
		}
		
		for(Movie m : mm.searchByTitle("진짜")) {
			System.out.println(m);	// 진짜영화 
		}
		

	}

}
