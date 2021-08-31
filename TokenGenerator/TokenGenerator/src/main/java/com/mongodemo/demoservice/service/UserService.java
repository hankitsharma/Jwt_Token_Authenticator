package com.mongodemo.demoservice.service;

import java.util.List;

import com.mongodemo.demoservice.model.User;

public interface UserService {

	User register(User user);
	User login(User user);
}
