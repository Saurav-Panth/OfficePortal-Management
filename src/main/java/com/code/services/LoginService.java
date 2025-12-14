package com.code.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.code.dao.UserDao;
import com.code.entities.User;
import com.code.enums.Role;

import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {
	
	@Autowired
	private UserDao userDao;

	public ModelAndView checkUser(String username,String password,String role,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Optional<User> opt = userDao.getUserByUserNameAndPassword(username, password);
		if(opt.isPresent()) {
			if(Role.valueOf(role) == opt.get().getRole()) {
				switch (role) {
					case "ADMIN": {
						session.setAttribute(
							    "adminName",
							    opt.get().getFirstName() + " " + opt.get().getLastName()
							);
						mv.setViewName("redirect:/admin/dashboard");	
						return mv;
					}
					
				}
				
			}
			else {
				mv.setViewName("login");
		        mv.addObject("error", "Invalid Role");
		        return mv;
			}
		}
		
		mv.setViewName("login");
        mv.addObject("error", "Invalid username or password");

		return mv;
		
		
	}
	
}
