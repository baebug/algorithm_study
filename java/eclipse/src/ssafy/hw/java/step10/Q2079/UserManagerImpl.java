package ssafy.hw.step10.Q2079;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements IUserManager {

	private List<User> userList = new ArrayList<>();

	private static IUserManager userManager = new UserManagerImpl();
	
	private UserManagerImpl() {}
	
	@Override
	public void loadData() {
		File file = new File("user.dat");
		
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				userList = (List<User>) ois.readObject();
			} catch (Exception e) {
				System.out.println("파일 불러오기 실패");
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void saveData() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
			oos.writeObject(userList);
		} catch (Exception e) {
			System.out.println("파일 저장 실패");
			e.printStackTrace();
		}
	}
	
	public static IUserManager getInstance() {
		return userManager;
	}
	
	public void add(User user) {
		userList.add(user);
	}

	public User[] getList() {
		User[] tmpList = new User[userList.size()];
		userList.toArray(tmpList);
		return tmpList;
	}
	
	// 일반 사용자만 반환
	public User[] getUsers() {
		List<User> tmpList = new ArrayList<>();
		
		for(User u : userList) {
			if(!(u instanceof VipUser)) {
				tmpList.add(u);
			}
		}
		
		User[] result = new User[tmpList.size()];
		tmpList.toArray(result);
		return result;
		
	}
	
	// VipUser만 반환
	public VipUser[] getVipUsers() {
		List<VipUser> tmpList = new ArrayList<>();
		
		for(User u : userList) {
			if(u instanceof VipUser) {
				tmpList.add((VipUser) u);
			}
		}
		
		VipUser[] result = new VipUser[tmpList.size()];
		tmpList.toArray(result);
		
		return result;
		
	}
	
	public User[] searchByName(String name) throws NameNotFoundException {
		List<User> tmpList = new ArrayList<>();

		for (User u : userList) {
			// 주어진 이름을 포함하는 사용자인지 검사
			if (u.getName().contains(name)) {
				tmpList.add(u);
			}
		}
		
		if (tmpList.size() == 0) {
			throw new NameNotFoundException(name);
		}

		User[] result = new User[tmpList.size()];
		tmpList.toArray(result);
		return result;
	}
	
	// 사용자의 평균 나이 반환
	public double getAgeAvg() {
		
		int sum = 0;
		
		for(User u : userList) {
			sum += u.getAge();
		}
		
		return sum/ userList.size();
		
	}

}