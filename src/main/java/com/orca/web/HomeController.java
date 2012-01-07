package com.orca.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = "index.html")
	public ModelAndView index(){
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "home.html")
	public ModelAndView home(){
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/")
	public ModelAndView homeView() {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}

}
