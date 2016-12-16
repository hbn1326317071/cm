package org.cm.service;

import java.util.HashMap;

import org.cm.entity.RouteOtherFindInfo;

public interface QueryRouteService {
	public HashMap<Integer,String[]> queryRoute(String from,String to);
	public String[] queryRoute(String from,String to ,int id);
}
