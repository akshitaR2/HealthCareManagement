package com.management.HealthCare.AuthenticationConfig;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.management.HealthCare.Entities.User;

public class SecurityUser implements UserDetails {
	
	private User user;
	

	public SecurityUser(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
			
		return user.getAuthorities();
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUniqueId();
	}

}
