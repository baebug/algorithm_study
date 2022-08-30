package ssafy.hw.step7.Q2061;

public interface IRestaurantManager {
	void addRestaurant(Restaurant restaurant);
	void removeRestaurant(Restaurant restaurant);
	Restaurant[] getRestaurantList();
	Restaurant searchByresId(int resId);
	KoreanRestaurant[] getKoreanRestaurants();
	Restaurant[] getNonKoreanRestaurants();
	
}
