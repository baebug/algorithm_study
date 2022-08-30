package ssafy.hw.step9.Q2072;

public class ProductCodeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String pCode;
	
	public ProductCodeNotFoundException(String pCode) {
		super(pCode + " 코드의 상품이 존재하지 않습니다.");
		this.pCode = pCode;
	}
	
}
