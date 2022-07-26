package ssafy.hw.step7.Q2060;

public class Movie {
	private String title;
	private int runningTime;
	
	public Movie() {};
	
	public Movie(String title, int runningTime) {
		this.title = title;
		this.runningTime = runningTime;
	}

	public String getTitle() {
		return title;
	}
	
	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", runningTime=" + runningTime + "]";
	}

}
