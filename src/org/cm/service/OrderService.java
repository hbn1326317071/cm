package org.cm.service;

import java.util.HashMap;
import java.util.List;

import org.cm.entity.Order;
import org.cm.entity.OrderResult;

public interface OrderService {
/**
 * 为了方便用户需要再次的传入from和to此时，还是再次对current线路进行判断
 * @param from
 * @param to
 * @param currentLine
 */
	public OrderResult order(String from,String to,int currentLine,Long startTime);
/**
 * 查询所有的订单信息，
 */
	public List<Order> findAll();
	
//景辉写的
public int getOrdersOfPayByDate(String date);
	
	public int getPersonsPeriod(String startTime,String endTime);
	
	public double getIncomePeriod(String startTime,String endTime);
	
	public HashMap<String,Integer> getBusestOfThree(String startTime,String endTime);
}
