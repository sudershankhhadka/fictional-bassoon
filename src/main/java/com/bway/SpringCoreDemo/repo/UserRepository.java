package com.bway.SpringCoreDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.SpringCoreDemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmailAndPassword(String email,String psw);
}
