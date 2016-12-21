package org.cm.controller;

import org.cm.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddRouteController {
	@Autowired
	private StationService stationService;
	@RequestMapping(value = "/addRoute.do",produces = "application/json;charset=utf-8")  
	@ResponseBody
	public String addRoute(String route){
		return Boolean.toString(stationService.addRoute(route));
	}
}
