package com.management.HealthCare.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.HealthCare.Models.DoctorsDTO;
import com.management.HealthCare.Models.PatientsDTO;
import com.management.HealthCare.Models.RegisterDTO;
import com.management.HealthCare.Models.UserDto;
import com.management.HealthCare.Service.StaffRegisterService;

@RestController
@RequestMapping("/api/addStaff")
public class StaffController {
	
	@Autowired
	StaffRegisterService service;
	
	
	
//	@PreAuthorize("hasRole('ROLE_DOCTOR')")
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
	 
//	 @GetMapping("/user-info")
//	 public ResponseEntity<?> getUserInfo(@AuthenticationPrincipal Jwt jwt) {
//	     String username = jwt.getClaim("username");
//	     List<String> roles = jwt.getClaim("roles");
//	     // Use claims to personalize response or enforce authorization
//	     return ResponseEntity.ok().body(username+roles);
//	 }
	

}
