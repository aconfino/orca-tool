package com.orca.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.orca.domain.Evaluation;
import com.orca.domain.User;
import com.orca.factory.EvaluationFactory;
import com.orca.service.UserService;
import com.orca.validator.UserValidator;

@ContextConfiguration( locations = { "/root-context.xml", "/db-config.xml", "/controllers.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTests {
	
	@Autowired
	UserService service;
	@Autowired
	UserValidator userValidator;
	@Autowired
	EvaluationFactory factory;
	Evaluation evaluation;
	Evaluation secondEvaluation;
	Errors errors;
	User user;
	User selectedUser;
	
	@Before
	public void setup(){
		user = populateUser();
	}

	@Test
	public void saveUser(){
		service.saveUser(user);
	}
	
	@Test
	public void getUser(){
		service.saveUser(user);
		selectedUser = service.getUserByUserName(user.getUsername());
		assertTrue(user.getUsername().equals(selectedUser.getUsername()));
		assertTrue(user.getPassword().equals(selectedUser.getPassword()));
		assertTrue(user.getIsAdmin()==(selectedUser.getIsAdmin()));
		Boolean userNameAvailable = service.userNameAvailable(user.getUsername());
		assertFalse(userNameAvailable);
	}
	
	@Test
	public void validateUser(){
		user = populateUser();
		userValidator.validate(user, errors);
		assertFalse(errors.hasErrors());
	}
	
	@Test
	public void incorrectEmail(){
		user = populateUser();
		user.setUsername("Hi_Mom!");
		userValidator.validate(user, errors);
		assertTrue(errors.hasErrors());
	}
	
	@Test
	public void incorrectPassword(){
		user = populateUser();
		user.setPassword("short");
		userValidator.validate(user, errors);
		assertTrue(errors.hasErrors());
	}
	
	@Test
	public void incorrectConfirmPassword(){
		user = populateUser();
		user.setConfirmPassword("OrcaRocks");
		userValidator.validate(user, errors);
		assertTrue(errors.hasErrors());
	}
	
	@Test
	public void testCreatingEvaluation(){
		user = populateUser();
		evaluation = factory.createEvalution();
		evaluation.setName("Test Evaluation #1");
		evaluation.setUser(user);
		user.addEvaluation(evaluation);
		service.saveUser(user);
		user = service.getUserByUserName(user.getUsername());
	}
	
	@Test
	public void testCreatingMultipleEvaluations(){
		Date date = new Date();
		String firstName = "Test Evaluation List #1 " + date.toString();
		String secondName = "Test Evaluation List #2 " + date.toString();
		user = populateUser();
		evaluation = factory.createEvalution();
		evaluation.setName(firstName);
		secondEvaluation = factory.createEvalution();
		secondEvaluation.setName(secondName);
		user.addEvaluation(evaluation);
		user.addEvaluation(secondEvaluation);
		service.saveUser(user);
		user = service.getUserByUserName(user.getUsername());
		assertTrue(user.getEvaluationSet().size()==2);
	}
	
	@After
	public void removeUser(){
		service.removeUser(user);
	}
	
	public User populateUser(){
		Date date = new Date();
		User user = new User();
		user.setUsername("aac" + date.getTime() + "@mailinator.com");
		user.setPassword("darthVadar");
		user.setConfirmPassword("darthVadar");
		errors = new BeanPropertyBindingResult(user, "user");
		return user;
	}
	
	public void setValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}
	
	
}
