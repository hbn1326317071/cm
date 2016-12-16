package org.cm.service;

public interface LoginService {
	public boolean login(String username,String password,String usertype);
	public boolean logout(String username);
	

}
