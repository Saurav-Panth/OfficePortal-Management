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
	
	public void saveUser(User user){
		userRepo.save(user);
		
	}
	
	public List<User> getRecentUser(){
		return userRepo.findTop6ByLastLoginIsNotNullOrderByLastLoginDesc();
	}
	
	public Optional<User> getUsersById(long id){
		return userRepo.findById(id);
	}
	
	public List<User> getUsersByName(String name){
		return userRepo.findByUsername(name);
	}
	
	

}
