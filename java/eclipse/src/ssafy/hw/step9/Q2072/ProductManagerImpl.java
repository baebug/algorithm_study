package ssafy.hw.step9.Q2072;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManagerImpl implements IProductManager {
	
	List<Product> products = new ArrayList<>();
	Map<String, List<Review>> reviews = new HashMap<>();
	
	int reviewNo = 0;
	
	private static IProductManager productManager = new ProductManagerImpl();
	
	private ProductManagerImpl() {}
	
	public static IProductManager getInstance() {
		return productManager;
	}
	
	public boolean addProduct(Product product) {
		products.add(product);
		return true;
	}
	
	public boolean updateProduct(Product product) {
		String id = product.getpCode();
		
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getpCode().equals(id)) {
				products.set(i, product);
				return true;
			}
		}
		
		System.out.println("상품이 존재하지 않습니다.");
		return false;
	}
	
	public boolean removeProduct(String pCode) {
		products.removeIf(p -> p.getpCode().equals(pCode));
		return true;
	}
	
	public int sell(String pCode, int cnt) throws QuantityException, ProductCodeNotFoundException {
		Product product = this.searchByCode(pCode);
		int result = product.getQuantity() - cnt;
		
		if (result < 0) {
			throw new QuantityException();
		}
		
		product.setQuantity(result);
		
		return product.getPrice() * cnt;
	}
	
	public Product[] getProductList() {
		Product[] tmpList = new Product[products.size()];
		products.toArray(tmpList);
		return tmpList;
	}
	
	public Product searchByCode(String pCode) throws ProductCodeNotFoundException {
		for (Product p : products) {
			if (p.getpCode().equals(pCode)) {
				return p;
			}
		}
		
		throw new ProductCodeNotFoundException(pCode);
	}
	
	public boolean addReview(Review review) {
//		List<Review> tmpList = reviews.get(review.getpCode());	// null 일 경우도 있지 않나?
		List<Review> tmpList = reviews.getOrDefault(review.getpCode(), new ArrayList<Review>());
		tmpList.add(review);
		reviews.put(review.getpCode(), tmpList);
		
		return true;
	}
	
	public boolean removeReview(Review review) {
		List<Review> tmpList = reviews.getOrDefault(review.getpCode(), new ArrayList<Review>());
		tmpList.removeIf(r -> r.getReviewId() == review.getReviewId());
		reviews.put(review.getpCode(), tmpList);
		return true;
	}
	
	public List<Review> getProductReview(String pCode) throws ReviewNotFoundException {
		List<Review> list = reviews.getOrDefault(pCode, new ArrayList<Review>());
		
		if (list.size() == 0) {
			throw new ReviewNotFoundException(pCode);
		}
		
		return list;
	}
	
	public Product[] searchByName(String name) throws NameNotFoundException {
		List<Product> tmpList = new ArrayList<>();
		
		for (Product p : products) {
			if (p.getpName().contains(name)) {
				tmpList.add(p);
			}
		}
		
		if (tmpList.size() == 0) {
			throw new NameNotFoundException(name);
		}
		
		Product[] result = new Product[tmpList.size()];
		tmpList.toArray(result);
		return result;
	}
	
	public long getTotalPrice() {
		long total = 0L;
		
		for (Product p : products) {
			total += p.getPrice() * p.getQuantity(); 
		}
		
		return total;
	}
	
	// 냉장고가 아닌 일반상품 리스트를 반환
	public Product[] getProducts() {
		List<Product> tmpList = new ArrayList<>();
		
		for (Product p : products) {
			if (!(p instanceof Refrigerator)) {
				tmpList.add(p);
			}
		}
		
		Product[] result = new Product[tmpList.size()];
		tmpList.toArray(result);
		return result;
	}
	
	public Refrigerator[] getRefrigerators() {
		List<Refrigerator> tmpList = new ArrayList<>();
		
		for (Product p : products) {
			if (p instanceof Refrigerator) {
				tmpList.add((Refrigerator) p);
			}
		}
		
		Refrigerator[] result = new Refrigerator[tmpList.size()];
		tmpList.toArray(result);
		return result;
	}
	
	public Refrigerator[] getRefrigeratorsFreezer(boolean freezer) {
		List<Refrigerator> tmpList = new ArrayList<>();
		
		for(Refrigerator r : this.getRefrigerators()) {
			if (r.isFreezer() == freezer) {
				tmpList.add(r);
			}
		}
		
		Refrigerator[] result = new Refrigerator[tmpList.size()];
		tmpList.toArray(result);
		return result;
	}
	
}
