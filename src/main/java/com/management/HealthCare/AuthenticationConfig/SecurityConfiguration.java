package com.management.HealthCare.AuthenticationConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import com.management.HealthCare.AuthenticationConfig.Utilities.KeyProperties;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
public class SecurityConfiguration {

	private final KeyProperties rsaKeyProperty;
	
	
	public SecurityConfiguration(KeyProperties rsaKeyProperty) {
		super();
		this.rsaKeyProperty = rsaKeyProperty;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return new ProviderManager(provider);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(c->c.disable())
				.authorizeHttpRequests(auth->{
					auth.requestMatchers("/auth/**").permitAll();
					auth.requestMatchers("/**").hasRole("ADMIN");
					auth.requestMatchers("/api/addStaff/**").hasAnyRole("USER","STAFF");
					auth.requestMatchers("/api/appointment/**").hasAnyRole("PATIENT","DOCTOR","STAFF");
					auth.anyRequest().authenticated();
				})
				.oauth2ResourceServer(auth->auth.jwt(j-> j.jwtAuthenticationConverter(jwtAuthenticationConverter())))
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
	}
	
	@Bean
	public JwtDecoder decoder() {
		return NimbusJwtDecoder.withPublicKey(rsaKeyProperty.getPublickey()).build();
	}
	
	@Bean
	public JwtEncoder encoder() {
		JWK jwk=new RSAKey.Builder(rsaKeyProperty.getPublickey()).privateKey(rsaKeyProperty.getPrivateKey()).build();
		JWKSource<SecurityContext> source= new ImmutableJWKSet<>(new JWKSet(jwk));
		return new NimbusJwtEncoder(source);
	}
	
	@Bean
	public JwtAuthenticationConverter jwtAuthenticationConverter() {
		JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter=new JwtGrantedAuthoritiesConverter();
		jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("roles");
		jwtGrantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
		JwtAuthenticationConverter jwtAuthenticationConverter= new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
		return jwtAuthenticationConverter;
	}
	
}
