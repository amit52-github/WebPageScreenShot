package com.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.service.WebPageScreenShotServiceImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") 
public class WebPageScreenShotController {

	@Autowired
	WebPageScreenShotServiceImpl screenShotService;
	
	
	@PostMapping("/screenshot")
	public String screenshot(@RequestBody String  req){
		
		
		return screenShotService.capture(req);
		
	}
	
	
	
}
