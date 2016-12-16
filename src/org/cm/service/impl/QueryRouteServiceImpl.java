package org.cm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cm.dao.RouteDao;
import org.cm.entity.Route;
import org.cm.service.QueryRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class QueryRouteServiceImpl implements QueryRouteService{
	@Autowired
	private RouteDao routeDao;
	/**
	 * 查询所有路线的站点
	 */
	@Override
	public HashMap<Integer,String[]> queryRoute(String from, String to) {
		/*查询出从起始站点到终止站点所有的路线并且以字符串数组的形式保存下来
		此处采用的形式为遍历查询每一条路线，然后分别把每个站点的信息保存下来
		*/
		//查询数据库中所有的路线id然后根据路线id来查询每一条路线的结果，保存在集合当中
		List<Route> list=routeDao.findAllId();
		List<Integer> allId=new ArrayList<Integer>();
		if(list.size()>0){
		for(Route route:list){
			if(!allId.contains(route.getCircuit_id())){
				allId.add(route.getCircuit_id());
			}
		}
		}
		//根据路线id找出所有的路线
		Map<Integer,String[]> result=new HashMap<Integer,String[]>();
		for(int i=0;i<allId.size();i++){
			String[] str=queryRoute(from, to, allId.get(i));
			
		result.put(allId.get(i), str);
	       
		}
		
		return (HashMap) result;
	}
	
	//查询出一条线路上的所有 站点
	public String[] queryRoute(String from,String to ,int id){
		if(from==null||to==null){
			return null;
		}
		if("".equals(from)||"".equals(to)){
			return null;
		}
		List<Route> routeList=routeDao.findById(id);
		System.out.println("--------路线打印------------");
		//假设传入的站点在整个路线图中均存在
		//遍历集合找到from 到to的所有的站点保存到字符串数组中
		List<String> list=new ArrayList<String>();
		repeatFind(from, to, routeList, list);
		String[] s=null;
		List<String> resultList=new ArrayList<String>();
		//如果上行线中包含起始站点和终止站点则返回查询到的路线图
		if(list.contains(from)&&list.contains(to)){
			System.out.println("包含起始");
			s = list.toArray(new String[]{});   
			System.out.println("s:"+s);
			for(int i=0;i<s.length;i++){//遍历数组拿到起始路线和终止路线的数组
				resultList.add(s[i]);//给结果集合赋值，
				if(s[i].equals(to)){
					break;
				}
				
			}
			return resultList.toArray(new String[]{});
		}
		System.out.println("----------相反方向打印路线");
		//拿到该站点的相反方向的所有的站点
		List<String> list2=new ArrayList<String>();
		repeatFindDown(from, to, routeList, list2);
		if(list2.contains(from)&&list2.contains(to)){
			System.out.println("包含起始2");
			s = list2.toArray(new String[]{});   
			System.out.println("s:"+s);
			int j=0;
			for(int i=0;i<s.length;i++){//遍历数组拿到起始路线和终止路线的数组
				resultList.add(s[i]);//给结果集合赋值，
				if(s[i].equals(to)){
					break;
				}
				
			}
		}
		
		return resultList.toArray(new String[]{});
	}
	/**
	 * 这是一个递归的操作用来查找每一条线路上的所有的站点
	 * @param from 起始站点
	 * @param to 结束站点
	 * @param routeList 从数据库中查询得到的所有的每一个id所对应的站点集合
	 * @param str 用来保存一组站点的字符串集
	 */
	public void  repeatFind(String from,String to,List<Route> routeList,List<String> 
		list	){
		for(Route route:routeList){
			//先遍历上行线路
			if(from.equals(route.getStation_name())){
				list.add(route.getStation_name());
				if(route.getNext()!=null)
				repeatFind(route.getNext(),to,routeList,list);
			}
		}
		
	}
	/**
	 * 采用递归调用的方式查找从起始站点到终止终点的路线
	 */
	public void  repeatFindDown(String from,String to,List<Route> routeList,List<String> 
	list	){
			for(Route route:routeList){
				//先遍历下行线路
				if(from.equals(route.getStation_name())){
					list.add(route.getStation_name());
					if(route.getPrev()!=null)
						repeatFindDown(route.getPrev(),to,routeList,list);
				}
			}
			
		}

}
