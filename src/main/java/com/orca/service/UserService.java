package com.orca.service;

import com.orca.domain.User;

public interface UserService {
	
	public void saveUser(User user);
	public void removeUser(User user);
	public User getUserByUserName(String userName);
	public Boolean emailAvailable(String userName);
	public String resetUserPassword(User user);
	public String getRandomString();
	public void updateUserPassword(User unsavedUser);
	public Boolean authenticatedUser();
	public String getUsernameFromSecurityContext();
	
}
