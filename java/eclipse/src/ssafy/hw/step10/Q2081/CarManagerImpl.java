package ssafy.hw.step10.Q2081;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CarManagerImpl implements ICarManager {
	private List<Car> carList = new ArrayList<>();
	
	private static ICarManager carManager = new CarManagerImpl();
	
	private CarManagerImpl() {
		this.loadData();
	}
	
	private void loadData() {
		File file = new File("car.dat");
		
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				carList = (List<Car>) ois.readObject();
			} catch (Exception e) {
				System.out.println("파일 불러오기 실패");
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void saveData() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("car.dat"))) {
			oos.writeObject(carList);
		} catch (Exception e) {
			System.out.println("파일 저장 실패");
			e.printStackTrace();
		}
	}
	
	
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
