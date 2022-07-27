package ssafy.hw.step8.Q2064;

import java.util.List;

public interface IProductManager {
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean removeProduct(String pCode);
	int sell(String pCode, int cnt);
	Product[] getProductList();
	Product searchByCode(String pCode);
	boolean addReview(Review review);
	boolean removeReview(Review review);
	List<Review> getProductReview(String pCode);
	Product[] searchByName(String name);
	long getTotalPrice();
	Product[] getProducts();
	Refrigerator[] getRefrigerators();
	Refrigerator[] getRefrigeratorsFreezer(boolean freezer);
	
}
