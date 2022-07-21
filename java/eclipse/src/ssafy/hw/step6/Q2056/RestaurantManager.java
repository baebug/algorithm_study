package ssafy.hw.step6.Q2056;

import java.util.Arrays;

public class RestaurantManager {
	private final int MAX_RESTAURANT_SIZE = 100;
	private final int MAX_REVIEW_SIZE = 1000;
	private Restaurant[] restaurants = new Restaurant[MAX_RESTAURANT_SIZE];
	private Review[] reviews = new Review[MAX_REVIEW_SIZE];
	private int restaurantSize = 0;
	private int reviewSize = 0;
	
	public boolean addRestaurant(Restaurant restaurant) {
		if (this.restaurantSize < MAX_RESTAURANT_SIZE) {
			restaurants[this.restaurantSize] = restaurant;
			this.restaurantSize++;
			
			return true;
		}
		return false;
	}
	
	public boolean addReview(Review review) {
		if (this.reviewSize < MAX_REVIEW_SIZE) {
			reviews[this.reviewSize] = review;
			this.reviewSize++;
			
			return true;
		}
		return false;
	}
	
	// 같은 resId 를 찾으면 덮어버린다. 이후 return
	public boolean updateRestaurant(Restaurant restaurant) {
		int resId = restaurant.getResId();
		
		for (int i = 0; i < this.restaurantSize; i++) {
			if (restaurants[i].getResId() == resId) {
				restaurants[i] = restaurant;
				return true;
			}
		}
		return true;
	}
	
	// 해당 resId 를 찾으면 마지막 원소를 가져와 덮어버린다. 마지막 원소를 null 로 바꿔주고 size 를 한 칸 줄인 뒤 return
	public boolean removeRestaurant(Restaurant restaurant) {
		int resId = restaurant.getResId();
		
		for (int i = 0; i < this.restaurantSize; i++) {
			if (restaurants[i].getResId() == resId) {
				restaurants[i] = restaurants[this.restaurantSize - 1];
				restaurants[this.restaurantSize - 1] = null;
				this.restaurantSize--;
				return true;
			}
		}
		return false;
	}
	
	public boolean removeReview(Review review) {
		int reviewId = review.getReviewId();
		
		for (int i = 0; i < this.reviewSize; i++) {
			if (reviews[i].getReviewId() == reviewId) {
				reviews[i] = reviews[this.reviewSize - 1];
				reviews[this.reviewSize - 1] = null;
				this.reviewSize--;
				return true;
			}
		}
		return false;
	}
	
	public Restaurant searchByresId(int resId) {
		for (int i = 0; i < restaurantSize; i++) {
			if (restaurants[i].getResId() == resId) {
				return restaurants[i];
			}
		}
		return null;
	}
	
	public Restaurant[] getRestaurantList() {
		return Arrays.copyOfRange(restaurants, 0, restaurantSize);
	}
	
	public Review[] getRestaurantReview(int resId) {
		int cnt = 0;
		
		for (int i = 0; i < this.reviewSize; i++) {
			if (reviews[i].getResId() == resId) {
				cnt++;
			}
		}
		
		Review[] tmpList = new Review[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.reviewSize; i++) {
			if (reviews[i].getResId() == resId) {
				tmpList[idx] = reviews[i];
				idx++;
			}
		}
		return tmpList;
	}
	
	public Restaurant getRestaurant(int resId) {
		for (int i = 0; i < restaurantSize; i++) {
			if (restaurants[i].getResId() == resId) {
				return restaurants[i];
			}
		}
		return null;
	}
	
	public Restaurant[] getNomRestaurants() {
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
	
	
	
}
