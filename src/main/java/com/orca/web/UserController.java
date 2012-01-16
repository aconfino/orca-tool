package com.orca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.orca.validator.ResetPasswordFormValidator;
import com.orca.validator.UserValidator;

@SessionAttributes({ "user", "resetPasswordForm" })
@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserValidator userValidator;
	@Autowired
	ResetPasswordFormValidator resetPasswordValidator;
	@Autowired
	EmailService emailService;

	public void setValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}

	@RequestMapping(value = "login.html")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = "createAccount.html")
	public ModelAndView createAccount() {
		ModelAndView mav = new ModelAndView("createAccount");
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "saveUser.html")
	public ModelAndView saveUser(@ModelAttribute("user") User user,
			BindingResult result) {
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
		String username = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		if (!username.contentEquals("anonymousUser")) {
			User user = (User) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			for (GrantedAuthority authority : user.getAuthorities())
				if (("ROLE_USER").equals(authority.getAuthority())) {
					ModelAndView mav = new ModelAndView("myAccount");
					mav.addObject("user",
							userService.getUserByUserName(username));
					return mav;
				}
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
	public ModelAndView resetPasswordVerify(@ModelAttribute("resetPasswordForm") ResetPasswordForm form, BindingResult result) {
		
		resetPasswordValidator.validate(form, result);
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
	
	public String resetPasswordSubject(){
		String subject = "Your password has been reset";
			return subject;
	}
	
	public String resetPasswordBody(String password){
		String body = "Thank you for using the ORCA (Open Source Rapid Analysis) tool.  \n\n"
			+ "Your password has been changed to " + password + ". \n\n "
			+ "Please log into your account and change your password as soon as possible by going to http://localhost:8080/"
			+ ".  \n\n Many thanks. \n The ORCA Team.";
		return body;
	}

}
