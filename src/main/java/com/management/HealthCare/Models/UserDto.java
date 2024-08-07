package com.management.HealthCare.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class UserDto {

	private String username;
	private String password;
//	private String uniqueId;
//	private String emailId;
	private String role;
	
	
	
	public UserDto(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
//		this.uniqueId = uniqueId;
//		this.emailId = emailId;
		this.role = role;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
//	public String getUniqueId() {
//		return uniqueId;
//	}
//	public void setUniqueId(String uniqueId) {
//		this.uniqueId = uniqueId;
//	}
//	public String getEmailId() {
//		return emailId;
//	}
//	public void setEmailId(String emailId) {
//		this.emailId = emailId;
//	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
