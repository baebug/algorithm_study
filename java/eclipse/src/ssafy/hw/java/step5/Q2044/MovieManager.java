package ssafy.hw.step5.Q2044;

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
	
}
