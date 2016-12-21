package org.cm.controller;

import org.cm.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddStationController {
	@Autowired
	private StationService stationService;
	@RequestMapping(value = "/addStation.do",produces = "application/json;charset=utf-8")  
	@ResponseBody
	public String addStation(int circuitId, String stationName, String prev,
			String next){
		return Boolean.toString(stationService.addStation(circuitId, stationName, prev, next));
	}
}
