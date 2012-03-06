package com.orca.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orca.domain.User;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
	
	private HibernateTemplate template;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}
	
	@Transactional(readOnly = false)
	public void saveUser(User user) {
		template.saveOrUpdate(user);
	}

	@Transactional(readOnly = false)
	public void removeUser(User user) {
		template.delete(user);
	}
	
	@Transactional()
	@SuppressWarnings("unchecked")
	public User userNameExists(String username) {
		User user = null;
		List <User> list = template.find("from User where username = ? ", username);
		if (list.size() > 0){
			user = list.get(0);
		}
		return user;
	}


	@Transactional()
	@SuppressWarnings("unchecked")
	public User getUserByUserName(String username) {
		User user = null;
		List <User> list = template.find("from User where username = ? ", username);
		if (list.size() > 0){
			user = list.get(0);
			return user;
		}
		throw new UsernameNotFoundException(username);
	}

}
