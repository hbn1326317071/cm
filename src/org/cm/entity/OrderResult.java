package org.cm.entity;

import java.io.Serializable;

public class OrderResult implements Serializable{
	
private int carId;//成功返回车辆的id
private int currentId;//成功返回车辆行驶的路线
private boolean flag;//判断下单是否成功
public int getCarId() {
	return carId;
}
public void setCarId(int carId) {
	this.carId = carId;
}
public int getCurrentId() {
	return currentId;
}
public void setCurrentId(int currentId) {
	this.currentId = currentId;
}
public boolean isFlag() {
	return flag;
}
public void setFlag(boolean flag) {
	this.flag = flag;
}

}
