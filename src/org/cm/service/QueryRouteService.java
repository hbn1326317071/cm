package org.cm.service;

import java.util.HashMap;

import org.cm.entity.RouteOtherFindInfo;

public interface QueryRouteService {
	public HashMap<Integer,String[]> queryRoute(String from,String to);
	public String[] queryRoute(String from,String to ,int id);
	public  HashMap<Integer,String[]> queryRouteFromTo(String from ,String to);
	public String[]  getStartAndEndStationById(String from,String to,int id);
	public HashMap<Integer,Double> queryFee(String from,String to);
	public HashMap<Integer,Integer> queryTime(String from,String to);
	public HashMap<Integer,String[]>getAllRoute();
}
