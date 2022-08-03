package ssafy.algorithm.pg;

public class Tuple implements Comparable<Tuple> {
	private int number;
	private int time;
	
	public Tuple() {}
	
	public Tuple(int number, int time) {
		this.number = number;
		this.time = time;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public int compareTo(Tuple o) {
		return this.time - o.time;
	}
	
	@Override
	public String toString() {
		return "Tuple [number=" + number + ", time=" + time + "]";
	}
}
