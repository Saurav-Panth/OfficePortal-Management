package com.code.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.code.dao.UserDao;
import com.code.entities.User;

@Service
public class AdminService {
	
	@Autowired
	private UserDao userDao;
		
	
	public ModelAndView getDashBoardData() {
		ModelAndView mv = new ModelAndView("admin");
		
		List<User> list= userDao.getUsers();
		List<User> Activelist= userDao.getActiveUsers();
		List<User> Recentlist= userDao.getRecentUser();
		mv.addObject("totalUsers",list.size());
		mv.addObject("activeUsers",Activelist.size());
		mv.addObject("totalDepartments",6);
		mv.addObject("users",Recentlist);
		return mv;
	}
	
	public ModelAndView getUserForAdminData() {
		ModelAndView mv = new ModelAndView("adminUsers");
		mv.addObject("users",userDao.getUsers());
//		mv.addObject("error", "User not found or already deleted");
		
		
		
		return mv;
	}

	public ModelAndView getUserForAdminDataSearch(String keyword) {
		
		ModelAndView mv = new ModelAndView("adminUsers");
		try {
			long id = Long.parseLong(keyword);
			System.err.println(id);
			Optional<User> opt = userDao.getUsersById(id);
			if(!opt.isEmpty()) {
				mv.addObject("users",opt.get());
				return mv;
			}
			else {
				mv.addObject("error", "User ID not found or already deleted");
				return mv;
			}
		
		}
		catch(Exception e){
			List<User> opt = userDao.getUsersByName(keyword);
			System.err.println(opt);
			if(opt.size()>0) {
				mv.addObject("users",opt);
				return mv;
			}
			else {
				mv.addObject("error", "UserName not found or already deleted");
				return mv;
			}
		}
		
		
	}
	
	

}
