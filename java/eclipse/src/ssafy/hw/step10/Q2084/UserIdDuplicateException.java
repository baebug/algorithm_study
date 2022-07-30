package ssafy.hw.step10.Q2084;

public class UserIdDuplicateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserIdDuplicateException(String userId) {
		super(userId + " 회원이 이미 존재합니다.");
	}

}
