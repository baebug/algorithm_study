package ssafy.hw.step9.Q2076;

import java.util.List;

public interface IRestaurantManager {
	void addRestaurant(Restaurant restaurant);
	void removeRestaurant(int resId);
	List<Restaurant> getRestaurantList();
	Restaurant searchByresId(int resId) throws RestaurantNotFoundException;
	List<KoreanRestaurant> getKoreanRestaurants();
	List<Restaurant> getNonKoreanRestaurants();
	IReviewManager getReviewManager(int resId);
	
}
