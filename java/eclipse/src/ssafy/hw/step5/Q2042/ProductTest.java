package ssafy.hw.step5.Q2042;

public class ProductTest {

	public static void main(String[] args) {

		Product p1 = new Product("R00001", "S냉장고", 1000000, 20, "삼성", "삼성에서 출시한 스마트냉장고입니다.");
		Product p2 = new Product("P00001", "우주폰S", 500000, 100, "삼성", "삼성에서 출시한 우주폰S입니다.");
		
		Review r1 = new Review(1, "P00001", "yang", "성능이 아주 좋습니당~!");

		ProductManager pm = new ProductManager();
		
		pm.addProduct(p1);
		pm.addProduct(p2);
		pm.addProduct(new Product("P00002", "우주폰S2", 600000, 100, "삼성", "삼성에서 출시한 우주폰S2입니다."));
		
		pm.addReview(r1);
		pm.addReview(new Review(2, "P00001", "bong", "성능이 마음에 쏙 들어요."));
		
		
		System.out.println("********************제품목록********************");
		for(Product p : pm.getProductList()) {
			System.out.println(p);
		}
		System.out.println("********************P00001 제품의 리뷰내용********************");
		for(Review r : pm.getProductReview("P00001")) {
			System.out.println(r);
		}
		
		System.out.println("********************P00001 제품 수정********************");
		pm.updateProduct(new Product("P00001", "우주폰S", 500000, 100, "삼성", "삼성에서 출시한 우주폰S입니다..."));
		for(Product p : pm.getProductList()) {
			System.out.println(p);
		}
		
		System.out.println("********************P00002 제품 삭제********************");
		pm.removeProduct("P00002");
		for(Product p : pm.getProductList()) {
			System.out.println(p);
		}
		
		System.out.println("********************2번 리뷰 삭제********************");
		pm.removeReview(2);
		for(Review r : pm.getProductReview("P00001")) {
			System.out.println(r);
		}
		
	}

}
