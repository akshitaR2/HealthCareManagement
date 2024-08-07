package com.management.HealthCare.SecuredLogin.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
	
	@GetMapping("/")
	public String testAdmin() {
		return "you have permission to access as admin ";
	}

}