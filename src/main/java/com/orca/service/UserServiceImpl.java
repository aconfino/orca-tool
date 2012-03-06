package com.orca.service;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
		if (emailAvailable(user.getUsername())){
			updateUserPassword(user);  // if the email is available, it's a new user
		} else {										 // encrypt their password
			saveExistingUser(user);
		}
	}
	
	public void updateUserPassword(User unsavedUser){
		unsavedUser.setPassword(encryptString(unsavedUser.getPassword()));
		unsavedUser.setConfirmPassword(encryptString(unsavedUser.getConfirmPassword()));
		dao.saveUser(unsavedUser);
	}
	
	public void saveExistingUser(User user){
		dao.saveUser(user);
	}
	
	public Boolean emailAvailable(String userName){
		User user = dao.userNameExists(userName);
		if (user != null){
			return false;
		}
		else {
			return true;
		}
	}

	public void removeUser(User user) {
		dao.removeUser(user);
	}
	
	public String getRandomString() {
		    StringBuffer randomString = new StringBuffer(10);
		    int next = RandomUtils.nextInt(13) + 8;
		    randomString.append(RandomStringUtils.randomAlphanumeric(next));
		    return randomString.toString();
	}

	public String resetUserPassword(User user) {
		String password = getRandomString();
		user.setPassword(password);
		user.setConfirmPassword(password);
		updateUserPassword(user);	  // encrypt the new password
		return password;
	}
	
	public String encryptString(String unencriptedString){
		return new Md5PasswordEncoder().encodePassword(unencriptedString, null);
	}

	public Boolean authenticatedUser() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!username.contentEquals("anonymousUser")) {
			return true;
		}
		return false;
	}

	public String getUsernameFromSecurityContext() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		for (GrantedAuthority authority : user.getAuthorities())
			if (("ROLE_USER").equals(authority.getAuthority())) {
				return user.getUsername();
			}
		return null;
	}

}
