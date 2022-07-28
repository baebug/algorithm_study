package ssafy.hw.step9.Q2077;

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
	
	public void signup(User user) throws UserIdDuplicateException {
		String userId = user.getUserId();
		
		for(User u : users) {
			if (u.getUserId().equals(userId)) {
				throw new UserIdDuplicateException(userId);
			}
		}
		users.add(user);
	}
	
	public User login(String id, String password) throws LoginException {
		for (User u : users) {
			if (u.getUserId().equals(id) && u.getPassword().equals(password)) {
				loginUser = u;
				return u;
			}
		}
		
		throw new LoginException();
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
