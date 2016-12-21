package org.cm.controller;

import org.cm.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddCarController {
	
	@Autowired
	private CarService carService;
	@RequestMapping(value = "/addCar.do",produces = "application/json;charset=utf-8")  
	@ResponseBody
	public String addCar(){
		return Integer.toString(carService.addCar());
	}
}
