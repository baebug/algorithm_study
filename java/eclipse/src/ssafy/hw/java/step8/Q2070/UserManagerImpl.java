package ssafy.hw.step8.Q2070;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserManagerImpl implements IUserManager {
	private User loginUser = null;
	private List<User> users = new ArrayList<>();
	
	private static IUserManager userManager = new UserManagerImpl();
	
	private UserManagerImpl() {}
	
	public static IUserManager getInstance() {
		return userManager;
	}
	
	public User getLoginUser() {
		return this.loginUser;
	}
	
	public void signup(User user) {
		users.add(user);
	}
	
	public User login(String id, String password) {
		for (User u : users) {
			if (u.getUserId().equals(id)) {
				if (u.getPassword().equals(password)) {
					loginUser = u;
					return u;
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
		for (User u : users) {
			if (u.getUserSeq() == userSeq) {
				return u;
			}
		}
		
		System.out.println("존재하지 않는 회원입니다.");
		return null;
	}
	
	public User getUser(String nickName) {
		Optional<User> user = users.stream().filter(u -> u.getNickName().equals(nickName)).findFirst();
		
		if (user.isPresent()) {
			return user.get();
		} else {
			System.out.println("존재하지 않는 회원입니다.");
			return null;
		}
	}
}
