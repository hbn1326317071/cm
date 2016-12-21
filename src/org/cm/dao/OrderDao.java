package org.cm.dao;

import java.util.List;

import org.cm.entity.Car;
import org.cm.entity.CountsOrder;
import org.cm.entity.Order;

public interface OrderDao {
public List<Car> findByCurrentId(int id);
public int save(Order order);
public List<Order> findAll();
public int getAllOrders(long time);
public int getPersonsPeriod(Order order);
public List<Order> getIncomePeriod(Order order);
public List<CountsOrder> getBusestOfThree(Order order);//查询获取人数最多的前三站点
}
