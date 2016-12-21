package org.cm.controller;

import org.cm.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DistributeRoteToCarController {
	@Autowired
	private CarService carService;
	@RequestMapping(value = "/distributeRoteToCar.do",produces = "application/json;charset=utf-8")  
	@ResponseBody
	public String distributeRoteToCar(int circuitId, int carId){
		return Boolean.toString(carService.distributeRoteToCar(circuitId, carId));
	}
}
