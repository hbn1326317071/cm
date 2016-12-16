package org.cm.controller;

import org.cm.service.RegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class RegistController {
	@Autowired
	private  RegistService registService;
	@RequestMapping("/regist")
	@ResponseBody
	public String regist(String username,String password,String usertype){
	String result=	registService.regist(username, password, usertype);
	return result;
	}

}
