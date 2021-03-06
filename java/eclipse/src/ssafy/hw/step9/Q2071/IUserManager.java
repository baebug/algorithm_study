package ssafy.hw.step9.Q2071;

public interface IUserManager {
	void add(User user);
	
	User[] getList();
	
	User[] getUsers();
	
	VipUser[] getVipUsers();
	
	User[] searchByName(String name) throws NameNotFoundException;
	
	double getAgeAvg();
}
