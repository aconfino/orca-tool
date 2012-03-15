package com.orca.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orca.domain.User;
import com.orca.form.ResetPasswordForm;
import com.orca.service.EmailService;
import com.orca.service.UserService;
import com.orca.validator.ChangePasswordValidator;
import com.orca.validator.ResetPasswordFormValidator;
import com.orca.validator.UserValidator;

@SessionAttributes({ "user", "resetPasswordForm"})
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	public UserValidator userValidator;
	@Autowired
	private ChangePasswordValidator changePasswordValidator;
	@Autowired
	private EmailService emailService;
	@Autowired
	private ResetPasswordFormValidator resetPasswordFormValidator;

	public void setValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}

	@RequestMapping(value = "login.html")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "createAccount.html")
	public ModelAndView createAccount() {
		ModelAndView mav = new ModelAndView("createAccount");
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "saveUser.html")
	public ModelAndView saveUser(@ModelAttribute("user") User user, BindingResult result) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("createAccount");
			mav.addObject("user", user);
			return mav;
		}
		userService.saveUser(user);
		ModelAndView mav = new ModelAndView("myAccount");
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "myAccount.html")
	public ModelAndView myAccount() {
		if (userService.authenticatedUser()) {
				ModelAndView mav = new ModelAndView("myAccount");
				mav.addObject("user", userService.getUserByUserName(userService.getUsernameFromSecurityContext()));
				return mav;
		}
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}

	@RequestMapping(value = "resetPassword.html")
	public ModelAndView resetPassword() {
		ModelAndView mav = new ModelAndView("resetPassword");
		mav.addObject("resetPasswordForm", new ResetPasswordForm());
		return mav;
	}

	@RequestMapping(value = "resetPasswordVerify.html")
	public ModelAndView resetPasswordVerify(@ModelAttribute("resetPasswordForm") ResetPasswordForm form, BindingResult result, HttpServletRequest request) {	
		resetPasswordFormValidator.validate(form, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("resetPassword");
			mav.addObject("form", form);
			return mav;
		}
		User user = userService.getUserByUserName(form.getEmail());
		String newPassword = userService.resetUserPassword(user);
		emailService.sendEmail(form.getEmail(), resetPasswordSubject(), resetPasswordBody(newPassword));
		return new ModelAndView("resetPasswordConfirmation");
	}
	
	@RequestMapping(value = "changePassword.html")
	public ModelAndView changePassword(){
		if (userService.authenticatedUser()) {
			ModelAndView mav = new ModelAndView("changePassword");
			mav.addObject("user", userService.getUserByUserName(userService.getUsernameFromSecurityContext()));
			return mav;
		}
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}
	
	@RequestMapping(value = "changePasswordVerify.html")
	public ModelAndView changePasswordVerify(@ModelAttribute("user") User user, BindingResult result){
		changePasswordValidator.validate(user, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("changePassword");
			mav.addObject("user", user);
			return mav;
		}
		userService.updateUserPassword(user);
		ModelAndView mav = new ModelAndView("myAccount");
		mav.addObject("user", user);
		return mav;
		
	}
	
	public String resetPasswordSubject(){
		return new String("Your password has been reset");
	}
	
	public String resetPasswordBody(String password){
		return new String("Thank you for using the ORCA (Open Source Rapid Analysis) tool.  \n\n"
			+ "Your password has been changed to " + password + ". \n\n "
			+ "Please log into your account and change your password as soon as possible by going to http://localhost:8080/"
			+ ".  \n\n Many thanks. \n The ORCA Team.");
	}

}
