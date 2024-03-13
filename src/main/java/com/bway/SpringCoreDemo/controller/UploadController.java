package com.bway.SpringCoreDemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@GetMapping("/upload")
	public String getUpload() {
		return "upload";
	}
	
	@PostMapping("/upload")
	public String postUpload(@RequestParam MultipartFile image,Model model) {
		
		if(!image.isEmpty()) {
			try {
			Files.copy(image.getInputStream(), Path.of("src/main/resources/static/Image/"+image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			model.addAttribute("message","upload success");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		model.addAttribute("message","upload failed");
		
		return "upload";
	}
}
