package ssafy.hw.step9.Q2073;

public class ElectricCar extends Car {
	
	private int battery;
	
	public ElectricCar() {}

	public ElectricCar(String VIN, String modelName, String color, int mileage, int battery) {
		super(VIN, modelName, color, mileage);
		this.battery = battery;
	}
	
	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	@Override
	public String toString() {
		return super.toString() + "+ battery=" + battery + "]";
	}
	
}
