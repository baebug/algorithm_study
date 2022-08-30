package ssafy.hw.step9.Q2073;

import java.util.ArrayList;
import java.util.List;

public class CarManagerImpl implements ICarManager {
	private List<Car> carList = new ArrayList<>();
	
	private static ICarManager carManager = new CarManagerImpl();
	
	private CarManagerImpl() {}
	
	public static ICarManager getInstance() {
		return carManager;
	}
	
	public void add(Car car) {
		carList.add(car);
	}
	
	public Car[] getList() {
		Car[] result = new Car[carList.size()];
		carList.toArray(result);
		return result;
	}
	
	public Car[] searchByModelName(String modelName) throws ModelNameNotFoundException {
		List<Car> tmpList = new ArrayList<>();
		
		for (Car c : carList) {
			if (c.getModelName().contains(modelName)) {
				tmpList.add(c);
			}
		}
		
		if (tmpList.size() == 0) {
			throw new ModelNameNotFoundException(modelName);
		}
		
		Car[] result = new Car[tmpList.size()];
		tmpList.toArray(result);
		return result;
	}
	
	public ElectricCar[] getElectricCars() {
		List<ElectricCar> tmpList = new ArrayList<>();
		
		for (Car c : carList) {
			if (c instanceof ElectricCar) {
				tmpList.add((ElectricCar) c);
			}
		}
		
		ElectricCar[] eList = new ElectricCar[tmpList.size()];
		tmpList.toArray(eList);
		return eList;
	}
	
	public int getTotalMileage() {
		int total = 0;
		
		for (Car c : carList) {
			total += c.getMileage();
		}
		return total;
	}
}
