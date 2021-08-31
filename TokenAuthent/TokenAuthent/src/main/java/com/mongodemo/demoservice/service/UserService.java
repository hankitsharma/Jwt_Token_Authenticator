package com.mongodemo.demoservice.service;

import java.util.List;

import com.mongodemo.demoservice.model.User;

public interface UserService {

	User addNewUser(User user);
	List<User> listAllUser();
}
