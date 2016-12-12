package org.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class LoginController {
	@RequestMapping("/login")
	@ResponseBody
	public String  login(String username,String password){
		System.out.println(username+":"+password);
		//TODO next we should complete the actual code
		
		return "false";
	}

}
