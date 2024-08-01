package com.management.HealthCare.ServiceImpls;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.management.HealthCare.AuthenticationConfig.TokenService;
import com.management.HealthCare.Mappers.MapperConfig;
import com.management.HealthCare.Models.LoginDTO;
import com.management.HealthCare.Models.RegisterDTO;
import com.management.HealthCare.Repositories.UserRepo;
import com.management.HealthCare.Service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private MapperConfig mapper;
	
	@Autowired
	private AuthenticationManager authmanager;
	
	@Autowired
	private TokenService tokenservice;

	@Override
	@Transactional
	public String registerUser(RegisterDTO dto) {
		if(userRepo.existsByUniqueId(dto.getUniqueId())) 
			return "user exists";
		userRepo.save(mapper.getUser(dto));
		return"registered";
	}

	@Override
	public String loginUser(LoginDTO dto) {
		Authentication auth= authmanager.authenticate( new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
		String token =tokenservice.generateToken(auth);
		return token;	
		
	}

}
