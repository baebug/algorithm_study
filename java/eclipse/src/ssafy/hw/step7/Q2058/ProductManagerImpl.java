package ssafy.hw.step7.Q2058;

import java.util.Arrays;

public class ProductManagerImpl implements IProductManager {
	private final int MAX_PRODUCT_SIZE = 100;
	private final int MAX_REVIEW_SIZE = 1000;
	
	Product[] products = new Product[MAX_PRODUCT_SIZE];
	Review[] reviews = new Review[MAX_REVIEW_SIZE];
	
	int pCount = 0;
	int rCount = 0;
	
	private static IProductManager productManager = new ProductManagerImpl();
	
	private ProductManagerImpl() {}
	
	public static IProductManager getInstance() {
		return productManager;
	}
	
	public boolean addProduct(Product product) {
		if (pCount < MAX_PRODUCT_SIZE) {
			products[pCount] = product;
			pCount++;
			return true;
		} else {
			System.out.println("더 이상 상품을 등록할 수 없습니다.");
			return false;
		}
	}
	
	public boolean updateProduct(Product product) {
		String id = product.getpCode();
		
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpCode().equals(id)) {
				products[i] = product;
				return true;
			}
		}
		
		System.out.println("상품이 존재하지 않습니다.");
		return false;
	}
	
	public boolean removeProduct(String pCode) {
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpCode().equals(pCode)) {
				products[i] = products[pCount - 1];
				products[pCount - 1] = null;
				pCount--;
				return true;
			}
		}
		
		System.out.println("상품이 존재하지 않습니다.");
		return false;
	}
	
	public int sell(String pCode, int cnt) {
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpCode().equals(pCode)) {
				Product item = products[i];
				if (item.getQuantity() >= cnt) {
					item.setQuantity(item.getQuantity() - cnt);
					return item.getPrice() * cnt;
				} else {
					System.out.println("상품의 수가 부족합니다.");
					return 0;
				}
			}
		}
		
		System.out.println("상품이 존재하지 않습니다.");
		return 0;
	}
	
	public Product[] getProductList() {
		return Arrays.copyOfRange(products, 0, pCount);
	}
	
	public Product searchByCode(String pCode) {
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpCode().equals(pCode)) {
				return products[i];
			}
		}
		
		System.out.println("상품이 존재하지 않습니다.");
		return null;
	}
	
	public boolean addReview(Review review) {
		if (rCount < MAX_REVIEW_SIZE) {
			reviews[rCount] = review;
			rCount++;
			return true;
		} else {
			System.out.println("더 이상 리뷰를 등록할 수 없습니다.");
			return false;
		}
	}
	
	public boolean removeReview(int reviewId) {
		for (int i = 0; i < rCount; i++) {
			if (reviews[i].getReviewId() == reviewId) {
				reviews[i] = reviews[rCount - 1];
				reviews[rCount - 1] = null;
				rCount--;
				return true;
			}
		}
		
		System.out.println("리뷰가 존재하지 않습니다.");
		return false;
	}
	
	public Review[] getProductReview(String pCode) {
		int cnt = 0;
		
		for (int i = 0; i < rCount; i++) {
			if (reviews[i].getpCode().equals(pCode)) {
				cnt++;
			}
		}
		
		Review[] result = new Review[cnt];
		int idx = 0;
		
		for (int i = 0; i < rCount; i++) {
			if (reviews[i].getpCode().equals(pCode)) {
				result[idx++] = reviews[i];
			}
		}
		
		return result;
	}
	
	public Product[] searchByName(String name) {
		int cnt = 0;
		
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpName().contains(name)) {
				cnt++;
			}
		}
		
		Product[] result = new Product[cnt];
		int idx = 0;
		
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpName().contains(name)) {
				result[idx++] = products[i];
			}
		}
		
		return result;
	}
	
	public long getTotalPrice() {
		long total = 0L;
		
		for (int i = 0; i < pCount; i++) {
			total += products[i].getPrice() * products[i].getQuantity(); 
		}
		
		return total;
	}
	
	// 냉장고가 아닌 일반상품 리스트를 반환
	public Product[] getProducts() {
		int cnt = 0;
		
		for (int i = 0; i < pCount; i++) {
			if (!(products[i] instanceof Refrigerator)) {
				cnt++;
			}
		}
		
		Product[] result = new Product[cnt];
		int idx = 0;
		
		for (int i = 0; i < pCount; i++) {
			if (!(products[i] instanceof Refrigerator)) {
				result[idx++] = products[i];
			}
		}
		
		return result;
	}
	
	public Refrigerator[] getRefrigerators() {
		int cnt = 0;
		
		for (int i = 0; i < pCount; i++) {
			if (products[i] instanceof Refrigerator) {
				cnt++;
			}
		}
		
		Refrigerator[] result = new Refrigerator[cnt];
		int idx = 0;
		
		for (int i = 0; i < pCount; i++) {
			if (products[i] instanceof Refrigerator) {
				result[idx++] = (Refrigerator) products[i];
			}
		}
		
		return result;
	}
	
	public Refrigerator[] getRefrigeratorsFreezer(boolean freezer) {
		int cnt = 0;
		
		for(Refrigerator r : this.getRefrigerators()) {
			if (r.isFreezer() == freezer) {
				cnt++;
			}
		}
		
		Refrigerator[] result = new Refrigerator[cnt];
		int idx = 0;
		
		for(Refrigerator r : this.getRefrigerators()) {
			if (r.isFreezer() == freezer) {
				result[idx++] = r;
			}
		}
		
		return result;
	}
	
}
