package com.management.HealthCare;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.management.HealthCare.Entities.Role;
import com.management.HealthCare.Repositories.RolesRepo;

//import com.management.HealthCare.SecuredLogin.Models.Role;
//import com.management.HealthCare.SecuredLogin.Repository.RoleRepo;


//import com.management.HealthCare.JWTConfig.RsaKey;

@SpringBootApplication
//@EnableConfigurationProperties(RsaKey.class)
public class HealthCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCareApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner run(RolesRepo roleRepository) {
//		return args ->{
//			 roleRepository.save(new Role("ADMIN"));
//			 roleRepository.save(new Role("USER"));
//			 roleRepository.save(new Role("STAFF"));
//			 roleRepository.save(new Role("PATIENT"));
//			 roleRepository.save(new Role("DOCTOR"));
//			
//		};
//	}

}
