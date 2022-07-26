package ssafy.hw.step7.Q2060;

public class MovieTest {

	public static void main(String[] args) {
		
		
		IMovieManager mm = MovieManagerImpl.getInstance();
		
		mm.add(new SeriesMovie("진짜영화1", 100, 1, "진짜"));
		mm.add(new Movie("가짜영화", 120));
		mm.add(new SeriesMovie("진짜영화2", 120, 2, "진짜진짜"));
		
		for(Movie m : mm.getList()) {
			System.out.println(m);
		}
		
		for(Movie m : mm.searchByTitle("진짜")) {
			System.out.println(m);
		}
		
		for(Movie m : mm.getMovies()) {
			System.out.println(m);
		}
		
		for(Movie m : mm.getSeriesMovies()) {
			System.out.println(m);
		}
		
		System.out.println(mm.getRunningTimeAvg());

	}

}
