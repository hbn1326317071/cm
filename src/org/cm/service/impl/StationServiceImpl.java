package org.cm.service.impl;

import org.cm.dao.RouteDao;
import org.cm.entity.Route;
import org.cm.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class StationServiceImpl implements StationService {
	
	@Autowired
	private RouteDao routeDao;
	public boolean addStation(int circuitId, String stationName, String prev,
			String next) {
		boolean result = true;
		Route station = new Route();
		//检查该站是否存在
		if(routeDao.findByName(stationName).size()!=0)
			return false;
		station.setStation_name(stationName);
		if(routeDao.findByName(prev).size()==0)
			return false;
		//检查上一站是否存在
		station.setPrev(prev);
		if(routeDao.findByName(next).size()==0)
			return false;
		//检查下一站是否存在
		station.setNext(next);
		station.setDirection("上行");//默认
		station.setCircuit_id(circuitId);

		
		//修改上一站的下一站
		Route preStation = new Route();
		preStation.setCircuit_id(circuitId);
		preStation.setStation_name(prev);
		preStation.setNext(stationName);
		
		if(routeDao.updateNext(preStation)==0)
			return false;
		//增加该站
		if(routeDao.addStation(station)==0)
			return false;
		//修改下一站的上一站
		Route nextStation = new Route();
		nextStation.setCircuit_id(circuitId);
		nextStation.setStation_name(next);
		nextStation.setPrev(stationName);
		if(routeDao.updatePrev(nextStation)==0)
			return false;
		
		
		return result;//如果修改失败返回false,提醒增加失败，原因可能是该站已经存在，或者上一站或者下一站不存在
	}
	@Override
	public boolean addRoute(String route) {
		int circuitId = routeDao.findMaxCircuitId()+1;//线路号，自己设置，默认最大值+1
		
		String [] stations = route.split(",");
		if(stations.length<=1)//当站点小于1个时，不允许添加
			return false;
		//插入首站
		Route station = new Route();
		station.setStation_name(stations[0]);
	    station.setNext(stations[1]);
	    station.setDirection("上行");
	    station.setCircuit_id(circuitId);
	    //插入中间站
	    if(routeDao.addStation(station)==0){
	    	try {
				throw new Exception("添加站点失败");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return false;
	    }
	    //插入最后一站
		for(int i =1;i<stations.length-1;i++){
		    station = new Route();
			station.setStation_name(stations[i]);
			station.setPrev(stations[i-1]);
		    station.setNext(stations[i+1]);
		    station.setDirection("上行");
		    station.setCircuit_id(circuitId);
		    if(routeDao.addStation(station)==0){
		    	try {
					throw new Exception("添加站点失败");
				} catch (Exception e) {
					e.printStackTrace();
				}
		    	return false;
		    }	
		}
		station = new Route();
		station.setStation_name(stations[stations.length-1]);
	    station.setPrev(stations[stations.length-2]);
	    station.setDirection("上行");
	    station.setCircuit_id(circuitId);
	    if(routeDao.addStation(station)==0){
	    	try {
				throw new Exception("添加站点失败");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return false;
	    }
		return true;
	}

	public static void main(String[] args) {
		
		
		String route = "东门,图书馆,南门,西街";
		String [] stations = route.split(",");
		for(String s:stations)
			System.out.println(s+";");
		
		
	}

}
