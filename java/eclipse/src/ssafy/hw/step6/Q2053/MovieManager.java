package ssafy.hw.step6.Q2053;

public class MovieManager {

	int MAX_SIZE = 100;
	Movie[] movieList = new Movie[MAX_SIZE];
	
	int size = 0;
	
	public void add(Movie movie) {
		if (this.size < 100) {
			movieList[this.size] = movie;
			size++;
		} else {
			System.out.println("최대 영화정보에 도달하였습니다.");
		}
	}
	
	public Movie[] getList() {
		Movie[] tmpList = new Movie[this.size];
		
		for (int i = 0; i < this.size; i++) {
			tmpList[i] = movieList[i];
		}
		
		return tmpList;
	}
	
	public Movie[] searchByTitle(String findTitle) {
		int cnt = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (movieList[i].getTitle().contains(findTitle)) {
				cnt++;
			}
		}
		
		Movie[] tmpList = new Movie[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (movieList[i].getTitle().contains(findTitle)) {
				tmpList[idx] = movieList[i];
				idx++;
			}
		}
		return tmpList;
	}
	
	public Movie[] getMovies() {
		int cnt = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (!(movieList[i] instanceof SeriesMovie)) {
				cnt++;
			}
		}
		
		Movie[] tmpList = new Movie[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (!(movieList[i] instanceof SeriesMovie)) {
				tmpList[idx++] = movieList[i];
			}
		}
		return tmpList;
	}
	
	public SeriesMovie[] getSeriesMovies() {
		int cnt = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (movieList[i] instanceof SeriesMovie) {
				cnt++;
			}
		}
		
		SeriesMovie[] tmpList = new SeriesMovie[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (movieList[i] instanceof SeriesMovie) {
				tmpList[idx++] = (SeriesMovie) movieList[i];
			}
		}
		return tmpList;
	}
	
	public double getRunningTimeAvg() {
		int total = 0;
		
		for (int i = 0; i < this.size; i++) {
			total += movieList[i].getRunningTime();
		}
		
		return total / this.size;
	}
	
}

