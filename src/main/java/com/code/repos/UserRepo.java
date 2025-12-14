package com.code.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.entities.User;


public interface UserRepo extends JpaRepository<User, Long>{

	public Optional<User> findByUsernameAndPassword(String username,String password);
	
	public List<User> findByActiveTrue();
	
	public List<User> findTop6ByLastLoginIsNotNullOrderByLastLoginDesc();


}
