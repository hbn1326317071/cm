package org.cm.service;

import org.cm.entity.RouteOtherFindInfo;

public interface QueryStationInfoService {
	public RouteOtherFindInfo queryStation(String stationName);
	public double queryFee(String from,String to);
	public int queryStationNum(String from,String to);
	public int queryRunTime(String from,String to);
	
}
