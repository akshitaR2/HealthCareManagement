package com.management.HealthCare.AuthenticationConfig;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.management.HealthCare.Repositories.UserRepo;

@Service
public class SecurityUserDetailService implements UserDetailsService {
	
	private final UserRepo repo;
	

	public SecurityUserDetailService(UserRepo repo) {
		super();
		this.repo = repo;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return repo.findByUniqueId(username).map(SecurityUser::new)
				.orElseThrow(()->new UsernameNotFoundException("invalid user")) ;
	}

}
