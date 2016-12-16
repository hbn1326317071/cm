package org.cm.controller;

import java.util.HashMap;

import org.cm.entity.RouteOtherFindInfo;
import org.cm.entity.RouteResult;
import org.cm.service.QueryRouteService;
import org.cm.service.QueryStationInfoService;
import org.cm.service.impl.QueryStationInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class RouteController {
	@Autowired
	private QueryRouteService queryRouteService;
	
	@Autowired
	private  QueryStationInfoService queryStationInfoService;
	
	/**
	 * 查询出从起始站到到终止站点的所有的路线以json数据的形式返回
	 * @param from
	 * @param to
	 * @return
	 */
	@RequestMapping(value = "/queryRouteById.do",produces = "application/json;charset=utf-8")  
	@ResponseBody()
	public  RouteResult queryRouteById(String from ,String to,int id){
		RouteResult result=new RouteResult();
		result.setId(id);
		String [] s=(String[])queryRouteService.queryRoute(from,to, id);
		result.setRouteFindById(s);
		
		return result;
	}
	/**
	 * 查询 所有的路线并返回结果
	 * @param from
	 * @param to
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryRoute.do",produces = "application/json;charset=utf-8")  
	@ResponseBody()
	public RouteResult query(String from ,String to){
		
		RouteResult result=new RouteResult();
		result.setAllRoute(queryRouteService.queryRoute(from,to)); 
		return result;
	}

	/**
 * 查询当前站点，返回当前站点和所在的路线
 * @param stationName
 */
	@RequestMapping(value = "/queryStation.do",produces = "application/json;charset=utf-8")  
	@ResponseBody()
	public RouteOtherFindInfo queryStation(String stationName){
		RouteOtherFindInfo info=queryStationInfoService.queryStation(stationName);
		return info;
	
	}
	/**
	 * 查询费用，按照站点的个数乘以相应的价格比例，若两条线路均能够到达该地点则计算最佳的费用
	 * @param stationName
	 * @return
	 */
	@RequestMapping(value = "/queryFee.do",produces = "application/json;charset=utf-8")  
	@ResponseBody()
	public double  queryFee(String from,String to){
		double fee=queryStationInfoService.queryFee( from, to);
		return fee;
	
	}
	@RequestMapping(value = "/queryTime.do",produces = "application/json;charset=utf-8")  
	@ResponseBody()
	public int  queryTime(String from,String to){
		int costTime=queryStationInfoService.queryRunTime(from, to);
		return costTime;
	
	}
	
	
	
	

}
