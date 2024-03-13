package com.bway.SpringCoreDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.SpringCoreDemo.model.User;
import com.bway.SpringCoreDemo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class userController {
	
	@Autowired
	private UserService userService;
		@GetMapping({"/","/login"})
		public String getLogin() {
			return "login";
		}
		
		
		@PostMapping("/login")
		public String postLogin(@ModelAttribute User user,Model model,HttpSession session) {
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));

			User usr = userService.UserLogin(user.getEmail(), user.getPassword());
			if(usr != null) {
				session.setAttribute("validuser", usr);
				session.setMaxInactiveInterval(120);
				//model.addAttribute("uname",usr.getFname());
				return "home";
			}	
			{
			
			
         model.addAttribute("error", "Invalid email or password"); // Add error message
	        return "login"; // Return login page
	        }

		}
		@GetMapping("/signup")
		public String getSignup() {
			
			return "signup";
		}
		@PostMapping("/signup")
		public String postSignup(@ModelAttribute User user) {
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			userService.UserSignup(user);
			return "login";
		}
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "login";
		}
		
}
