package org.cm.service;

import java.util.List;

import org.cm.entity.Car;

public interface CarService {
	public boolean  distributeRoteToCar(int circuitId,int carId);
	public int addCar();
	public boolean removeCarById(int carId);
	public boolean changeDepartureTime(int carId,long time);
	public List<Car> getCarsInfoByRunningType(int runningType);
}
