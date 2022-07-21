package ssafy.hw.step6.Q2056;

public class KoreanRestaurant extends Restaurant {
	private String number;
	private String breakTime;
	
	public KoreanRestaurant() {}

	public KoreanRestaurant(int resId, String name, String address, String signatureMenu, int rate, String number, String breakTime) {
		super(resId, name, address, signatureMenu, rate);
		this.number = number;
		this.breakTime = breakTime;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBreakTime() {
		return breakTime;
	}

	public void setBreakTime(String breakTime) {
		this.breakTime = breakTime;
	}

	@Override
	public String toString() {
		return super.toString() + "|number=" + number + "| breakTime=" + breakTime;
	}
	
	
	
	
}
