package ssafy.hw.step10.Q2084;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class UserManagerImpl implements IUserManager {
	private User loginUser = null;
	private List<User> users = new ArrayList<>();
	
	private static IUserManager userManager = new UserManagerImpl();
	
	private UserManagerImpl() {
		this.loadUserData();
	}
	
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
		this.saveUserData();
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
	
	private void loadUserData() {
		Gson gson = new Gson();
		try {
			users = gson.fromJson(new FileReader("data/user.json"), new TypeToken<List<User>>() {}.getType());
		} catch (Exception e) {
			System.out.println("파일 불러오기 실패");
			e.printStackTrace();
		}
	}
	
	public void saveUserData() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			Path file = Paths.get("data" + File.separator + "user.json");
			String json = gson.toJson(users);
			Files.write(file, json.getBytes());
		} catch (Exception e) {
			System.out.println("파일 쓰기 실패");
			e.printStackTrace();
		}
	}
}
