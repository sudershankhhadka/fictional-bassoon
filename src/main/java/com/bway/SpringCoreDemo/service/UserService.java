package com.bway.SpringCoreDemo.service;

import com.bway.SpringCoreDemo.model.User;

public interface UserService {
void UserSignup(User user);
User UserLogin(String email,String psw);
}
