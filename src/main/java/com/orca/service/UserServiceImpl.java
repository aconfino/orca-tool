package com.orca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import com.orca.dao.UserDAO;
import com.orca.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO dao;
	
	public User getUserByUserName(String userName) {
		return dao.getUserByUserName(userName);
	}

	public void saveUser(User user) {
		if (userNameAvailable(user.getUsername())){
			saveNewUser(user);
		} else {
			saveExistingUser(user);
		}
	}
	
	public void saveNewUser(User unsavedUser){
		String encryptedPassword = new Md5PasswordEncoder().encodePassword(unsavedUser.getPassword(), null);
		unsavedUser.setPassword(encryptedPassword);
		unsavedUser.setConfirmPassword(encryptedPassword);
		dao.saveUser(unsavedUser);
	}
	
	public void saveExistingUser(User user){
		dao.saveUser(user);
	}
	
	public Boolean userNameAvailable(String userName){
		User user = dao.userNameExists(userName);
		if (user != null)
			return false;
		else {
			return true;
		}
	}

	public void removeUser(User user) {
		dao.removeUser(user);
	}

}
