package org.cm.controller;

import java.util.List;

import org.cm.entity.Car;
import org.cm.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class getCarsInfoByRunningTypeController {
	@Autowired
	private CarService carService;
	@RequestMapping(value = "/getCarsInfo.do",produces = "application/json;charset=utf-8")  
	@ResponseBody
	public List<Car> getCarsInfo(int runningType){
		return carService.getCarsInfoByRunningType(runningType);
	}
}
