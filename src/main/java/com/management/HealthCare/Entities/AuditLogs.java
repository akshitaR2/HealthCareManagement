package com.management.HealthCare.Entities;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "audit_logs")
public class AuditLogs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
//	private String user_id; // Identifier of the user performing the action.
	private String entity_type; // Type of entity (e.g., Patients, Appointments) affected.
	private String entity_id; // Identifier of the affected entity (e.g., patient_id, appointment_id).
	private String action; // Type of action performed (e.g., create, read, update, delete).
	@Column(name = "details", columnDefinition = "TEXT")
	private String details; //Additional details about the action (e.g., specific fields updated)
	
	@Column(name = "updatedTime", nullable = false)
	private Timestamp  createdTime;
	@Column(name = "userID", nullable = false)
	private String userID;
	 @PrePersist
	    protected void onCreate() {
	        this.createdTime = new Timestamp(System.currentTimeMillis());
	    }
	
	
	public AuditLogs() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AuditLogs( String entity_type, String entity_id, String action, String details, String userID) {
		super();
		this.entity_type = entity_type;
		this.entity_id = entity_id;
		this.action = action;
		this.details = details;
		this.userID = userID;
	}
	
	
	
}
