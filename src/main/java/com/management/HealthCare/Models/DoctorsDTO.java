package com.management.HealthCare.Models;

import java.time.LocalTime;

public class DoctorsDTO {
	private String username;
	private String password;
	private String emailId;
	private String role;
	private String doctorId;
	
	private String docName;
	private String specialty;
	private int contact_info;
	private String location;
	private String address;
	private String department;
	
	private int office_hours;
	private LocalTime workStartTime = LocalTime.of(10, 0);
	private LocalTime workEndTime = LocalTime.of(12, 0);
	
	public DoctorsDTO() {
		
	}

	
	public DoctorsDTO(String username, String password, String emailId, String role, String doctorId, String docName,
			String specialty, int contact_info, String location, String address, String department) {
		super();
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.role = role;
		this.doctorId = doctorId;
		this.docName = docName;
		this.specialty = specialty;
		this.contact_info = contact_info;
		this.location = location;
		this.address = address;
		this.department = department;
	}
	
	



	public DoctorsDTO(String emailId, String docName, String specialty, int contact_info, String location,
			String address, String department, int office_hours, LocalTime workStartTime, LocalTime workEndTime) {
		super();
		this.emailId = emailId;
		this.docName = docName;
		this.specialty = specialty;
		this.contact_info = contact_info;
		this.location = location;
		this.address = address;
		this.department = department;
		this.office_hours = office_hours;
		this.workStartTime = workStartTime;
		this.workEndTime = workEndTime;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorsId) {
		this.doctorId = doctorsId;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public int getContact_info() {
		return contact_info;
	}
	public void setContact_info(int contact_info) {
		this.contact_info = contact_info;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getOffice_hours() {
		return office_hours;
	}
	public void setOffice_hours(int office_hours) {
		this.office_hours = office_hours;
	}
	public LocalTime getWorkStartTime() {
		return workStartTime;
	}
	public void setWorkStartTime(LocalTime workStartTime) {
		this.workStartTime = workStartTime;
	}
	public LocalTime getWorkEndTime() {
		return workEndTime;
	}
	public void setWorkEndTime(LocalTime workEndTime) {
		this.workEndTime = workEndTime;
	}
	
	
}
