package ssafy.hw.step7.Q2060;

public interface IMovieManager {
	void add(Movie movie);
	Movie[] getList();
	Movie[] searchByTitle(String title);
	Movie[] getMovies();
	SeriesMovie[] getSeriesMovies();
	double getRunningTimeAvg();
}
