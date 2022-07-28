package ssafy.hw.step9.Q2071;

public class NameNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public NameNotFoundException(String name) {
		super(name + " 이름의 회원이 존재하지 않습니다.");
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
