package org.cm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.cm.dao.RouteDao;
import org.cm.entity.Route;
import org.cm.entity.RouteOtherFindInfo;
import org.cm.service.QueryRouteService;
import org.cm.service.QueryStationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class QueryStationInfoServiceImpl implements QueryStationInfoService{
	//定义每一站的票价为1元
	@Value("#{fee.fee}")  
	private    double FEE;
	@Value("#{fee.cost}")
	private int costTime;//定义每一个站点的时间为5分钟
	
	@Autowired
	private RouteDao routeDao;
	@Autowired
	private QueryRouteService queryRouteService;
	@Override
	public RouteOtherFindInfo queryStation(String stationName) {
		//查询站点名称以及所在的路线
		List<Route> routeList=routeDao.findByName(stationName);
		//从routeList中提取出id
		List<Integer> ids=new ArrayList<Integer>();
	if(routeList!=null){
		for(int i=0;i<routeList.size();i++){
			ids.add(routeList.get(i).getCircuit_id());
		}
	}
		
		RouteOtherFindInfo info=new RouteOtherFindInfo();
		info.setStationName(stationName);
		
		info.setRouteInIds(ids.toArray( new Integer[]{}));
		
		return info;
	}

	@Override
	public int queryStationNum(String from, String to) {
	Map<Integer,String[]> routeMap=	queryRouteService.queryRouteFromTo(from, to);
	System.out.println("daozhele1");
	if(routeMap==null){//表示输入的路线存在
		System.out.println("map is null");
	return 0;
	}
	//采用迭代器遍历map找出所有的map中各最短的一条路线
	Iterator iter = routeMap.entrySet().iterator();
	int leastStationNum=0;
	int i=0;
	int count=0;//用来保证第一次赋值大于0的数给站点
	while(iter.hasNext()){//遍历所有的路线
		System.out.println("i:"+(++i));
	 Entry  entry=(Entry) iter.next();
	 String[] result=(String[]) entry.getValue();
	 System.out.println("luxaindesize:"+result.length);
	 
	 if(result.length>0&&count==0){
		 //保证得到的所有的
		 leastStationNum=result.length;
		 count++;
	 }
	 if(result.length>0&&count>0){
		 if(leastStationNum>result.length){
			 leastStationNum=result.length;
		 }
		 
	 }
	 
	
	}
	 System.out.println("leastStationNum"+leastStationNum);
		return leastStationNum;
	}

	@Override
	public  double queryFee(String from, String to) {
		int distance=queryStationNum( from,  to);
		if(distance>=1){
		double resultFee=(distance-1)*FEE;
		return resultFee;
		}else{
			return 0;
		}
		
		
	}
	@Override
	public int queryRunTime(String from, String to) {
		int distance=queryStationNum( from,  to);
		if(distance>=1){
		int allCostTime=(distance-1)*costTime;
		return allCostTime;
		}else{
			return 0;
		}
		
		
	}
	
	
	

	public double getFEE() {
		return FEE;
	}

	public void setFEE(double fEE) {
		FEE = fEE;
	}

	public int getCostTime() {
		return costTime;
	}

	public void setCostTime(int costTime) {
		this.costTime = costTime;
	}

	@Override
	public int queryStationNumById(String from, String to,int id) {
		Map<Integer,String[]> routeMap=	queryRouteService.queryRouteFromTo(from, to);
		if(routeMap==null){//表示输入的路线存在
			System.out.println("map is null");
		return 0;
		}
		//采用迭代器遍历map找出所有的map中各最短的一条路线
		Iterator iter = routeMap.entrySet().iterator();
		String[] result=null;
		while(iter.hasNext()){//遍历所有的路线
		 Entry  entry=(Entry) iter.next();
		 if(entry.getKey().equals(id)){
		 result=(String[]) entry.getValue();
		 }
		
		}
		if(result==null||result.length==0){
			return 0;
		}
		System.out.println("result.length"+result.length);
		return result.length-1;
	}

	@Override
	public double queryFeeById(String from, String to, int id) {
		int distance=queryStationNumById( from,  to,id);
		if(distance>=1){
		double resultFee=(distance)*FEE;
		return resultFee;
		}else{
			return 0;
		}
		
	}

	@Override
	public int queryRunTimeById(String from, String to, int id) {
		int distance=queryStationNumById( from,  to,id);
		if(distance>=1){
		int allCostTime=(distance)*costTime;
		return allCostTime;
		}else{
			return 0;
		}
	}





}
