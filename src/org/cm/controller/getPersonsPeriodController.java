package org.cm.controller;

import org.cm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class getPersonsPeriodController {
	
	
	@Autowired
	private OrderService orderService;
	@RequestMapping(value = "/getPersonsPeriod.do",produces = "application/json;charset=utf-8")  
	@ResponseBody
	public int getPersonsPeriod(String startTime,String endTime){
		return orderService.getPersonsPeriod(startTime, endTime);
	}
}
