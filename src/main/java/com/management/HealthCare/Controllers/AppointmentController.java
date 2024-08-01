package com.management.HealthCare.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.management.HealthCare.Models.AppointmentDTO;
import com.management.HealthCare.Service.AppointmentService;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
	@Autowired
	AppointmentService service;
	
	
//	@GetMapping("/book/{patientId}/{specialty}/{city}")
//	public ResponseEntity<String> bookAppointment(
//	        @PathVariable String patientId,
//	        @PathVariable String specialty,
//	        @PathVariable String city){
//			return ResponseEntity.ok().body
//					(service.bookAppointment(patientId,specialty,city));
//	}	
	
	@GetMapping("/bookAppointment")
	public ResponseEntity<AppointmentDTO> bookAppointment(@RequestBody AppointmentDTO dto){
		
		return ResponseEntity.ok().body(service.bookAppointment(dto));
	}
	
	@GetMapping("/getPatientAppointments/{patient_id}")
	public ResponseEntity<List<AppointmentDTO>> getPatientAppointments(@PathVariable String patient_id) {
	
			return ResponseEntity.ok().body(service.getPatientAppointments(patient_id));			

	}
	
	@GetMapping("/getDoctorAppointments/{doctors_id}")
	public ResponseEntity<List<AppointmentDTO>> getDoctorsAppointments(@PathVariable String doctors_id) {
	
			return ResponseEntity.ok().body(service.getDoctorsAppointments(doctors_id));			

	}
	
	@GetMapping("/getPatientOldRecords/{patient_id}")
	public ResponseEntity<List<AppointmentDTO>> getPatientRecords(@PathVariable String patient_id) {
		
			return ResponseEntity.ok().body(service.getPatientPastRecords(patient_id,"open"));			

	}
	
	@PostMapping("/updateStatus")
	public ResponseEntity<String> updateAppointment(@PathVariable String id,@PathVariable String status){
		
		return ResponseEntity.ok().body(service.updateAppointment(id, status));
	}
	
	
	   

}
