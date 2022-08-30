package ssafy.hw.step10.Q2015;

public class NoBookException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoBookException() {
		super("등록된 도서가 없습니다.");
	}

}
