package ssafy.hw.step7.Q2058;

public class ProductTest {

	public static void main(String[] args) {

		Refrigerator r1 = new Refrigerator("R00001", "S냉장고", 1000000, 20, "삼성", "삼성에서 출시한 스마트냉장고입니다.", "냉장고", 1000, true, 2021);
		Refrigerator r2 = new Refrigerator("R00002", "L냉장고", 100000, 10, "엘리스", "엘리스 저가형 냉장고.", "냉장고", 300, false, 2022);
		Refrigerator r3 = new Refrigerator("R00003", "T냉장고", 3000000, 200, "로보", "로보에서 출시한 AI냉장고입니다.", "냉장고", 1200, true, 2022);
		Refrigerator r4 = new Refrigerator("R00004", "K냉장고", 500000, 50, "코라", "코라에서 출시한 보급형냉장고입니다.", "냉장고", 700, false, 2021);
		Refrigerator r5 = new Refrigerator("R00005", "A냉장고", 1000000, 10, "에이스", "에이스에서 출시한 스마트냉장고입니다.", "냉장고", 800, true, 2022);
		Product p1 = new Product("P00001", "우주폰S", 500000, 100, "삼성", "삼성에서 출시한 우주폰S입니다.");
		
		IProductManager pm = ProductManagerImpl.getInstance();
		
		pm.addProduct(r1);
		pm.addProduct(r2);
		pm.addProduct(r3);
		pm.addProduct(r4);
		pm.addProduct(r5);
		pm.addProduct(p1);
		
		System.out.println("********************냉장고목록********************");
		for(Refrigerator r : pm.getRefrigerators()) {
			System.out.println(r);
		}
		
		System.out.println("********************냉동고 있는 목록********************");
		for(Refrigerator r : pm.getRefrigeratorsFreezer(true)) {
			System.out.println(r);
		}
		
		System.out.println("********************이름 검색********************");
		for(Product p : pm.searchByName("S")) {
			System.out.println(p);
		}
		
		System.out.println("********************재고 총가격********************");
		System.out.println(pm.getTotalPrice());
		
	}

}
