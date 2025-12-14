package com.code.services;

import java.util.List;

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
	

}
