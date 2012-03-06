package com.orca.service;

public interface EmailService {
	
	void sendEmail(String emailRecepient, String subject, String messageBody);

}
