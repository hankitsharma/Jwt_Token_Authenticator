package com.mongodemo.demoservice.controller;



import org.mongodemo.security.JwtTokenSecurity;
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
public class UserController {

	private UserService userService;
	private JwtTokenSecurity tokengen;
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
		tokengen = new JwtTokenSecurity();
	}
	 
	@PostMapping("/login")
    public ResponseEntity<?> listAllUser(@RequestBody User user ) {
		User use = userService.login(user);
		if(use == null) {
			return new ResponseEntity<>( userService.login(user), HttpStatus.CONFLICT); 
		}
        return new ResponseEntity<>(tokengen.tokenGenerator(user), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> save(@RequestBody User user) {
    	   return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
    }
}
