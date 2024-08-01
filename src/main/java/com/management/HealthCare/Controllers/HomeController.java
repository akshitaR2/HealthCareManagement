//package com.management.HealthCare.Controllers;
//
//import java.security.Principal;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class HomeController {
//
//	@GetMapping("/")
//	public String home() {
//
//		return "Home";
//	}
//
//	@GetMapping("/secureHome")
//		public String Secured(Principal principal) {
//			
//			return "Secured Home"+ principal.getName();
//		}
//
//	@PreAuthorize("hasAuthority('SCOPE_read')")
//	@GetMapping("/secure")
//	public String secure() {
//		return "This is secured!";
//	}
//}