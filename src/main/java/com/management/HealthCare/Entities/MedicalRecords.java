package com.management.HealthCare.Entities;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "medical_records")
public class MedicalRecords {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_uniqueid", referencedColumnName = "uniqueid")
	private Patients patient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_uniqueid" ,referencedColumnName = "uniqueid")
	private Doctors doctor;
	
	private LocalDateTime visit_date;
	private String diagnosis;
	private String treatment;
	private String prescriptions;
	private String notes;
	private String status;
	public MedicalRecords() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MedicalRecords(Patients patient, Doctors doctor, LocalDateTime visit_date, String diagnosis, String treatment,
			String prescriptions, String notes, String status) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.visit_date = visit_date;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.prescriptions = prescriptions;
		this.notes = notes;
		this.status = status;
	}
	public Patients getPatient() {
		return patient;
	}
	public void setPatient(Patients patient) {
		this.patient = patient;
	}
	public Doctors getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}
	public LocalDateTime getVisit_date() {
		return visit_date;
	}
	public void setVisit_date(LocalDateTime visit_date) {
		this.visit_date = visit_date;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(String prescriptions) {
		this.prescriptions = prescriptions;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
