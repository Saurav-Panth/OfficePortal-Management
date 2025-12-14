package com.code.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.code.services.UserService;

@Controller
@RequestMapping
public class LoginController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ModelAndView checkUser(@RequestParam String username,@RequestParam String password,@RequestParam String role) {
		return userService.checkUser(username, password, role);
	}

}

