package com.mongodemo.demoservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mongodemo.demoservice.model.User;
import com.mongodemo.demoservice.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	private UserRepo userRepo;

	@Autowired
	public UserServiceImpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public User register(User user) {
		return userRepo.save(user);
	}

	@Override
	public User login(User user) {
		return userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
	}

	
}
