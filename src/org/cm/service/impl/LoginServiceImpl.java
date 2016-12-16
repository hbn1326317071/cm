package org.cm.service.impl;

import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.aspectj.bridge.MessageUtil;
import org.cm.dao.UserDao;
import org.cm.entity.User;
import org.cm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class LoginServiceImpl  implements LoginService{
	@Autowired
	private UserDao userDao;

	@Override
	public boolean  login(String username, String password,String usertype) {
		System.out.println("mima:"+DigestUtils.md5Hex(password));
		//判断是否输入用户名
		if(username==null||"".equals(username)||usertype==null){
			return false;
		}
		//检验用户名是否合法
		User user=userDao.findByName(username)
;
		if(user==null){
			return false;
		}else if(!user.getPwd().equals( DigestUtils.md5Hex(password))||(!usertype.equals(user.getType()))){//判断输入的密码与数据库中的密码是否相同
			//如果不相同返回false 
			
			return false;
		}else{
			//否则将user的状态state置为Y
			
			userDao.updateState( username,"1");
			return true;
		}
	
		
		
	}

	@Override
	public boolean logout(String username) {
		try{
		userDao.updateState(username, "0");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
