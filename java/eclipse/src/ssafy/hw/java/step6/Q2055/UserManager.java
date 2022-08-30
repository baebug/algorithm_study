package ssafy.hw.step6.Q2055;

public class UserManager {
	private static final UserManager userManager = new UserManager();
	private final int MAX_USER_SIZE = 100;
	private final User[] users = new User[MAX_USER_SIZE];
	private User loginUser = null;
	private int userSize = 0;
	
	public static UserManager getUserManager() {
		return userManager;
	}
	
	private UserManager() {
	}

	public User getLoginUser() {
		return this.loginUser;
	}
	
	public void signup(User user) {
		if (userSize < MAX_USER_SIZE) {
			users[userSize++] = user;
		} else {
			System.out.println("더 이상 회원을 등록할 수 없습니다.");
		}
	}
	
	public User login(String id, String password) {
		for (int i = 0; i < userSize; i++) {
			if (users[i].getUserId().equals(id)) {
				if (users[i].getPassword().equals(password)) {
					loginUser = users[i];
					return users[i];
				}
				System.out.println("잘못된 비밀번호입니다.");
				return null;
			}
		}
		
		System.out.println("존재하지 않는 회원입니다.");
		return null;
	}
	
	public void logout() {
		loginUser = null;
	}
	
	public User getUser(int userSeq) {
		for (int i = 0; i < userSize; i++) {
			if (users[i].getUserSeq() == userSeq) {
				return users[i];
			}
		}
		
		System.out.println("존재하지 않는 회원입니다.");
		return null;
	}
	
	public User getUser(String nickName) {
		for (int i = 0; i < userSize; i++) {
			if (users[i].getNickName().equals(nickName)) {
				return users[i];
			}
		}
		
		System.out.println("존재하지 않는 회원입니다.");
		return null;
	}
}
