package com.management.HealthCare.Entities;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointements",indexes = {
		 @Index(name = "idx_doctor_date", columnList = "doctor_uniqueid, startTime")
})
public class Appointements {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_uniqueid")
	private Patients patient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_uniqueid")
	private Doctors doctor;
	private LocalDateTime startTime;
    private LocalDateTime endTime;
	private String status;
	private String reason;
	
	 @CreationTimestamp
	    @Column(updatable = false, name = "created_at")
	    private Date createdAt;

	    @UpdateTimestamp
	    @Column(name = "updated_at")
	    private Date updatedAt;
	

	public Appointements(Patients patient, Doctors doctor, LocalDateTime startTime, LocalDateTime endTime,
			String status, String reason) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.reason = reason;
	}

	public Appointements() {
		super();
		// TODO Auto-generated constructor stub
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

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
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
	
	
	
}
