package ssafy.hw.step9.Q2014;

public class QuantityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QuantityException() {
		super("재고 수량이 부족합니다.");
	}

}
