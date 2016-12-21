package org.cm.controller;

import org.cm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetIncomePeriodController {
	
	@Autowired
	private OrderService orderService;
	@RequestMapping(value = "/getIncomePeriod.do",produces = "application/json;charset=utf-8")  
	@ResponseBody
	public double getIncomePeriod(String startTime,String endTime){
		return orderService.getIncomePeriod(startTime, endTime);
	}
}
