package com.management.HealthCare.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.HealthCare.Entities.Role;

@Repository
public interface RolesRepo extends JpaRepository<Role, Integer>{

	
	Optional<Role> findByAuthority(String string);
	

}
