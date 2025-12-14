package com.code.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.entities.User;
import com.code.repos.UserRepo;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepo userRepo;
	
	public Optional<User> getUserByUserNameAndPassword(String username,String password){
		return userRepo.findByUsernameAndPassword(username, password);
	}
	
	
	public List<User> getUsers(){
		return userRepo.findAll();
		
	}
	
	public List<User> getActiveUsers(){
		return userRepo.findByActiveTrue();
		
	}
	
	

}
