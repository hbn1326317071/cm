package org.cm.entity;

import java.io.Serializable;
import java.util.Map;

public class RouteResult implements Serializable{
	private int id;
	private String[] routeFindById;
	private Map<Integer,String[]> allRoute;
	private String name;//当前站点名称
	private int[] routeIn;//当前站点所在的路线
	public int getId() {
	
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String[] getRouteFindById() {
		return routeFindById;
	}
	public void setRouteFindById(String[] routeFindById) {
		this.routeFindById = routeFindById;
	}
	public Map<Integer, String[]> getAllRoute() {
		return allRoute;
	}
	public void setAllRoute(Map<Integer, String[]> allRoute) {
		this.allRoute = allRoute;
	}
	
}
	
