package ssafy.hw.step10.Q2082;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MovieManagerImpl implements IMovieManager {

	List<Movie> movieList = new ArrayList<>();
	
	private static IMovieManager movieManager = new MovieManagerImpl();
	
	private MovieManagerImpl() {
		this.loadData();
	}
	
	private void loadData() {
		File file = new File("movie.dat");
		
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				movieList = (List<Movie>) ois.readObject();
			} catch (Exception e) {
				System.out.println("파일 불러오기 실패");
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void saveData() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movie.dat"))) {
			oos.writeObject(movieList);
		} catch (Exception e) {
			System.out.println("파일 저장 실패");
			e.printStackTrace();
		}
	}
	
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

