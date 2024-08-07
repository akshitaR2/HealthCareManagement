package com.management.HealthCare.Entities;

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
@Table(name = "billing_details")
public class BillRecords {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_uniqueid")
	private Patients patient;

	private double amount_due;
	private double amount_paid;
	private String insurance_covered;
	private Date due_date;
	private String status;
	public BillRecords() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillRecords(Patients patient, double amount_due, double amount_paid, String insurance_covered, Date due_date,
			String status) {
		super();
		this.patient = patient;
		this.amount_due = amount_due;
		this.amount_paid = amount_paid;
		this.insurance_covered = insurance_covered;
		this.due_date = due_date;
		this.status = status;
	}
	public Patients getPatient() {
		return patient;
	}
	public void setPatient(Patients patient) {
		this.patient = patient;
	}
	public double getAmount_due() {
		return amount_due;
	}
	public void setAmount_due(double amount_due) {
		this.amount_due = amount_due;
	}
	public double getAmount_paid() {
		return amount_paid;
	}
	public void setAmount_paid(double amount_paid) {
		this.amount_paid = amount_paid;
	}
	public String getInsurance_covered() {
		return insurance_covered;
	}
	public void setInsurance_covered(String insurance_covered) {
		this.insurance_covered = insurance_covered;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
