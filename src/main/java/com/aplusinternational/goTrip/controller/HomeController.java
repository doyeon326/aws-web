package com.aplusinternational.goTrip.controller;

import java.io.IOException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aplusinternational.goTrip.service.S3Service;

import lombok.AllArgsConstructor;

/**
 * Handles requests for the application home page.
 */
@AllArgsConstructor
@Controller
public class HomeController {
	
	@Autowired
	S3Service s3_service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		System.out.println("in");
		s3_service.setS3Client();
	
		return "home";
	}
	
	@PostMapping("/upload")
	@ResponseBody
	public String upload (@RequestParam("data") MultipartFile multipartFile) throws IOException {
	
		return s3_service.upload(multipartFile, "static");
		
	}
	
}
