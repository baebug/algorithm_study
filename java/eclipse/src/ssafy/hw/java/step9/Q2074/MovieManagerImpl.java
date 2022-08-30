package ssafy.hw.step9.Q2074;

import java.util.ArrayList;
import java.util.List;

public class MovieManagerImpl implements IMovieManager {

	List<Movie> movieList = new ArrayList<>();
	
	private static IMovieManager movieManager = new MovieManagerImpl();
	
	private MovieManagerImpl() {}
	
	public static IMovieManager getInstance() {
		return movieManager;
	}
	
	public void add(Movie movie) {
		movieList.add(movie);
	}
	
	public Movie[] getList() {
		Movie[] tmpList = new Movie[movieList.size()];
		movieList.toArray(tmpList);
		return tmpList;
	}
	
	public Movie[] searchByTitle(String findTitle) throws TitleNotFoundException {
		List<Movie> tmpList = new ArrayList<>();
		
		for (Movie m : movieList) {
			if (m.getTitle().contains(findTitle)) {
				tmpList.add(m);
			}
		}
		
		if (tmpList.size() == 0) {
			throw new TitleNotFoundException(findTitle);
		}
		
		Movie[] result = new Movie[tmpList.size()];
		tmpList.toArray(result);
		return result;
	}
	
	public Movie[] getMovies() {
		List<Movie> tmpList = new ArrayList<>();
		
		for (Movie m : movieList) {
			if (!(m instanceof SeriesMovie)) {
				tmpList.add(m);
			}
		}
		
		Movie[] result = new Movie[tmpList.size()];
		tmpList.toArray(result);
		return result;
	}
	
	public SeriesMovie[] getSeriesMovies() {
		List<SeriesMovie> tmpList = new ArrayList<>();
		
		for (Movie m : movieList) {
			if (m instanceof SeriesMovie) {
				tmpList.add((SeriesMovie) m);
			}
		}
		
		SeriesMovie[] result = new SeriesMovie[tmpList.size()];
		tmpList.toArray(result);
		return result;
	}
	
	public double getRunningTimeAvg() {
		int total = 0;
		
		for (Movie m : movieList) {
			total += m.getRunningTime();
		}
		
		return total / movieList.size();
	}
	
}

