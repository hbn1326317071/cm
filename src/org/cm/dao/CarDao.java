package org.cm.dao;

import java.util.List;

import org.cm.entity.Car;
import org.cm.entity.Order;

public interface CarDao {
	public int updateCarById(Car car);
	public int addCar(Car car);
	public int removeCarById(int carId);
	public int getMaxId();//¸¨Öú
	public Car findById(int carId);
	public List<Car> findByRunningType(int runningType);
	
	
}
