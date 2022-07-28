package ssafy.hw.step9.Q2076;

public class RestaurantNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RestaurantNotFoundException() {
		super("레스토랑이 존재하지 않습니다.");
	}
	
	public RestaurantNotFoundException(int resId) {
		super(resId + "번 id의 레스토랑이 존재하지 않습니다.");
	}
}
