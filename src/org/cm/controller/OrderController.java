package org.cm.controller;

import java.util.List;

import org.cm.entity.Order;
import org.cm.entity.OrderResult;
import org.cm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@RequestMapping(value = "/order.do",produces = "application/json;charset=utf-8")  
	@ResponseBody
	public OrderResult  order(String from ,String to,int currentLine,long startTime){
		OrderResult orderResult=orderService.order(from, to, currentLine, startTime);
		return orderResult;
		
	}
	@RequestMapping(value = "/findAllOrder.do",produces = "application/json;charset=utf-8")  
	@ResponseBody
	public List<Order> findAll(){
		List<Order> orderList=orderService.findAll();
		return orderList;
		
	}
	

}
