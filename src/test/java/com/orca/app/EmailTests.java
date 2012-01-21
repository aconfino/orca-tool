package com.orca.app;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orca.service.EmailService;

@ContextConfiguration( locations = { "/root-context.xml", "/controllers.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailTests  {
	
	@Autowired
	EmailService service;
	
	@Test
	public void emailTest(){
		String messageBody = "This is a test message. \n\n  Oh yeah, and I rock. \n\n\n\n The Orca Project.";
		// don't want to get blacklisted for spam, so I'm running this sparingly
		//	service.sendEmail("aconfino@gmail.com", "This is a test", messageBody);
	}
	
	@Test
	public void emailTest2(){
		String messageBody = "The Orca Project is straight ballin'.";
		// don't want to get blacklisted for spam, so I'm running this sparingly
	//	service.sendEmail("aconfino@gmail.com", "This is a test", messageBody);
	}
		
}
