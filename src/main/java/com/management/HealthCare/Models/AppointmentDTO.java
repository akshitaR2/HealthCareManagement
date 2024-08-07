package com.management.HealthCare.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.management.HealthCare.Entities.Doctors;

public class AppointmentDTO {
	
	private String patientId;
	private String department;
	private String location;
	private String doctorName;
	private String doctorAddress;
	private LocalDateTime startdate;
	private String status;
	private String reason;
	private int appointmentId;
	private String patients_name;
	private String patients_contact_info;
	
	
	public AppointmentDTO(String patientId, String department, String location,String reason) {
		super();
		this.patientId = patientId;
		this.department = department;
		this.location = location;
		this.reason=reason;
	}


	public AppointmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getPatientId() {
		return patientId;
	}


	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String city) {
		this.location = city;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public String getDoctorAddress() {
		return doctorAddress;
	}


	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}


	public LocalDateTime getStartdate() {
		return startdate;
	}


	public void setStartdate(LocalDateTime startdate) {
		this.startdate = startdate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getPatients_name() {
		return patients_name;
	}


	public void setPatients_name(String patients_name) {
		this.patients_name = patients_name;
	}

	public String getPatients_contact_info() {
		return patients_contact_info;
	}


	public void setPatients_contact_info(String patients_contact_info) {
		this.patients_contact_info = patients_contact_info;
	}


	public int getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}



	
}
