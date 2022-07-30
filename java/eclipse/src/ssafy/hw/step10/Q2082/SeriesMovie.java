package ssafy.hw.step10.Q2082;

public class SeriesMovie extends Movie {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int seriesNum;
	private String episode;
	
	public SeriesMovie() {}

	public SeriesMovie(String title, int runningTime, int seriesNum, String episode) {
		super(title, runningTime);
		this.seriesNum = seriesNum;
		this.episode = episode;
	}

	public int getSeriesNum() {
		return seriesNum;
	}

	public void setSeriesNum(int seriesNum) {
		this.seriesNum = seriesNum;
	}

	public String getEpisode() {
		return episode;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	}

	@Override
	public String toString() {
		return super.toString() + "SeriesMovie [seriesNum=" + seriesNum + ", episode=" + episode + "]";
	}
	
}
