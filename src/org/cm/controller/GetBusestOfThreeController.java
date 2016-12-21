package org.cm.controller;

import java.util.HashMap;

import org.cm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetBusestOfThreeController {
	@Autowired
	private OrderService orderService;
	@RequestMapping(value = "/getBusestOfThree.do",produces = "application/json;charset=utf-8")  
	@ResponseBody
	public HashMap<String,Integer> getBusestOfThree(String startTime,String endTime){
		return orderService.getBusestOfThree(startTime, endTime);
	}
}
