package com.bway.SpringCoreDemo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.SpringCoreDemo.utils.MailUtils;

@Controller
public class ContactController {
	@Autowired
	private MailUtils mailUtil;
	
	@GetMapping("/contact")
	public String getContact() {
		return "contact";
	}
	
	@PostMapping("/contact")
	public String postContact(@RequestParam String toEmail,@RequestParam String subject,@RequestParam String message) {
		mailUtil.sendEmail(toEmail, subject, message);
		return "contact";
	}
}
