package com.code.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.entities.User;
import java.util.List;
import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Long>{

	public Optional<User> findByUsernameAndPassword(String username,String password);
	
	public List<User> findByActiveTrue();


}
