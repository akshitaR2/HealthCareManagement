package com.management.HealthCare.SecuredLogin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.HealthCare.Models.DoctorsDTO;
import com.management.HealthCare.Models.PatientsDTO;
import com.management.HealthCare.Models.RegisterDTO;
import com.management.HealthCare.Service.StaffService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")

public class UserController {
	
	@Autowired
	StaffService service;
	
	
	@GetMapping("/")
	public String testUser() {
		return "you have permission to access user details";
	}
	
	
	@PostMapping("/addDoctor")
	public ResponseEntity<String> addDoctor(@RequestBody DoctorsDTO dto){
		
			return ResponseEntity.ok().body(service.addDoctor(dto));
			
	}
	
	
//	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody RegisterDTO dto){
		Boolean response =service.addUser(dto);
		if (response) 
			return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
		 else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Already exists");
	}
	
	
//	@PreAuthorize("hasRole('ROLE_PATIENT')")
	@PostMapping("/addPatient")
	public ResponseEntity<String> addPatient(@RequestBody PatientsDTO dto){
		Boolean response =service.addPatient(dto);
		if (response) 
			return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
		 else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Already exists");
	}
	
//	 @GetMapping("/userinfo")
//	    public String getUserInfo(@AuthenticationPrincipal OAuth2AuthorizedClient authorizedClient) {
//	        String accessToken = authorizedClient.getAccessToken().getTokenValue();
//	        // Use the access token to fetch user info from resource server
//	        // ...
//	        return "User info";
//	    }
	 

}
