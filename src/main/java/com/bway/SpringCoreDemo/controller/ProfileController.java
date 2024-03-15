package com.bway.SpringCoreDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
	
	@GetMapping("/profile")
	public String getProfile() {
		return "profile";
	}
	@PostMapping("/profile")
	public String postProfile() {
		return "profile";
	}
	
}
