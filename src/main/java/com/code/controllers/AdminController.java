package com.code.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.code.services.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/dashboard")	
	public ModelAndView admin(HttpSession session) {
		
	    ModelAndView mv = adminService.getDashBoardData();
	    mv.addObject("adminName", session.getAttribute("adminName"));
	    return mv;
	}
	
	
	@GetMapping("/users")
	public ModelAndView admin() {

	    return adminService.getUserForAdminData();
	}
	
	@GetMapping("/usersearch")
	public ModelAndView userSearch(@RequestParam String keyword) {
		
	    return adminService.getUserForAdminDataSearch(keyword);
	}

	
	

			
	
}


