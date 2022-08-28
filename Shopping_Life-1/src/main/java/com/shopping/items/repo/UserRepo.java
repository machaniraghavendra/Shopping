package com.shopping.items.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopping.items.entity.UserEntity;

@Repository
public interface UserRepo extends  JpaRepository<UserEntity, String>{

}
