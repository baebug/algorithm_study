package ssafy.hw.step10.Q2080;

import java.util.List;

public interface IProductManager {
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean removeProduct(String pCode);
	int sell(String pCode, int cnt) throws QuantityException, ProductCodeNotFoundException;
	Product[] getProductList();
	Product searchByCode(String pCode) throws ProductCodeNotFoundException;
	boolean addReview(Review review);
	boolean removeReview(Review review);
	List<Review> getProductReview(String pCode) throws ReviewNotFoundException;
	Product[] searchByName(String name) throws NameNotFoundException;
	long getTotalPrice();
	Product[] getProducts();
	Refrigerator[] getRefrigerators();
	Refrigerator[] getRefrigeratorsFreezer(boolean freezer);
	
	void saveData();
}
