package com.shopping.items.service;

import java.util.List;

import com.shopping.items.entity.UserEntity;
import com.shopping.items.exception.UserAlreadyExistsException;
import com.shopping.items.exception.UserNotFoundException;



public interface UserService {

	String save(UserEntity userEntity) throws UserAlreadyExistsException;
	UserEntity find(String userEmail) throws UserNotFoundException;
	List<UserEntity> findall();
	String delete(String userEmail) throws UserNotFoundException;
	String update(UserEntity userEntity) throws UserNotFoundException;
	boolean check(String userEmail,String Password);
}
