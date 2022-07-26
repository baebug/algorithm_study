package ssafy.hw.step7.Q2061;

import java.util.Arrays;

public class RestaurantManagerImpl implements IRestaurantManager {
	private final int MAX_RESTAURANT_SIZE = 100;
	private Restaurant[] restaurants = new Restaurant[MAX_RESTAURANT_SIZE];
	private int restaurantSize = 0;
	
	private static IRestaurantManager restaurantManager = new RestaurantManagerImpl();
	
	private RestaurantManagerImpl() {}
	
	public static IRestaurantManager getInstance() {
		return restaurantManager;
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		if (this.restaurantSize < MAX_RESTAURANT_SIZE) {
			restaurants[restaurantSize++] = restaurant;
		}
	}

	@Override
	public void removeRestaurant(Restaurant restaurant) {
		int resId = restaurant.getResId();
		
		for (int i = 0; i < this.restaurantSize; i++) {
			if (restaurants[i].getResId() == resId) {
				restaurants[i] = restaurants[this.restaurantSize - 1];
				restaurants[this.restaurantSize - 1] = null;
				this.restaurantSize--;
				return;
			}
		}
	}

	@Override
	public Restaurant[] getRestaurantList() {
		return Arrays.copyOfRange(restaurants, 0, restaurantSize);
	}

	@Override
	public Restaurant searchByresId(int resId) {
		for (int i = 0; i < restaurantSize; i++) {
			if (restaurants[i].getResId() == resId) {
				return restaurants[i];
			}
		}
		return null;
	}

	@Override
	public KoreanRestaurant[] getKoreanRestaurants() {
		int cnt = 0;
		
		for (int i = 0; i < this.restaurantSize; i++) {
			if (restaurants[i] instanceof KoreanRestaurant) {
				cnt++;
			}
		}
		
		KoreanRestaurant[] tmpList = new KoreanRestaurant[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.restaurantSize; i++) {
			if (restaurants[i] instanceof KoreanRestaurant) {
				tmpList[idx++] = (KoreanRestaurant) restaurants[i];
			}
		}
		
		return tmpList;
	}

	@Override
	public Restaurant[] getNonKoreanRestaurants() {
		int cnt = 0;
		
		for (int i = 0; i < this.restaurantSize; i++) {
			if (!(restaurants[i] instanceof KoreanRestaurant)) {
				cnt++;
			}
		}
		
		Restaurant[] tmpList = new Restaurant[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.restaurantSize; i++) {
			if (!(restaurants[i] instanceof KoreanRestaurant)) {
				tmpList[idx++] = restaurants[i];
			}
		}
		
		return tmpList;
	}

}
