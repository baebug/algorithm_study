package ssafy.hw.step5.Q2042;

import java.util.Arrays;

public class ProductManager {
	private final int MAX_PRODUCT_SIZE = 100;
	private final int MAX_REVIEW_SIZE = 1000;
	
	Product[] products = new Product[MAX_PRODUCT_SIZE];
	Review[] reviews = new Review[MAX_REVIEW_SIZE];
	
	int pCount = 0;
	int rCount = 0;
	
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
	
}
