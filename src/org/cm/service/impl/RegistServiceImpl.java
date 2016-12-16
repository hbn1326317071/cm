package org.cm.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.cm.dao.UserDao;
import org.cm.entity.User;
import org.cm.service.RegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class RegistServiceImpl implements RegistService{
	@Autowired
	private  UserDao  userDao;

	@Override
	public String regist(String username, String password,String usertype) {
		//注册前判断用户名是否存在，如果存在则返回false
		User user=userDao.findByName(username);
		if(user!=null){
			return "no";
		}else{
			//数据库中没有这个用户 名，则表示这个用户名可以被注册,下面代码执行注册操作
			 user=new User();
			user.setName(username);
			user.setPwd(DigestUtils.md5Hex(password));
			user.setState("0");
			user.setType(usertype);
			try{
			userDao.save(user);
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("出错了");
			}return "yes";
		}
		
		
		
	}

}
