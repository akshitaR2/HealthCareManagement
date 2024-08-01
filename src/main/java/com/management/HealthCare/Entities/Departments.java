//package com.management.HealthCare.Entities;
//
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "healthcare_departments")
//public class Departments {
//
//	@Id
//	@GeneratedValue (strategy = GenerationType.IDENTITY)
//	private int id;
//	private String departmentName;
//	private String location;
//	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
//	private List<Doctors> doctor;
//	
//}
