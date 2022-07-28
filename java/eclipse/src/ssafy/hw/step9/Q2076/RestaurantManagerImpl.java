package ssafy.hw.step9.Q2076;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantManagerImpl implements IRestaurantManager {
	private List<Restaurant> restaurants = new ArrayList<>();
	private Map<Integer, IReviewManager> rvm = new HashMap<>();
	
	private static IRestaurantManager restaurantManager = new RestaurantManagerImpl();
	
	private RestaurantManagerImpl() {}
	
	public static IRestaurantManager getInstance() {
		return restaurantManager;
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		restaurants.add(restaurant);
	}

	@Override
	public void removeRestaurant(int resId) {
		restaurants.removeIf(r -> r.getResId() == resId);
	}

	@Override
	public List<Restaurant> getRestaurantList() {
		return restaurants;
	}

	@Override
	public Restaurant searchByresId(int resId) throws RestaurantNotFoundException {
		for (Restaurant R : restaurants) {
			if (R.getResId() == resId) {
				return R;
			}
		}
		
		throw new RestaurantNotFoundException(resId);
	}

	@Override
	public List<KoreanRestaurant> getKoreanRestaurants() {
		List<KoreanRestaurant> tmpList = new ArrayList<>();
		
		for (Restaurant R : restaurants) {
			if (R instanceof KoreanRestaurant) {
				tmpList.add((KoreanRestaurant) R);
			}
		}
		
		return tmpList;
	}

	@Override
	public List<Restaurant> getNonKoreanRestaurants() {
		List<Restaurant> tmpList = new ArrayList<>();
		
		for (Restaurant R : restaurants) {
			if (!(R instanceof KoreanRestaurant)) {
				tmpList.add(R);
			}
		}
		
		return tmpList;
	}

	@Override
	public IReviewManager getReviewManager(int resId) {
		IReviewManager reviewManager = rvm.getOrDefault(resId, new ReviewManagerImpl());
		rvm.put(resId, reviewManager);
		return reviewManager;
	}

}
