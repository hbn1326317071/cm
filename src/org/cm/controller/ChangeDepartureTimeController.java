package org.cm.controller;

import org.cm.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChangeDepartureTimeController {
	@Autowired
	private CarService carService;
	@RequestMapping(value = "/changeDepartureTime.do",produces = "application/json;charset=utf-8")  
	@ResponseBody
	public String changeDepartureTime(int carId, long time){
		return Boolean.toString(carService.changeDepartureTime(carId, time));
	}
	
}
