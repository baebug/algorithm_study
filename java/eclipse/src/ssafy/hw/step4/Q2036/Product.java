package ssafy.hw.step4.Q2036;

public class Product {
	String pCode;
	String pName;
	int price;
	int quantity;
	String brand;
	String desc;
	
	public Product() {}

	public Product(String pCode, String pName, int price, int quantity, String brand, String desc) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Product [pCode=" + pCode + ", pName=" + pName + ", price=" + price + ", quantity=" + quantity
				+ ", brand=" + brand + ", desc=" + desc + "]";
	}
	
}
