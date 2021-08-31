package com.mongodemo.demoservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mongodemo.demoservice.model.User;


public interface UserRepo extends JpaRepository<User, String> {
 
}
