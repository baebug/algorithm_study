package ssafy.hw.step10.Q2081;

public class ElectricCar extends Car {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
