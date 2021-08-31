package com.mongodemo.demoservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodemo.demoservice.model.User;
import com.mongodemo.demoservice.service.UserService;

@RestController
@RequestMapping(value = "abc")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	 
	@GetMapping("/user")
    public ResponseEntity<?> listAllUser() {
		System.out.println("inside list all user");
        return new ResponseEntity<>(userService.listAllUser(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) {
		System.out.println("inside save all user");
    	        return new ResponseEntity<>(userService.addNewUser(user), HttpStatus.CREATED);
    }
}
