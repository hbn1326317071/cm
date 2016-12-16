package org.cm.controller;

import org.cm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@RequestMapping("/login")
	@ResponseBody
	public boolean  login(String username,String password,String usertype){
		System.out.println(username+":"+password);
		//TODO next we should complete the actual code
		boolean flag=loginService.login(username, password,usertype);
		System.out.println("登陆验证带调用完毕");
		return flag;
	}
	@RequestMapping("/exit")
	@ResponseBody
	public boolean logout(String username ){
		boolean flag=loginService.logout(username);
		return flag;
		
	}
	

}
