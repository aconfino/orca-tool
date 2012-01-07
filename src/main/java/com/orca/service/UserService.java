package com.orca.service;

import com.orca.domain.User;

public interface UserService {
	
	public void saveUser(User user);
	public void removeUser(User user);
	public User getUserByUserName(String userName);
	public Boolean userNameAvailable(String userName);

}
