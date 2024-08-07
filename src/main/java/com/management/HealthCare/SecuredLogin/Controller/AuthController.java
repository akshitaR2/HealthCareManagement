package com.management.HealthCare.SecuredLogin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.HealthCare.Models.LoginDTO;
import com.management.HealthCare.Models.RegisterDTO;
//import com.management.HealthCare.SecuredLogin.Models.User;
import com.management.HealthCare.Service.AuthService;
//import com.management.HealthCare.SecuredLogin.UserAuthentication.AuthService;


	@RestController
	@RequestMapping("/auth")
	@CrossOrigin("*")   //to allow for specific request type. check needy greedy 
	
	public class AuthController {
//		
//		@Autowired
//		private AuthService authservice;
		
		@Autowired
		private AuthService authservice;
		
		@PostMapping("/register")
		public String register(@RequestBody RegisterDTO dto ) {
	
			return authservice.registerUser(dto );
			
		}
		
		
		@PostMapping("/login")
		public String login(@RequestBody LoginDTO dto ) {
			return authservice.loginUser(dto );
			
		}
		

	}
