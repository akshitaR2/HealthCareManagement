package com.management.HealthCare.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.HealthCare.Models.AppointmentDTO;
import com.management.HealthCare.Models.PatientsDTO;
import com.management.HealthCare.Service.AppointmentService;
import com.management.HealthCare.Service.Patientservice;

@RestController
@RequestMapping("/api/patient")
public class PatientsController {

	@Autowired
	Patientservice service;
	


	@GetMapping("/getPatientInfo/{patientId}")
	public ResponseEntity<PatientsDTO> getPatientInfo(@PathVariable("patientId") String patientId) {
		
			return ResponseEntity.ok().body(service.getPatientInfo(patientId));			

	}

	
	
}
