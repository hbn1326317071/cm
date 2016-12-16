package org.cm.dao;

import org.cm.entity.User;

public interface UserDao {
	public User findByName(String name);

	public void updateState(String name,String state);
	public void save(User user);

}
