package com.bway.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.SpringProject.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	User findByUsernameAndPassword(String un, String psw); 

}
