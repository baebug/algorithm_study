package ssafy.hw.step10.Q2080;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ProductManagerImpl implements IProductManager {
	
	List<Product> products = new ArrayList<>();
	Map<String, List<Review>> reviews = new HashMap<>();
	
	int reviewNo = 0;
	
	private static IProductManager productManager = new ProductManagerImpl();
	
	private ProductManagerImpl() {
		this.loadProductData();
		this.loadReviewData();
	}
	
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
	
	private void loadProductData() {
		Gson gson = new Gson();
		try {
//			List<Object> tmpList = gson.fromJson(new FileReader("data/refrigerator.json"), List.class);
//			List<Object> tmpList = gson.fromJson(new FileReader("data/refrigerator.json"), products.getClass());
//			products = gson.fromJson(new FileReader("data/refrigerator.json"), new TypeToken<List<Product>>(){}.getType());
			products = gson.fromJson(new FileReader("data/refrigerator.json"), new TypeToken<List<Refrigerator>>(){}.getType());
//			System.out.println(products.getClass()); // class java.util.ArrayList
//			System.out.println(products.get(0) instanceof Object); // true
//			System.out.println(products.get(0) instanceof Product); // false
//			System.out.println(products.get(0) instanceof Refrigerator); // false
//			System.out.println(products.get(0).getClass());
			
//			for(Object o : tmpList) {
//				products.add((Refrigerator) o);
//			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일 불러오기 실패");
			e.printStackTrace();
		}
	}
	
	private void loadReviewData() {
		File file = new File("data/review.dat");
		
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				reviews = (Map<String, List<Review>>) ois.readObject();
			} catch (Exception e) {
				System.out.println("파일 불러오기 실패");
				e.printStackTrace();
			}
		}
	}
	
	public void saveData() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/review.dat"))) {
			oos.writeObject(reviews);
		} catch (IOException e) {
			System.out.println("파일 쓰기 실패");
			e.printStackTrace();
		}
	}
}
