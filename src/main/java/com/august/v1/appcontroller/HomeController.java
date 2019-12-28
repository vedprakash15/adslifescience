package com.august.v1.appcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	@Autowired 
	HttpSession httpSession;
	
	@RequestMapping(value ="/signup", method=RequestMethod.GET)
	public String SignUp() {
		System.out.println("hi signup");
		return "model";
	}
	@RequestMapping("/")
	public String index(Model model) {
		httpSession.invalidate();
		String salt = (String)httpSession.getAttribute("csrfPreventionSalt");
		System.out.println("Controller salt : " + salt);
		System.out.println("Home page loaded");
		return "index";
	}
}
