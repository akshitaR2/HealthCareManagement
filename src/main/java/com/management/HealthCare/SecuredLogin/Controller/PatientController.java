package com.management.HealthCare.SecuredLogin.Controller;


	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.management.HealthCare.Models.AppointmentDTO;
import com.management.HealthCare.Models.MedicalRecordsDTO;
import com.management.HealthCare.Models.PatientsDTO;
import com.management.HealthCare.Service.AppointmentService;
import com.management.HealthCare.Service.Patientservice;


	@RestController
	@RequestMapping("/patient")
	@CrossOrigin("*")
	public class PatientController {
		
		@Autowired
		Patientservice service;
		
		@Autowired
		AppointmentService appservice;
		
		
		
		@GetMapping("/")
		public String testAdmin() {
			return "you have permission to access as PatientController ";
		}
		
		@GetMapping("/getPatientInfo/{patientId}")
		public ResponseEntity<PatientsDTO> getPatientInfo(@PathVariable("patientId") String patientId) {
			
				return ResponseEntity.ok().body(service.getPatientInfo(patientId));			

		}
		
		@GetMapping("/getMedicalRecords/{patientId}")
		public ResponseEntity<List<MedicalRecordsDTO>> getMedicalRecords(@PathVariable("patientId") String patientId) {
			
				return ResponseEntity.ok().body(service.getMedicalRecords(patientId));			

		}
		
		@PostMapping("/cancelAppointment/{appointmentId}")
		public ResponseEntity<String> cancelAppointment(@PathVariable int id){
			
			return ResponseEntity.ok().body(appservice.cancelAppointment(id));
		}
		
		
		@GetMapping("/bookAppointment")
		public ResponseEntity<AppointmentDTO> bookAppointment(@RequestBody AppointmentDTO dto){
			
			return ResponseEntity.ok().body(appservice.bookAppointment(dto));
		}
		
		@GetMapping("/getPatientAppointments/{patient_id}")
		public ResponseEntity<List<AppointmentDTO>> getPatientAppointments(@PathVariable String patient_id) {
		
				return ResponseEntity.ok().body(appservice.getPatientAppointments(patient_id));			

		}
		
		@GetMapping("/getPatientOldRecords/{patient_id}")
		public ResponseEntity<List<AppointmentDTO>> getPatientRecords(@PathVariable String patient_id) {
			
				return ResponseEntity.ok().body(appservice.getPatientPastAppointments(patient_id,"open"));			

		}

	}
