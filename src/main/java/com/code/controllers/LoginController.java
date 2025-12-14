package com.code.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.code.repos.UserRepo;
import com.code.services.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
public class LoginController {

    private final UserRepo userRepo;
	
	@Autowired
	private LoginService userService;

    LoginController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

	@PostMapping("/login")
	public ModelAndView checkUser(@RequestParam String username,@RequestParam String password,@RequestParam String role,HttpSession session) {
		return userService.checkUser(username, password, role,session);
	}
	
	@GetMapping("/login")
	public String checkUser() {
		return "login";
	}

}

