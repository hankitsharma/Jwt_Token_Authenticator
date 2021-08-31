package com.mongodemo.demoservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mongodemo.demoservice.model.User;


public interface UserRepo extends JpaRepository<User, String> {
 
	User findByPassword(String password);
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
}
