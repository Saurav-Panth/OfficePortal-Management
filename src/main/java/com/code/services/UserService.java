package com.code.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.code.dao.UserDao;
import com.code.entities.User;
import com.code.enums.Role;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public ModelAndView checkUser(String username,String password,String role) {
		ModelAndView mv = new ModelAndView();
		Optional<User> opt = userDao.getUserByUserNameAndPassword(username, password);
		if(opt.isPresent()) {
			
			if(Role.valueOf(role) == opt.get().getRole()) {
				switch (role) {
					case "ADMIN": {
						mv.setViewName("admin");
						mv.addObject("adminName",opt.get().getFirstName()+" "+opt.get().getLastName());
						List<User> list= userDao.getUsers();
						List<User> Activelist= userDao.getActiveUsers();
						mv.addObject("totalUsers",list.size());
						mv.addObject("activeUsers",Activelist.size());
						mv.addObject("totalDepartments",6);
						mv.addObject("users",list);
						return mv;
					}
					
				}
				
			}
			else {
				mv.setViewName("index");
		        mv.addObject("error", ""+opt.get().getUsername()+""+opt.get().getPassword()+""+opt.get().getRole()+""+role);
		        return mv;
			}
		}
		
		mv.setViewName("index");
        mv.addObject("error", "Invalid username or password");

		return mv;
		
		
	}
	
}
