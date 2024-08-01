//package com.management.HealthCare;
//
//
//	import org.junit.jupiter.api.BeforeEach;
//	import org.junit.jupiter.api.Test;
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//	import org.springframework.test.context.jdbc.Sql;
//
//import com.management.HealthCare.Entities.User;
//import com.management.HealthCare.Repositories.UserRepo;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//	import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//	@DataJpaTest
//	public class TestRepo {
//
//	    @Autowired
//	    private UserRepo authenticationRepository;
//
//	    // Set up test data
//	    @BeforeEach
//	    public void setUp() {
//	        User entity = new User();
//	        entity.setUsername("testuser");
//	        entity.setEmailId("test@mail.com");
//	        entity.setUniqueId("test123");
//	        entity.setPassword("password123");
//	        authenticationRepository.save(entity);
//	    }
//
//	    @Test
//	    public void testFindByUsername() {
//	        // Invoke repository method
//	        User foundEntity = authenticationRepository.findByUniqueId("test123");
//	        System.out.println("Found user: " + foundEntity.getUsername() + ", password:: " + foundEntity.getPassword());
//	        // Asserts
//	        assertNotNull(foundEntity);
//	        assertEquals("password123", foundEntity.getPassword());
//	    }
//	}
//
