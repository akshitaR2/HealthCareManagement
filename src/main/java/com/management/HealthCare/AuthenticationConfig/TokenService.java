package com.management.HealthCare.AuthenticationConfig;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

	@Autowired 
	private JwtEncoder encoder;
	
	@Autowired
	private JwtDecoder decoder;
	
	public String generateToken(Authentication auth) {
		Instant now= Instant.now();
		 String scope = auth.getAuthorities().stream()
	                .map(GrantedAuthority::getAuthority)
	                .collect(Collectors.joining(" "));
	        JwtClaimsSet claims = JwtClaimsSet.builder()
	                .issuer("self") // indicating this service is issuing this token
	                .issuedAt(now)
//	                .expiresAt(now.plus(1, ChronoUnit.HOURS))
	                .subject(auth.getName())
	                .claim("roles", scope)
	                .build();
	        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	}
}