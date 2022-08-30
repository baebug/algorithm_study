package ssafy.hw.step5.Q2043;

public class CarManager {
	private Car[] carList = new Car[100];
	private int size = 0;
	
	public boolean add(Car car) {
		if (this.size < 100) {
			carList[this.size] = car;
			this.size++;
			return true;
		} else {
			return false;
		}
	}
	
	public Car[] getList() {
		Car[] result = new Car[this.size];
		
		for (int i = 0; i < this.size; i++) {
			result[i] = carList[i];
		}
		
		return result;
	}
	
	public Car[] searchByModelName(String modelName) {
		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if (carList[i].getModelName().contains(modelName)) {
				cnt++;
			}
		}
		
		Car[] result = new Car[cnt];
		int idx = 0;
		for (int i = 0; i < this.size; i++) {
			if (carList[i].getModelName().contains(modelName)) {
				result[idx] = carList[i];
				idx++;
			}
		}
		return result;
	}
}
