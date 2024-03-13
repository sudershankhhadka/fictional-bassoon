package com.bway.SpringCoreDemo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.SpringCoreDemo.model.User;
import com.bway.SpringCoreDemo.repo.UserRepository;
import com.bway.SpringCoreDemo.service.UserService;




@Service
public class UserServiceImpl implements UserService{
	
	
	
	@Autowired
	private UserRepository userRepo;
	@Override
	public void UserSignup(User user) {
		userRepo.save(user);
	}

	@Override
	public User UserLogin(String email, String psw) {
		return userRepo.findByEmailAndPassword(email, psw);
	}

}
