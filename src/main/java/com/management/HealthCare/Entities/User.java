package com.management.HealthCare.Entities;

import java.util.Collection;
import java.util.Set;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToMany(fetch = FetchType.EAGER) // eager tells to fetch authority as soon as we fetch user info
	 @JoinTable(
		        name="user_role_junction",
		        joinColumns = {@JoinColumn(name="user_id")},
		        inverseJoinColumns = {@JoinColumn(name="role_id")}
		    )
	private Set<Role> authorities;
	private String username;
	private String password;
	
	@Column(name = "uniqueId", unique = true,nullable = false)
	private String uniqueId;
	
	private String emailId;
	
	public User() {
		super();
	}
	
	
	public User(Set<Role> authorities, String username, String password, String uniqueId, String emailId) {
		super();
		this.authorities = authorities;
		this.username = username;
		this.password = password;
		this.uniqueId = uniqueId;
		this.emailId = emailId;
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

	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Set<Role> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}
	
	

	
	

}
