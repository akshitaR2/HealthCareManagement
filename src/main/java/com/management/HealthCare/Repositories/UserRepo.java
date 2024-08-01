package com.management.HealthCare.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.HealthCare.Entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

//	User findByUniqueId(String uniqueId);
	Optional<User> findByUniqueId(String uniqueId);
	boolean existsByUniqueId(String uniqueId);
	Optional<User> findByUsername(String username);

	
}
