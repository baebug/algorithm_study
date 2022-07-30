package ssafy.hw.step10.Q2079;

public interface IUserManager {
	void add(User user);
	
	User[] getList();
	
	User[] getUsers();
	
	VipUser[] getVipUsers();
	
	User[] searchByName(String name) throws NameNotFoundException;
	
	double getAgeAvg();
	
	void saveData();
	void loadData();
}
