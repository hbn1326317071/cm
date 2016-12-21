package org.cm.service;

public interface StationService {
	public boolean addStation(int circuitId,String stationName,String prev,String next);
	
	public boolean addRoute(String route);
}
