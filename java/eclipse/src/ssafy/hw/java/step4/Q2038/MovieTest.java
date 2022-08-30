package ssafy.hw.step4.Q2038;

public class MovieTest {

	public static void main(String[] args) {
		
		Movie m1 = new Movie();
		m1.id = 1;
		m1.title = "영화1";
		m1.director = "봉감독";
		m1.genre = "코미디";
		m1.runningTime = 100;
		
		Movie m2 = new Movie(2, "영화2", "봉감독", "공포", 120);
		
		System.out.println(m1.id);
		System.out.println(m1.title);
		System.out.println(m1.director);
		System.out.println(m1.genre);
		System.out.println(m1.runningTime);
		System.out.println("--------------------------");
		System.out.println(m2.id);
		System.out.println(m2.title);
		System.out.println(m2.director);
		System.out.println(m2.genre);
		System.out.println(m2.runningTime);
	}

}
