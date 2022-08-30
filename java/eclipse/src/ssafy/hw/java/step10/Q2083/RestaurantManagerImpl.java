package ssafy.hw.step10.Q2083;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


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
		Gson gson = new Gson();
		try {
			restaurants = gson.fromJson(new FileReader("data/restaurant.json"), new TypeToken<List<Restaurant>>(){}.getType());
		} catch (FileNotFoundException e) {
			System.out.println("파일 불러오기 실패");
			e.printStackTrace();
		}
		return restaurants;
	}

	@Override
	public Restaurant searchByresId(int resId) throws RestaurantNotFoundException {
		Gson gson = new Gson();
		try {
			restaurants = gson.fromJson(new FileReader("data/restaurant.json"), new TypeToken<List<Restaurant>>(){}.getType());
		} catch (FileNotFoundException e) {
			System.out.println("파일 불러오기 실패");
			e.printStackTrace();
		}
		
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
