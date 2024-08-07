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
import com.management.HealthCare.Models.DoctorsDTO;
import com.management.HealthCare.Models.MedicalRecordsDTO;
import com.management.HealthCare.Service.AppointmentService;
import com.management.HealthCare.Service.DoctorService;
import com.management.HealthCare.Service.StaffService;


	@RestController
	@RequestMapping("/doctor")
	@CrossOrigin("*")
	public class DoctorController {
		
		@Autowired
		DoctorService service;
		
		@Autowired
		AppointmentService appService;
		
		@Autowired
		StaffService staffService;
		
		
		
		@GetMapping("/getDoctoInfo/{id}")
		public ResponseEntity<DoctorsDTO> getPatientInfo(@PathVariable("patientId") String id) {
			
				return ResponseEntity.ok().body(service.getDoctorsInfo(id));			

		}
		
		@GetMapping("/getMedicalRecords/{id}")
		public ResponseEntity<List<MedicalRecordsDTO>> getMedicalRecords(@PathVariable("patientId") String id) {
			
				return ResponseEntity.ok().body(service.getMedicalRecords(id));			

		}

		@PostMapping("/updateMedicalRecords")
		public ResponseEntity<String> updateStatus(@RequestBody MedicalRecordsDTO dto){
			staffService.startBilling(dto.getAppointementId());
			return ResponseEntity.ok().body(appService.updateStatus(dto));
		}
		
		@GetMapping("/getDoctorAppointments/{doctors_id}")
		public ResponseEntity<List<AppointmentDTO>> getDoctorsAppointments(@PathVariable String doctors_id) {
		
				return ResponseEntity.ok().body(appService.getDoctorsAppointments(doctors_id));			

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		@GetMapping("/")
		public String testAdmin() {
			return "you have permission to access as doctor ";
		}

	}
