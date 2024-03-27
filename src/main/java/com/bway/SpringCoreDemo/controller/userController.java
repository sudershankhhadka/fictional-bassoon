package com.bway.SpringCoreDemo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.SpringCoreDemo.model.User;
import com.bway.SpringCoreDemo.service.UserService;
import com.bway.SpringCoreDemo.utils.VerifyRecaptcha;

import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;



@Log
@Controller
public class userController {
	
	
	
	
	@Autowired
	private UserService userService;
		@GetMapping({"/","/login"})
		public String getLogin() {
			return "login";
		}
		
		
		@PostMapping("/login")
		public String postLogin(@ModelAttribute User user,Model model,HttpSession session,@RequestParam("g-recaptcha-response") String gcapCode) throws IOException {
			if(VerifyRecaptcha.verify(gcapCode)) {
				
			
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));

			User usr = userService.UserLogin(user.getEmail(), user.getPassword());
			if(usr != null) {
				
				log.info("-----------user login success-----------");
				session.setAttribute("validuser", usr);
				session.setMaxInactiveInterval(120);
				//model.addAttribute("uname",usr.getFname());
				return "home";
			}
			else {
				log.info("--------------login failed-----------");
				model.addAttribute("error", "Invalid Credentials"); // Add error message
		        return "login"; // Return login page
			}
			
			}	
			
			log.info("--------------login failed-----------");
			model.addAttribute("error", "Are You Robot?"); // Add error message
	        return "login"; // Return login page

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
			log.info("----------logout success-------");
			session.invalidate();
			return "login";
		}
		
}
