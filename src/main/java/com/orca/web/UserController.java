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
import com.orca.domain.UserValidator;
import com.orca.service.UserService;

@SessionAttributes({"user"})
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	UserValidator userValidator;
	
	public void setValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}
	
	@RequestMapping(value="login.html")
	public ModelAndView login(){
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value="createAccount.html")
	public ModelAndView createAccount(){
		ModelAndView mav = new ModelAndView("createAccount");
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping(value="saveUser.html")
	public ModelAndView saveUser(@ModelAttribute("user") User user, BindingResult result){		
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
	
	@RequestMapping(value="myAccount.html")
	public ModelAndView myAccount(){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!username.contentEquals("anonymousUser")){
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			for (GrantedAuthority authority : user.getAuthorities())
			if(("ROLE_USER").equals(authority.getAuthority())){
				ModelAndView mav = new ModelAndView("myAccount");
				mav.addObject("user", userService.getUserByUserName(username));
				return mav;
			}
		} 
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}

}
