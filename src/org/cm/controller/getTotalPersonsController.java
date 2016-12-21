package org.cm.controller;

import org.cm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class getTotalPersonsController {
	@Autowired
	private OrderService orderService;
	@RequestMapping(value = "/getPerson.do",produces = "application/json;charset=utf-8")  
	@ResponseBody
	public String getTotalPersons(String time){
		
		return String.valueOf(orderService.getOrdersOfPayByDate(time));		
	}
//	public static void main(String[] args) {
//		System.out.println(System.currentTimeMillis());
//	}
}
