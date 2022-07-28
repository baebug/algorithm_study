package ssafy.hw.step9.Q2014;

public class ISBNNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String isbn;
	
	public ISBNNotFoundException(String isbn) {
		super(isbn + " 코드의 책이 존재하지 않습니다.");
		this.isbn = isbn;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
}
