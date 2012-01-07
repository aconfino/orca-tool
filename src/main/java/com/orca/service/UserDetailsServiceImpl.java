package com.orca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.orca.dao.UserDAO;
import com.orca.domain.User;

@Service("userDetailsService") 
public class UserDetailsServiceImpl implements  UserDetailsService {
	
	@Autowired
	private UserDAO dao;
	
    public UserDetails loadUserByUsername(String username) {
        User user =  dao.getUserByUserName(username);   
        return user;
    }

}
