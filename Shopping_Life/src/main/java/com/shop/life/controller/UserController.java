package com.shop.life.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.life.entity.UserEntity;
import com.shop.life.exception.UserAlreadyExistsException;
import com.shop.life.exception.UserNotFoundException;
import com.shop.life.repo.UserRepo;
import com.shop.life.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController{

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping("/")
	public ResponseEntity<String> save(@RequestBody UserEntity userEntity) throws UserAlreadyExistsException{
		return new ResponseEntity<String>(userServiceImpl.save(userEntity),HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<String> update(@RequestBody UserEntity userEntity) throws UserNotFoundException{
		return new ResponseEntity<String>(userServiceImpl.update(userEntity),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String userEmail) throws UserNotFoundException{
		return new ResponseEntity<String>(userServiceImpl.delete(userEmail),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> find(@PathVariable("id") String userEmail) throws UserNotFoundException{ 
		return new ResponseEntity<UserEntity>(userServiceImpl.find(userEmail),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserEntity>> findall(){
		return new ResponseEntity<List<UserEntity>>(userServiceImpl.findall(),HttpStatus.OK);
	}
	
	@GetMapping("/{useremail}/{password}")
	public boolean check(@PathVariable("useremail") String userEmail ,@PathVariable("password") String userPassword){
		return userServiceImpl.check(userEmail, userPassword);
	}
	
 }
