package ssafy.hw.step4.Q2039;

public class Restaurant {
	int resId;
	String name;
	String address;
	String signatureMenu;
	int rate;
	
	public Restaurant() {}
	
	public Restaurant(int resId, String name, String address, String signatureMenu, int rate) {
		this.resId = resId;
		this.name = name;
		this.address = address;
		this.signatureMenu = signatureMenu;
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		return "Restaurant [resId=" + this.resId + ", name=" + this.name + ", address=" + this.address + ", signatureMenu=" + this.signatureMenu + ", rate=" + this.rate + "]";
	}
}
