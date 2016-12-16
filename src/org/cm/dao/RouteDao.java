package org.cm.dao;

import java.util.List;

import org.cm.entity.Route;

public interface RouteDao {
	//通过自关联的方式来查询出自己所有的路线
	public List<Route> findById(int id);
	public List<Route> findAllId();
	public List<Route> findByName(String stationName);
	
	

}
