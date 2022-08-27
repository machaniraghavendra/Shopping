package com.shop.life.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.life.entity.UserEntity;

@Repository
public interface UserRepo extends  JpaRepository<UserEntity, String>{

}
