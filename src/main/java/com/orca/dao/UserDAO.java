package com.orca.dao;

import com.orca.domain.User;

public interface UserDAO {

	public void saveUser(User user);
	public void removeUser(User user);
	public User userNameExists(String username);
	public User getUserByUserName(String username);
	
}
