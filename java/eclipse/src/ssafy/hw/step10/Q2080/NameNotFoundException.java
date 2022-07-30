package ssafy.hw.step10.Q2080;

public class NameNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NameNotFoundException(String name) {
		super(name + " 이름을 가진 상품이 존재하지 않습니다.");
	}
}
