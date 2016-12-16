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
	 * ��ѯ����·�ߵ�վ��
	 */
	@Override
	public HashMap<Integer,String[]> queryRoute(String from, String to) {
		/*��ѯ������ʼվ�㵽��ֹվ�����е�·�߲������ַ����������ʽ��������
		�˴����õ���ʽΪ������ѯÿһ��·�ߣ�Ȼ��ֱ��ÿ��վ�����Ϣ��������
		*/
		//��ѯ���ݿ������е�·��idȻ�����·��id����ѯÿһ��·�ߵĽ���������ڼ��ϵ���
		List<Route> list=routeDao.findAllId();
		List<Integer> allId=new ArrayList<Integer>();
		if(list.size()>0){
		for(Route route:list){
			if(!allId.contains(route.getCircuit_id())){
				allId.add(route.getCircuit_id());
			}
		}
		}
		//����·��id�ҳ����е�·��
		Map<Integer,String[]> result=new HashMap<Integer,String[]>();
		for(int i=0;i<allId.size();i++){
			String[] str=queryRoute(from, to, allId.get(i));
			
		result.put(allId.get(i), str);
	       
		}
		
		return (HashMap) result;
	}
	
	//��ѯ��һ����·�ϵ����� վ��
	public String[] queryRoute(String from,String to ,int id){
		if(from==null||to==null){
			return null;
		}
		if("".equals(from)||"".equals(to)){
			return null;
		}
		List<Route> routeList=routeDao.findById(id);
		System.out.println("--------·�ߴ�ӡ------------");
		//���贫���վ��������·��ͼ�о�����
		//���������ҵ�from ��to�����е�վ�㱣�浽�ַ���������
		List<String> list=new ArrayList<String>();
		repeatFind(from, to, routeList, list);
		String[] s=null;
		List<String> resultList=new ArrayList<String>();
		//����������а�����ʼվ�����ֹվ���򷵻ز�ѯ����·��ͼ
		if(list.contains(from)&&list.contains(to)){
			System.out.println("������ʼ");
			s = list.toArray(new String[]{});   
			System.out.println("s:"+s);
			for(int i=0;i<s.length;i++){//���������õ���ʼ·�ߺ���ֹ·�ߵ�����
				resultList.add(s[i]);//��������ϸ�ֵ��
				if(s[i].equals(to)){
					break;
				}
				
			}
			return resultList.toArray(new String[]{});
		}
		System.out.println("----------�෴�����ӡ·��");
		//�õ���վ����෴��������е�վ��
		List<String> list2=new ArrayList<String>();
		repeatFindDown(from, to, routeList, list2);
		if(list2.contains(from)&&list2.contains(to)){
			System.out.println("������ʼ2");
			s = list2.toArray(new String[]{});   
			System.out.println("s:"+s);
			int j=0;
			for(int i=0;i<s.length;i++){//���������õ���ʼ·�ߺ���ֹ·�ߵ�����
				resultList.add(s[i]);//��������ϸ�ֵ��
				if(s[i].equals(to)){
					break;
				}
				
			}
		}
		
		return resultList.toArray(new String[]{});
	}
	/**
	 * ����һ���ݹ�Ĳ�����������ÿһ����·�ϵ����е�վ��
	 * @param from ��ʼվ��
	 * @param to ����վ��
	 * @param routeList �����ݿ��в�ѯ�õ������е�ÿһ��id����Ӧ��վ�㼯��
	 * @param str ��������һ��վ����ַ�����
	 */
	public void  repeatFind(String from,String to,List<Route> routeList,List<String> 
		list	){
		for(Route route:routeList){
			//�ȱ���������·
			if(from.equals(route.getStation_name())){
				list.add(route.getStation_name());
				if(route.getNext()!=null)
				repeatFind(route.getNext(),to,routeList,list);
			}
		}
		
	}
	/**
	 * ���õݹ���õķ�ʽ���Ҵ���ʼվ�㵽��ֹ�յ��·��
	 */
	public void  repeatFindDown(String from,String to,List<Route> routeList,List<String> 
	list	){
			for(Route route:routeList){
				//�ȱ���������·
				if(from.equals(route.getStation_name())){
					list.add(route.getStation_name());
					if(route.getPrev()!=null)
						repeatFindDown(route.getPrev(),to,routeList,list);
				}
			}
			
		}

}
