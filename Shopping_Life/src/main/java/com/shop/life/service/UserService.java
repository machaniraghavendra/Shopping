package com.shop.life.service;

import java.util.List;

import com.shop.life.entity.UserEntity;
import com.shop.life.exception.UserAlreadyExistsException;
import com.shop.life.exception.UserNotFoundException;

public interface UserService {

	String save(UserEntity userEntity) throws UserAlreadyExistsException;
	UserEntity find(String userEmail) throws UserNotFoundException;
	List<UserEntity> findall();
	String delete(String userEmail) throws UserNotFoundException;
	String update(UserEntity userEntity) throws UserNotFoundException;
	boolean check(String userEmail,String Password);
}
