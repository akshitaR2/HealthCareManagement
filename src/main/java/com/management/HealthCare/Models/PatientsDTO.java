package com.management.HealthCare.Models;


public class PatientsDTO {
	private String username;
	private String password;
	private String emailId;
	private String role;
	private String patientId;
	
	private String patientName;
	private String date_of_birth;
	private String location;
	private String contact_info;
	private String address;
	private String insurance_info;
	private String emergency_contact;
	public PatientsDTO(String username, String password, String emailId, String role, String patientId,
			String patientName, String location, String contact_info) {
		super();
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.role = role;
		this.patientId = patientId;
		this.patientName = patientName;
		this.location = location;
		this.contact_info = contact_info;
	}
	public PatientsDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContact_info() {
		return contact_info;
	}
	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInsurance_info() {
		return insurance_info;
	}
	public void setInsurance_info(String insurance_info) {
		this.insurance_info = insurance_info;
	}
	public String getEmergency_contact() {
		return emergency_contact;
	}
	public void setEmergency_contact(String emergency_contact) {
		this.emergency_contact = emergency_contact;
	}
	
	
	

}
