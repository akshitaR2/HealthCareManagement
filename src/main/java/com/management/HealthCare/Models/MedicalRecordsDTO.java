package com.management.HealthCare.Models;

import java.util.Date;

public class MedicalRecordsDTO {
	private String diagnosis;
	private String treatment;
	private String prescriptions;
	private String notes;
	private String status;
	private int appointementId;
	
	private String DoctorsName;
	private String VisitDate;
	
	public MedicalRecordsDTO(String diagnosis, String treatment, String prescriptions, String notes, String status,int appointementId) {
		super();
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.prescriptions = prescriptions;
		this.notes = notes;
		this.status = status;
		this.appointementId=appointementId;
	}

	
	public MedicalRecordsDTO() {
		super();
		// TODO Auto-generated constructor stub
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


	public int getAppointementId() {
		return appointementId;
	}


	public void setAppointementId(int appointementId) {
		this.appointementId = appointementId;
	}


	public String getDoctorsName() {
		return DoctorsName;
	}


	public void setDoctorsName(String doctorsName) {
		DoctorsName = doctorsName;
	}


	public String getVisitDate() {
		return VisitDate;
	}


	public void setVisitDate(String visitDate) {
		VisitDate = visitDate;
	}
	
	
	
}

